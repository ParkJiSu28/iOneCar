package com.ionecar.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.ionecar.domain.Compare;
import com.ionecar.service.CompareSerivce;
import com.ionecar.mapper.CompareMapper;
import lombok.RequiredArgsConstructor;
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
    public String ComparePage(@RequestParam(value = "edpsCsn", required = false) Long edpsCsn, @RequestParam(value = "carSrn", required = false) Long carSrn, Model model) {
        Compare compare = compareSerivce.selectCompareByEdpsCsnAndCarSrn(edpsCsn, carSrn);
        if(compare == null){
            return "myquote";
        }else{
            model.addAttribute("carClass", compare.getCarClass());
            model.addAttribute("carSubClass", compare.getCarSubClass());
            model.addAttribute("purchaseMethod", compare.getPurchaseMethod());
            model.addAttribute("purchasePeriod", compare.getPurchasePeriod());
            model.addAttribute("carPrice", compare.getCarPrice());
            model.addAttribute("optPrice", compare.getOptPrice());
        return "compare";
        }
    }
}
