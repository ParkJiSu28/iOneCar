package com.ionecar.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.ionecar.domain.Vehicle;
import com.ionecar.domain.VehicleOption;
import com.ionecar.domain.TaxPayment;
import com.ionecar.domain.Insurance;
import com.ionecar.domain.VehicleDto;

@Mapper
public interface VehicleMapper {
    List<Vehicle> findAllVehicles(); 

    //List<VehicleOption> findOptionsByVehicleId(String vehicleId);

    //TaxPayment findTaxByVehicleId(String vehicleId);

    //Insurance findInsuranceByVehicleId(String vehicleId);

    // 아래는 옵션·세금·보험을 포함한 차량 전체 리스트를 한 번에 조인해서 가져오는 쿼리도 가능
    //List<VehicleDto> findAllVehiclesWithOptionsAndEtc();
}