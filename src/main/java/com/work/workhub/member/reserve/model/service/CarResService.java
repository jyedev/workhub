package com.work.workhub.member.reserve.model.service;

import java.util.List;

import com.work.workhub.admin.reserve.model.dto.CarDTO;
import com.work.workhub.member.reserve.model.dto.ResCarDTO;

public interface CarResService {

	void reserveCar(ResCarDTO car);

	void updateCarStatus(ResCarDTO car);

	List<CarDTO> selectAllCar();

	List<ResCarDTO> selectAllResCarList();
	
	

}
