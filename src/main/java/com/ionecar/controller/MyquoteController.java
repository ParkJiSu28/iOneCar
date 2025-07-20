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

@Controller
@RequestMapping("/myquote")
@RequiredArgsConstructor
public class MyquoteController {
       // 내 견적함함을 반환하는 GET 매핑 추가
       @GetMapping
       public String myquotePage() {
            return "myquote"; // myquote.html 타임리프 템플릿 반환
       }
   
}
