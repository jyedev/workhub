package com.work.workhub.admin.reserve.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
	
	private int carNo;
	private String carName;
	private int carNumber;
	private String carYn;
	private String delYn;

}
