package com.ionecar.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.ionecar.domain.Compare;
import com.ionecar.domain.Dealer;
import com.ionecar.domain.Deal;
import com.ionecar.domain.Purchase;
import com.ionecar.service.CompareSerivce;
import com.ionecar.service.DealerService;
import com.ionecar.service.DealService;
import com.ionecar.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import java.util.List;



@Controller
@RequiredArgsConstructor
public class CompareController {
    private final CompareSerivce compareSerivce;
    private final DealerService dealerService;
    private final DealService dealService;
    private final PurchaseService purchaseService;

    @GetMapping("/compare")
    public String ComparePage(@RequestParam(value = "carSrn", required = false) Long carSrn, Model model) {
        if (carSrn == null) {
            return "myquote";
        }
        
        // 1. Dealer 테이블 확인 및 기본 데이터 생성
        initializeDealerData(carSrn);
        
        // 2. carSrn으로 딜러 목록 조회하여 dealerNo 가져오기
        List<Dealer> dealers = dealerService.getDealersByCarSrn(carSrn);
        
        // 3. Deal 테이블 확인 및 기본 데이터 생성 (실제 dealerNo 사용)
        if (dealers != null && !dealers.isEmpty()) {
            initializeDealData(carSrn, dealers);
        }
        
        // 4. Purchase 정보 조회
        Purchase purchase = purchaseService.selectPurchaseByCarSrn(carSrn);
        
        List<Compare> compares = compareSerivce.selectCompareByCarSrn(carSrn);
        
        if(compares == null || compares.isEmpty()){
            return "myquote";
        }else{
            // 첫 번째 Compare 객체의 기본 정보를 모델에 추가
            Compare firstCompare = compares.get(0);
            model.addAttribute("carClass", firstCompare.getCarClass());
            model.addAttribute("carSubClass", firstCompare.getCarSubClass());
            model.addAttribute("purchaseMethod", firstCompare.getPurchaseMethod());
            model.addAttribute("purchasePeriod", firstCompare.getPurchasePeriod());
            model.addAttribute("carPrice", firstCompare.getCarPrice());
            model.addAttribute("optPrice", firstCompare.getOptPrice());
            
            // Purchase 정보 추가
            model.addAttribute("purchase", purchase);
            
            // 모든 Compare 객체를 모델에 추가
            model.addAttribute("compares", compares);
            
            // carSrn을 모델에 추가하여 템플릿에서 사용할 수 있도록 함
            model.addAttribute("carSrn", carSrn);
            
            return "compare";
        }
    }
    
    /**
     * Dealer 테이블에 해당 carSrn의 데이터가 없으면 기본 딜러 데이터를 생성
     */
    private void initializeDealerData(Long carSrn) {
        List<Dealer> existingDealers = dealerService.getDealersByCarSrn(carSrn);
        
        if (existingDealers == null || existingDealers.isEmpty()) {
            // 첫 번째 딜러: 벤츠박사
            Dealer dealer1 = new Dealer();
            dealer1.setDealerName("벤츠박사");
            dealer1.setDealerPhone("010-1234-5678");
            dealer1.setCarSrn(carSrn);
            dealer1.setReviewCnt(67L);
            dealer1.setRating(5.0);
            dealer1.setQuotationCnt(1418L);
            dealer1.setCertYn("Y");
            dealerService.createDealer(dealer1);
            
            // 두 번째 딜러: 김철수
            Dealer dealer2 = new Dealer();
            dealer2.setDealerName("김철수");
            dealer2.setDealerPhone("010-9876-5432");
            dealer2.setCarSrn(carSrn);
            dealer2.setReviewCnt(5L);
            dealer2.setRating(4.0);
            dealer2.setQuotationCnt(10L);
            dealer2.setCertYn("Y");
            dealerService.createDealer(dealer2);
        }
    }
    
    /**
     * Deal 테이블에 해당 carSrn의 데이터가 없으면 기본 거래 데이터를 생성
     */
    private void initializeDealData(Long carSrn, List<Dealer> dealers) {
        List<Deal> existingDeals = dealService.getDealsByCarSrn(carSrn);
        
        if (existingDeals == null || existingDeals.isEmpty()) {
            // 첫 번째 거래 (첫 번째 딜러의 dealerNo 사용)
            if (dealers.size() >= 1) {
                Deal deal1 = new Deal();
                deal1.setDealerNo(dealers.get(0).getDealerNo());
                deal1.setCarSrn(carSrn);
                deal1.setProgress("1");
                deal1.setRate(7.0);
                deal1.setDiscount(5000000L);
                dealService.createDeal(deal1);
            }
            
            // 두 번째 거래 (두 번째 딜러의 dealerNo 사용)
            if (dealers.size() >= 2) {
                Deal deal2 = new Deal();
                deal2.setDealerNo(dealers.get(1).getDealerNo());
                deal2.setCarSrn(carSrn);
                deal2.setProgress("1");
                deal2.setRate(5.0);
                deal2.setDiscount(7000000L);
                dealService.createDeal(deal2);
            }
        }
    }
}
