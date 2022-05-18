package com.work.workhub.member.employ.model.service;

import java.util.List;

import com.work.workhub.admin.work.model.dto.RestCateDTO;
import com.work.workhub.admin.work.model.dto.WorkDTO;



public interface RestService {
	
	/* 근무유형 select box*/	
	List<WorkDTO> selectsBox();
	
	//휴가 유형 selectBox
	List<RestCateDTO> rcBox();
	

}
