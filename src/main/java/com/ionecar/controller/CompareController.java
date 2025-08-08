package com.ionecar.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.ionecar.domain.Compare;
import com.ionecar.service.CompareSerivce;
import com.ionecar.mapper.CompareMapper;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;



@Controller
@RequiredArgsConstructor
public class CompareController {
    private final CompareSerivce compareSerivce;

    @GetMapping("/compare")
    public String ComparePage(@RequestParam(value = "carSrn", required = false) Long carSrn, Model model) {
        if (carSrn == null) {
            return "myquote";
        }
        
        compareSerivce.updateDealerCarSrn(carSrn, 1L); // 예시 dealerNo
        compareSerivce.updateDealerCarSrn(carSrn, 2L); // 예시 dealerNo
        
        compareSerivce.updateDealCarSrn(carSrn, 1L);   // 예시 dealerNo
        compareSerivce.updateDealCarSrn(carSrn, 2L);   // 예시 dealerNo
        
        List<Compare> compares = compareSerivce.selectCompareByCarSrn(carSrn);
        
        if(compares == null || compares.isEmpty()){
            return "myquote";
        }else{
            // 첫 번째 Compare 객체의 기본 정보를 모델에 추가
            Compare firstCompare = compares.get(0);
            model.addAttribute("carClass", firstCompare.getCarClass());
            model.addAttribute("carSubClass", firstCompare.getCarSubClass());
            model.addAttribute("purchaseMethod", firstCompare.getPurchaseMethod());
            model.addAttribute("purchasePeriod", firstCompare.getPurchasePeriod());
            model.addAttribute("carPrice", firstCompare.getCarPrice());
            model.addAttribute("optPrice", firstCompare.getOptPrice());
            
            // 모든 Compare 객체를 모델에 추가
            model.addAttribute("compares", compares);
            
            return "compare";
        }
    }
}
