package com.work.workhub.member.employ.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.member.employ.model.dao.EmpstatusMapper;
import com.work.workhub.member.employ.model.dto.AttDTO;


@Service("employmentService")
@Transactional
public class EmploymentServiceImpl implements EmploymentService{
	
	private final EmpstatusMapper empstatusMapper;
	
	@Autowired
	public EmploymentServiceImpl(EmpstatusMapper empstatusMapper) {
		this.empstatusMapper = empstatusMapper;
	}
	
	//출근하기 버튼 눌렀을 때
	@Override
	public boolean employmentIn(AttDTO post) throws Exception {
        
		int result = empstatusMapper.employmentIn(post);
		
		if(result <= 0) {
			throw new Exception("출근 등록을 실패하였습니다.");
		}
		
		return result > 0 ? true : false;
	}
	
	//퇴근하기 버튼 눌렀을 때
	@Override
	public boolean employmentOut(AttDTO post) throws Exception {
		
		int result = empstatusMapper.employmentOut(post);
		
		if(result <= 0) {
			throw new Exception("퇴근 등록을 실패하였습니다.");
		}
		
		return result > 0 ? true : false;
	}
	
	/* 근무유형 select box*/	
	@Override
	public List<WorkDTO> selectBox() {
		
		return empstatusMapper.boxWork();
	}
	
	//select box 근무 등록
	@Override
	public boolean employmentOther(AttDTO post) throws Exception {
		
		int result = empstatusMapper.employmentOther(post);
		
		if(result <= 0) {
			throw new Exception("근태 등록을 실패하였습니다.");
		}
		
		return result > 0 ? true : false;
	}

	@Override
	public List<AttDTO> attenSelect() {
		
		return empstatusMapper.attenSelect();
	}
	
	//내 근태 조회
	@Override
	public List<AttDTO> selectMy() {
		
		return empstatusMapper.mySelect();
	}
	
	
	



}
