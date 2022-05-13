package com.work.workhub.admin.work.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.work.model.dao.WorkMapper;
import com.work.workhub.admin.work.model.dto.WorkGroupDTO;
import com.work.workhub.member.member.dto.MemberDTO;




@Service("membergroupService")
@Transactional
public class MemberGroupServiceImpl implements MemberGroupService{
	
	private final WorkMapper workMapper;
	
	@Autowired
	public MemberGroupServiceImpl(WorkMapper workMapper) {
		this.workMapper = workMapper;
	}
	
	//사원 아이디 검색으로 근무그룹 조회
//	@Override
//	public List<MemberDTO> selectAllmemberGroup() {
//		
//		return workMapper.memberGroupSelect();
//	}
	




	
	
	



}
