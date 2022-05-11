package com.work.workhub.admin.work.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.admin.work.model.dto.RestCateDTO;
import com.work.workhub.admin.work.model.dto.WorkDTO;

@Mapper
public interface WorkMapper {

	//근태유형 작성
	int workWrite(WorkDTO post);

	//근태유형 조회
	List<WorkDTO> workSelect();
	
	//연차유형 조회
	List<RestCateDTO> restcateSelect();
	
	//연차유형 작성
	int restCateWrite(RestCateDTO post);



}
