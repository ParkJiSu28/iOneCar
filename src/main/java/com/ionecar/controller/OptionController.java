package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import com.ionecar.service.OptionService;
import com.ionecar.domain.Option;

@Controller
@RequestMapping("/quote/option")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    // 옵션선택 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showOptionSelection() {
        return "option";
    }

    // 옵션 선택 후 POST 요청 처리 (다중 옵션 지원)
    @PostMapping
    public String processOptions(
            @RequestParam("carSrn") Long carSrn,
            @RequestParam("optionLabel") java.util.List<String> optionLabels,
            @RequestParam("optionPrice") java.util.List<Long> optionPrices) {

        int count = Math.min(optionLabels.size(), optionPrices.size());
        for (int i = 0; i < count; i++) {
            Option option = new Option();
            option.setCarSrn(carSrn);
            option.setOptName(optionLabels.get(i));
            option.setOptDef(optionLabels.get(i)); // 요구사항: opt_name과 opt_def 모두 label 값 저장
            option.setOptPrice(optionPrices.get(i));
            optionService.insertOption(option);
        }

        // 다음 페이지로 이동 (carSrn 유지 필요 시 GET 파라미터로 부착)
        return "redirect:/quote/buy?carSrn=" + carSrn;
    }
}
