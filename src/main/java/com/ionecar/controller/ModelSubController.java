package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Arrays;

@Controller
@RequestMapping("/quote/model_sub")
@RequiredArgsConstructor
public class ModelSubController {

    // 브랜드 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showModelSub() {
    
    return "model_sub";
}

}
