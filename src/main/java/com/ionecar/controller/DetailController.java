package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.ionecar.domain.Compare;
import com.ionecar.service.CompareSerivce;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DetailController {
    private final CompareSerivce compareSerivce;

    @GetMapping("/myquote/detail")
    public String DetailPage(@RequestParam(value = "carSrn", required = false) Long carSrn, 
                           Model model) {
        List<Compare> compares = compareSerivce.selectCompareByCarSrn(carSrn);
        if(compares == null || compares.isEmpty()){
            return "myquote";
        }else{
            Compare compare = compares.get(0); // 첫 번째 결과 사용
            model.addAttribute("carClass", compare.getCarClass());
            model.addAttribute("carSubClass", compare.getCarSubClass());
            model.addAttribute("purchaseMethod", compare.getPurchaseMethod());
            model.addAttribute("purchasePeriod", compare.getPurchasePeriod());
            model.addAttribute("carPrice", compare.getCarPrice());
            model.addAttribute("optPrice", compare.getOptPrice());
            return "detail";
        }
    }
} 