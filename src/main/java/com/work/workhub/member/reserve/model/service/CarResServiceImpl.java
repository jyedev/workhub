package com.work.workhub.member.reserve.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.workhub.member.reserve.model.dao.CarResMapper;
import com.work.workhub.member.reserve.model.dto.ResCarDTO;

@Service
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
	public List<ResCarDTO> selectAllCar() {
		// TODO Auto-generated method stub
		return carResMapper.selectCarList();
	}

}
