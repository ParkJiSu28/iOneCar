package com.ionecar.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;
import com.ionecar.service.MyQuoteService;
import com.ionecar.domain.MyQuote;

@Controller
//@RequestMapping("/myquote")
@RequiredArgsConstructor
public class MyquoteController {   
    private final MyQuoteService myQuoteService;

       // 내 견적함함을 반환하는 GET 매핑 추가
       @GetMapping("/myquote")
       public String myquotePage(@RequestParam(value = "edpsCsn", required = false) Long edpsCsn, Model model) {
            MyQuote myQuote = myQuoteService.selectMyQuoteByEdpsCsn(edpsCsn);
            System.out.println("Received edpsCsn param: " + edpsCsn);
            if(myQuote == null){
               System.out.println("myQuote is null");

                return "/login";
            }else{
               //System.out.println(myQuote);
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
               model.addAttribute("myquoteId", myQuote.getCarSrn());
               return "myquote"; // myquote.html 타임리프 템플릿 반환
            }
           }  
     }
