package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/type")
@RequiredArgsConstructor
public class TypeController {
    @GetMapping
    public String type() {
        return "type"; // home.html 타임리프 템플릿 반환
    }
}