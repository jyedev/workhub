package com.work.workhub.admin.work.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.work.model.dao.WorkMapper;
import com.work.workhub.admin.work.model.dto.RestCateDTO;



@Service("restcateService")
@Transactional
public class RestCateServiceImpl implements RestCateService{
	
	private final WorkMapper workMapper;
	
	@Autowired
	public RestCateServiceImpl(WorkMapper workMapper) {
		this.workMapper = workMapper;
	}
	
	//연차유형 조회
	@Override
	public List<RestCateDTO> selectAllrestcate() {
		
		return workMapper.restcateSelect();
	}
	
	//연차유형 작성
	@Override
	public boolean restCateWrite(RestCateDTO post) throws Exception {
		
		int result = workMapper.restCateWrite(post);
		
		if(result <= 0) {
			throw new Exception("게시글 등록에 실패하였습니다.");
		}
		
		return result > 0 ? true : false;
		
	}
	
	
	



}
