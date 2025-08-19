package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/insurance_list")
public class InsuranceListController {

    @GetMapping
    public String insuranceList(@RequestParam(value = "carSrn", required = false) Long carSrn,
                               Model model) {
        if (carSrn != null) {
            model.addAttribute("carSrn", carSrn);
        }
        return "insurance_list";
    }
}
