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
import com.ionecar.domain.Vehicle;
import com.ionecar.service.VehicleService;
import com.ionecar.service.CustomerService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {
    private final CustomerService customerService;

    // 로그인 폼을 반환하는 GET 매핑 추가
    @GetMapping
    public String loginPage() {
        return "login"; // login.html 타임리프 템플릿 반환
    }


    @PostMapping
    public String findCustomerByEdpsCsn(@RequestParam("edpsCsn") long edpsCsn, Model model, HttpSession session) {
    
        boolean exists = customerService.findCustomerByEdpsCsn(edpsCsn);

        if (exists) {
            session.setAttribute("edpsCsn", edpsCsn); // ▼ 세션에 저장!
            return "redirect:/home";
        } else {
            model.addAttribute("error", "존재하지 않는 고객 번호");
            return "login";
        }
    }
}
