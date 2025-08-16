package com.ionecar.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import lombok.RequiredArgsConstructor;
import com.ionecar.service.PurchaseService;
import com.ionecar.service.CarService;
import com.ionecar.service.OptionService;
import com.ionecar.domain.Purchase;
import com.ionecar.domain.Car;
import com.ionecar.domain.Option;
import java.util.List;
import java.text.DecimalFormat;

@Controller
@RequestMapping("/quote/buy")
@RequiredArgsConstructor
public class BuyController {
    
    private final PurchaseService purchaseService;
    private final CarService carService;
    private final OptionService optionService;
    
    // 구매방식선택 페이지를 반환하는 GET 매핑
    @GetMapping
    public String showBuyString(@RequestParam("carSrn") Long carSrn, Model model) {
        // Car 정보 조회
        Car car = carService.selectCarByCarSrn(carSrn);
        List<Option> options = optionService.selectOptionsByCarSrn(carSrn);
        
        // 옵션 총 가격 계산
        long totalOptionPrice = options != null ? 
            options.stream().mapToLong(Option::getOptPrice).sum() : 0L;
        
        // 총 가격 계산
        long totalPrice = car.getCarPrice() + totalOptionPrice;
        
        // 캐시백 계산 (총 가격의 2%)
        long cashback = Math.round(totalPrice * 0.02);
        
        // 숫자 포맷팅
        DecimalFormat formatter = new DecimalFormat("#,###");
        
        model.addAttribute("carSrn", carSrn);
        model.addAttribute("car", car);
        model.addAttribute("options", options);
        model.addAttribute("totalOptionPrice", totalOptionPrice);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cashback", cashback);
        model.addAttribute("formattedTotalPrice", formatter.format(totalPrice));
        model.addAttribute("formattedCarPrice", formatter.format(car.getCarPrice()));
        model.addAttribute("formattedCashback", formatter.format(cashback));
        
        if (options != null && !options.isEmpty()) {
            model.addAttribute("formattedOptionPrice", formatter.format(totalOptionPrice));
        }
        
        return "buy";
    }
    
    // 구매 정보 처리 POST 매핑
    @PostMapping
    public String processPurchase(
            @RequestParam("carSrn") Long carSrn,
            @RequestParam("purchaseMethod") String purchaseMethod,
            @RequestParam(value = "installmentPeriod", required = false) String installmentPeriod,
            @RequestParam(value = "downPayment", required = false) String downPayment,
            @RequestParam("pickupRegion") String pickupRegion,
            @RequestParam("taxExemption") String taxExemption) {
        
        // Purchase 객체 생성
        Purchase purchase = new Purchase();
        purchase.setCarSrn(carSrn);
        purchase.setPurchaseMethod(purchaseMethod);
        purchase.setPurchaseLocation(pickupRegion);
        
        // 면세조건 설정: general인 경우 'N', 나머지는 'Y'
        if ("general".equals(taxExemption)) {
            purchase.setPurchaseDutyFree("N");
        } else {
            purchase.setPurchaseDutyFree("Y");
        }
        
        // 할부기간 설정
        if ("I".equals(purchaseMethod) && installmentPeriod != null) {
            purchase.setPurchasePeriod(Long.parseLong(installmentPeriod));
        } else {
            purchase.setPurchasePeriod(1L); // 일시불의 경우 1
        }
        
        // 선수금 설정
        if ("C".equals(purchaseMethod)) {
            // 일시불: car_price + option_price
            Car car = carService.selectCarByCarSrn(carSrn);
            List<Option> options = optionService.selectOptionsByCarSrn(carSrn);
            long totalOptionPrice = options != null ? 
                options.stream().mapToLong(Option::getOptPrice).sum() : 0L;
            purchase.setPurchaseAdvance(car.getCarPrice() + totalOptionPrice);
        } else {
            // 할부: 입력값 (콤마 제거)
            if (downPayment != null && !downPayment.isEmpty()) {
                String cleanPayment = downPayment.replaceAll(",", "");
                purchase.setPurchaseAdvance(Long.parseLong(cleanPayment));
            } else {
                purchase.setPurchaseAdvance(0L);
            }
        }
        
        // Purchase 정보 저장
        purchaseService.insertPurchase(purchase);
        
        // 다음 페이지로 리다이렉트
        return "redirect:/quote/apply?carSrn=" + carSrn;
    }
}
