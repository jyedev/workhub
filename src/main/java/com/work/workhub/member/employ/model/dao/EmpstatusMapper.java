package com.work.workhub.member.employ.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.admin.work.model.dto.RestCateDTO;
import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.member.employ.model.dto.AttDTO;
import com.work.workhub.member.employ.model.dto.ImgDTO;
import com.work.workhub.member.employ.model.dto.RestDTO;

@Mapper
public interface EmpstatusMapper {
	
	//출근하기 버튼 눌렀을 때
	int employmentIn(AttDTO post);
	
	//출근하기 버튼 눌렀을 때ㄴ
	int employmentOut(AttDTO post);
	
	/* 근무유형 select box 내 근태 현황*/	
	List<WorkDTO> boxWork();
	
	//select box 근무 등록
	int employmentOther(AttDTO post);
	
	//근태 조회
	List<AttDTO> attenSelect();
	
	/* 근무유형 select box 내 연차*/
	List<WorkDTO> boxsWork();
	
	//휴가 신청서의 휴가 유형 selectBox
	List<RestCateDTO> boxRc();
	
	//연차 신청서 작성 이미지
	int insertRest(ImgDTO img);
	
	//연차신청서 파라미터  값
	int insertPara(RestDTO rest);
	
	//내 근태 조회
	List<AttDTO> mySelect();
	
	//연차 유형 사용한 것
	List<RestDTO> restselect();
	
	//연차 유형 사용하지 않은 것
	List<RestDTO> restsselect();

	
	

}
