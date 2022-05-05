package com.work.workhub.admin.reserve.model.service;

import com.work.workhub.admin.reserve.model.dto.CarDTO;

public interface CarService {

	boolean registCar(CarDTO car) throws Exception;

	void modifyCar(CarDTO car);
}
