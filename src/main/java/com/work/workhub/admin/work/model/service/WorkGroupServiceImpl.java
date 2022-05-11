package com.work.workhub.admin.work.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.work.model.dao.WorkMapper;
import com.work.workhub.admin.work.model.dto.WorkGroupDTO;




@Service("workgroupService")
@Transactional
public class WorkGroupServiceImpl implements WorkGroupService{
	
	private final WorkMapper workMapper;
	
	@Autowired
	public WorkGroupServiceImpl(WorkMapper workMapper) {
		this.workMapper = workMapper;
	}

//	@Override
//	public List<WorkGroupDTO> selectAllworkGroup() {
//		// TODO Auto-generated method stub
//		return null;
//	}



	
	
	



}
