package com.work.workhub.member.reserve.model.service;

import com.work.workhub.member.reserve.model.dto.ResCarDTO;

public interface CarService {

	void reserveCar(ResCarDTO car);

	void updateCarStatus(ResCarDTO car);
	
	

}
