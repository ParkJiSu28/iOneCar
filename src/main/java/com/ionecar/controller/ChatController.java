package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/myquote/chat")
@RequiredArgsConstructor
public class ChatController {
    // 구매방식선택택 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showChatString() {
        return "chat";
    }
}
