package com.work.workhub.admin.work.model.service;

import java.util.List;

import com.work.workhub.admin.work.model.dto.RestCateDTO;


public interface RestCateService {
	
	//연차유형 조회
	List<RestCateDTO> selectAllrestcate();
	
	//연차유형 작성
	boolean restCateWrite(RestCateDTO post) throws Exception;

	

	

}
