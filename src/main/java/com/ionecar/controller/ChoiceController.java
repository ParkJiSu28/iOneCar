package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/choice")
@RequiredArgsConstructor
public class ChoiceController {
    @GetMapping
    public String choice() {
        return "choice"; // choice.html 타임리프 템플릿 반환
    }
}