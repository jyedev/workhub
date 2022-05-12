package com.work.workhub.admin.work.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.admin.work.model.dto.RestCateDTO;
import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.admin.work.model.dto.WorkGroupDTO;
import com.work.workhub.member.member.dto.MemberDTO;

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
	
	//근무그룹 조회
	List<WorkGroupDTO> workGroupSelect();
	
	//근무그룹 작성
	int workGroupWrite(WorkGroupDTO post);
	
	//사원 아이디 검색으로 근무그룹 조회
//	List<MemberDTO> memberGroupSelect();
	
	//근무그룹조회 use='사용'
//	List<WorkGroupDTO> workGroupSelects();



}
