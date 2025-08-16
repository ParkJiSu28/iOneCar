package com.ionecar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import com.ionecar.domain.Compare;
import com.ionecar.domain.Car;
import com.ionecar.domain.Option;
import com.ionecar.domain.Deal;
import com.ionecar.domain.Purchase;
import com.ionecar.service.CompareSerivce;
import com.ionecar.service.CarService;
import com.ionecar.service.OptionService;
import com.ionecar.service.DealService;
import com.ionecar.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DetailController {
    private final CompareSerivce compareSerivce;
    private final CarService carService;
    private final OptionService optionService;
    private final DealService dealService;
    private final PurchaseService purchaseService;

    @GetMapping("/myquote/detail")
    public String DetailPage(@RequestParam(value = "carSrn", required = false) Long carSrn,
                           @RequestParam(value = "dealerNo", required = false) Long dealerNo,
                           Model model) {
        if (carSrn == null) {
            return "myquote";
        }
        
        // Car 정보 조회
        Car car = carService.selectCarByCarSrn(carSrn);
        if (car == null) {
            return "myquote";
        }
        
        // Option 정보 조회
        List<Option> options = optionService.selectOptionsByCarSrn(carSrn);
        
        // Deal 정보 조회 (특정 딜러의 정보 또는 첫 번째 딜러)
        Deal deal = null;
        Long discount = 0L;
        Double rate = 0.0;
        
        if (dealerNo != null) {
            deal = dealService.getDealByDealerNoAndCarSrn(dealerNo, carSrn);
        } else {
            List<Deal> deals = dealService.getDealsByCarSrn(carSrn);
            if (deals != null && !deals.isEmpty()) {
                deal = deals.get(0);
            }
        }
        
        if (deal != null) {
            discount = deal.getDiscount();
            rate = deal.getRate();
        }
        
        // Purchase 정보 조회
        Purchase purchase = purchaseService.selectPurchaseByCarSrn(carSrn);
        
        // Compare 정보 조회 (딜러 정보용)
        List<Compare> compares = compareSerivce.selectCompareByCarSrn(carSrn);
        // dealerNo가 있으면 해당 딜러만 필터링
        if (dealerNo != null && compares != null) {
            compares = compares.stream()
                    .filter(compare -> dealerNo.equals(compare.getDealerNo()))
                    .collect(java.util.stream.Collectors.toList());
        }
        
        // 옵션 가격 계산
        Long optPrice = 0L;
        if (options != null) {
            optPrice = options.stream().mapToLong(Option::getOptPrice).sum();
        }
        
        // 모델에 데이터 추가
        model.addAttribute("car", car);
        model.addAttribute("options", options);
        model.addAttribute("optPrice", optPrice);
        model.addAttribute("discount", discount);
        model.addAttribute("rate", rate);
        model.addAttribute("purchase", purchase);
        model.addAttribute("compares", compares);
        model.addAttribute("carSrn", carSrn);
        model.addAttribute("dealerNo", dealerNo);
        
        return "detail";
    }
    
    @PostMapping("/myquote/deal/confirm")
    @ResponseBody
    public ResponseEntity<String> confirmDeal(@RequestParam("carSrn") Long carSrn,
                                            @RequestParam("dealerNo") Long dealerNo) {
        try {
            // Deal 정보 조회
            Deal deal = dealService.getDealByDealerNoAndCarSrn(dealerNo, carSrn);
            
            if (deal != null) {
                // progress를 2로 업데이트
                deal.setProgress("2");
                dealService.updateDeal(deal);
                return ResponseEntity.ok("SUCCESS");
            } else {
                return ResponseEntity.badRequest().body("Deal not found");
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error updating deal");
        }
    }
} 