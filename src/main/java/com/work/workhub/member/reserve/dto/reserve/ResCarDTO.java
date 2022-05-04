package com.work.workhub.member.reserve.dto.reserve;

import java.sql.Date;

import com.work.workhub.admin.dto.reserve.CarDTO;
import com.work.workhub.member.member.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResCarDTO {
	
	private int resNo;
	private int memberNo;
	private int carNo;
	private Date startTime;
	private Date endTime;
	private String carPurpose;
	private String delYn;
	
	private MemberDTO member;
	private CarDTO car;

}
