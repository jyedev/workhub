package com.work.workhub.member.employ.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.member.employ.model.dao.EmpstatusMapper;
import com.work.workhub.member.employ.model.dto.AttDTO;


@Service("restService")
@Transactional
public class RestServiceImpl implements RestService{
	
	private final EmpstatusMapper empstatusMapper;
	
	@Autowired
	public RestServiceImpl(EmpstatusMapper empstatusMapper) {
		this.empstatusMapper = empstatusMapper;
	}
	

	

}
