package com.work.workhub.member.employ.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.member.employ.model.dto.AttDTO;

@Mapper
public interface EmpstatusMapper {
	
	//출근하기 버튼 눌렀을 때
	int employmentIn(AttDTO post);
	
	//출근하기 버튼 눌렀을 때
	int employmentOut(AttDTO post);
	
	/* 근무유형 select box*/	
	List<WorkDTO> boxWork();
	
	//select box 근무 등록
	int employmentOther(AttDTO post);
	
	//근태 조회
	List<AttDTO> attenSelect();

	
	

}
