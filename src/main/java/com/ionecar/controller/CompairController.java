package com.ionecar.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.ionecar.domain.Compair;
import com.ionecar.service.CompairSerivce;
import com.ionecar.mapper.CompairMapper;
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
public class CompairController {
    private final CompairSerivce compairSerivce;

    @GetMapping("/compair")
    public String CompairPage(@RequestParam(value = "edpsCsn", required = false) Long edpsCsn, @RequestParam(value = "carSrn", required = false) Long carSrn, Model model) {
        Compair compair = compairSerivce.selectCompairByEdpsCsnAndCarSrn(edpsCsn, carSrn);
        if(compair == null){
            return "myquote";
        }else{
            model.addAttribute("carClass", compair.getCarClass());
            model.addAttribute("carSubClass", compair.getCarSubClass());
            model.addAttribute("purchaseMethod", compair.getPurchaseMethod());
            model.addAttribute("purchasePeriod", compair.getPurchasePeriod());
            model.addAttribute("carPrice", compair.getCarPrice());
            model.addAttribute("optPrice", compair.getOptPrice());
        return "compair";
        }
    }
}
