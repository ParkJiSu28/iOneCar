package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/quote/option")
@RequiredArgsConstructor
public class OptionController {

    // 옵션선택 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showOptionSelection() {
        return "option";
    }
}
