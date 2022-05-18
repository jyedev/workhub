package com.work.workhub.member.reserve.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.reserve.model.dto.CarDTO;
import com.work.workhub.member.reserve.model.dao.CarResMapper;
import com.work.workhub.member.reserve.model.dto.ResCarDTO;

@Service("carResService")
@Transactional
public class CarResServiceImpl implements CarResService{

	private CarResMapper carResMapper;
	
	@Autowired
	public CarResServiceImpl(CarResMapper carResMapper) {
		this.carResMapper = carResMapper;
	}
	@Override
	public void reserveCar(ResCarDTO car) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCarStatus(ResCarDTO car) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CarDTO> selectAllCar() {
		return carResMapper.selectCarList();
	}
	@Override
	public List<ResCarDTO> selectAllResCarList() {
		return carResMapper.selectAllResCarList();
	}
	@Override
	public CarDTO selectedCar(int carIndex) {
		return carResMapper.selectedCar(carIndex);
	}
	@Override
	public boolean registReservation(ResCarDTO resCar) throws Exception {
		int result = carResMapper.reserveCar(resCar);
		
		if(result <= 0) {
			throw new Exception("차량 예약 실패");
		}
		
		
		return result > 0 ? true : false;	
	}

}
