package com.work.workhub.admin.reserve.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.reserve.model.dao.CarMapper;
import com.work.workhub.admin.reserve.model.dto.CarDTO;

@Service("carService")
@Transactional
public class CarServiceImpl implements CarService{

	private final CarMapper carMapper;
	
	@Autowired
	public CarServiceImpl(CarMapper carMapper) {
		this.carMapper = carMapper;
	}
	@Override
	public boolean registCar(CarDTO car) throws Exception {
		int result = carMapper.registCar(car);
		
		if(result <= 0) {
			throw new Exception("차량 자산 등록 실패");
		}
		
		
		return result > 0 ? true : false;
	}


	@Override
	public List<CarDTO> selectAllCar() {
		return carMapper.selectAllCar();
	}

	
	@Override
	public void modifyCar(CarDTO car) {
		// TODO Auto-generated method stub
		
	}
}
