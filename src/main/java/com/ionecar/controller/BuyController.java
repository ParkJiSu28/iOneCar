package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/quote/buy")
@RequiredArgsConstructor
public class BuyController {
    // 구매방식선택택 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showBuyString() {
        return "buy";
    }
}
