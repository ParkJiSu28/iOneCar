package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ionecar.service.CustomerService;
import lombok.RequiredArgsConstructor;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

import com.ionecar.domain.Customer;

@Controller
@RequiredArgsConstructor
public class ChoiceController {

    private final CustomerService customerService;

    @GetMapping("/choice")
    public String choice(HttpSession session, Model model) {
        Long edpsCsn = (Long) session.getAttribute("edpsCsn");
        if (edpsCsn == null) {
            return "redirect:/login";
        }
        
        // NULL 값 정리 및 qnt_yn 업데이트
        customerService.cleanupNullDataAndUpdateQntYn(edpsCsn);
        
        Customer customer = customerService.getCustomerByEdpsCsn(edpsCsn);
        // qntYn이 Y인지 소문자로 내려보내면 편함
        boolean hasQuote = "Y".equalsIgnoreCase(customer.getQntYn());
        model.addAttribute("edpsCsn", edpsCsn);
        model.addAttribute("hasQuote", hasQuote);

        return "choice";
    }
}