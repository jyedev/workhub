package com.work.workhub.admin.work.model.service;

import java.util.List;

import com.work.workhub.admin.work.model.dto.WorkDTO;

public interface WorkService {
	
	//근태유형 삽입
	boolean workWrite(WorkDTO post) throws Exception;
	
	//근태유형 조회
	List<WorkDTO> selectAllwork();

	

}
