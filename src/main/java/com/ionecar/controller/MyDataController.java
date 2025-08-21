package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mydata")
public class MyDataController {

    @GetMapping("")
    public String myData(Model model) {
        // 이미지에 맞는 정적 데이터로 화면 구성
        return "mydata";
    }
    
    @GetMapping("/detail")
    public String myDataDetail(Model model) {
        // 차량 관리 상세 화면
        return "mydata_detail";
    }
}
