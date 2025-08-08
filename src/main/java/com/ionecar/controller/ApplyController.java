package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import com.ionecar.service.CarService;
import com.ionecar.service.OptionService;
import com.ionecar.service.CustomerService;
import com.ionecar.domain.Car;
import com.ionecar.domain.Option;
import java.util.List;

@Controller
@RequestMapping("/quote/apply")
@RequiredArgsConstructor
public class ApplyController {
    
    private final CustomerService customerService;
    private final CarService carService;
    private final OptionService optionService;
    
    // 견적확인 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showApplyString(@RequestParam("carSrn") Long carSrn, Model model) {
        // Car 정보 조회
        Car car = carService.selectCarByCarSrn(carSrn);
        if (car != null) {
            model.addAttribute("carPrice", car.getCarPrice());
        }
        
        // Option 정보 조회 (해당 carSrn의 모든 옵션)
        List<Option> options = optionService.selectOptionsByCarSrn(carSrn);
        long totalOptionPrice = 0;
        if (options != null) {
            totalOptionPrice = options.stream()
                .mapToLong(Option::getOptPrice)
                .sum();
        }
        
        model.addAttribute("optionPrice", totalOptionPrice);
        model.addAttribute("carSrn", carSrn);
        
        return "apply";
    }
    
    // 견적신청 폼 제출 처리
    @PostMapping
    public String submitApply(
            @RequestParam("carSrn") Long carSrn,
            @RequestParam(value = "nonFaceToFace", required = false) String nonFaceToFace,
            @RequestParam(value = "accessoryService", required = false) String accessoryService,
            @RequestParam(value = "contractIntent", required = false) String contractIntent,
            @RequestParam(value = "requestContent", required = false) String requestContent) {
        
        // 여기서 폼 데이터를 처리하고 데이터베이스에 저장하는 로직을 추가할 수 있습니다.
        // 현재는 단순히 submit 페이지로 리다이렉트합니다.
        customerService.updateQntYnByCarSrn(carSrn, "Y");
        return "redirect:/quote/submit?carSrn=" + carSrn;
    }
}