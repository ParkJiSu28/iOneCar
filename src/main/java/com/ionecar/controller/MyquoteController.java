package com.ionecar.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;
import com.ionecar.service.MyQuoteService;
import com.ionecar.service.DealService;
import com.ionecar.domain.MyQuote;
import com.ionecar.domain.Deal;

@Controller
//@RequestMapping("/myquote")
@RequiredArgsConstructor
public class MyquoteController {   
    private final MyQuoteService myQuoteService;
    private final DealService dealService;

       // 내 견적함을 반환하는 GET 매핑 추가
       @GetMapping("/myquote")
       public String myquotePage(@RequestParam(value = "edpsCsn", required = false) Long edpsCsn, Model model) {
            List<MyQuote> myQuotes = myQuoteService.selectMyQuoteByEdpsCsn(edpsCsn);
            System.out.println("Received edpsCsn param: " + edpsCsn);
            if(myQuotes == null || myQuotes.isEmpty()){
               System.out.println("myQuotes is null or empty");

                return "/login";
            }else{
               // 첫 번째 차량의 정보를 사용 (가장 최근 차량)
               MyQuote myQuote = myQuotes.get(0);
               String purchaseMethodLabel = "기타";  // 기본값
               if ("I".equals(myQuote.getPurchaseMethod())) {
                  purchaseMethodLabel = "할부";
               } else if ("C".equals(myQuote.getPurchaseMethod())) {
                  purchaseMethodLabel = "현금";  // 예시, 다른값들에 대한 치환도 여기에 넣으세요
               }
               model.addAttribute("carClass", myQuote.getCarClass());
               model.addAttribute("carSubClass", myQuote.getCarSubClass());
               model.addAttribute("purchaseMethod", purchaseMethodLabel);
               model.addAttribute("purchasePeriod", myQuote.getPurchasePeriod());
               model.addAttribute("carSrn", myQuote.getCarSrn());
               model.addAttribute("edpsCsn", edpsCsn);
               model.addAttribute("myQuotes", myQuotes); // 모든 차량 정보도 전달
               return "myquote"; // myquote.html 타임리프 템플릿 반환
            }
           }  
           
       // 비교견적 POST 요청 처리
       @PostMapping("/myquote/compare")
       public String comparePage(@RequestParam("carSrn") Long carSrn, 
                                @RequestParam("edpsCsn") Long edpsCsn) {
            // carSrn과 edpsCsn을 받아서 compare 페이지로 리다이렉트
            return "redirect:/compare?carSrn=" + carSrn;
       }
       
       // 이스터에그: 상담중 상태 클릭 시 progress를 3으로 업데이트
       @PostMapping("/myquote/updateProgress")
       @ResponseBody
       public ResponseEntity<String> updateProgressToFinal(@RequestParam("carSrn") Long carSrn,
                                                           @RequestParam("edpsCsn") Long edpsCsn) {
           try {
               // 해당 carSrn의 모든 Deal을 progress 3으로 업데이트
               List<Deal> deals = dealService.getDealsByCarSrn(carSrn);
               
               if (deals != null && !deals.isEmpty()) {
                   for (Deal deal : deals) {
                       if ("2".equals(deal.getProgress())) { // 상담중 상태인 경우만
                           deal.setProgress("3");
                           dealService.updateDeal(deal);
                       }
                   }
                   return ResponseEntity.ok("SUCCESS");
               } else {
                   return ResponseEntity.badRequest().body("No deals found");
               }
           } catch (Exception e) {
               return ResponseEntity.internalServerError().body("Error updating progress");
           }
       }
}
