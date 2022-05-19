package com.work.workhub.member.employ.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.work.model.dto.RestCateDTO;
import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.member.employ.model.dao.EmpstatusMapper;
import com.work.workhub.member.employ.model.dto.AttDTO;
import com.work.workhub.member.employ.model.dto.ImgDTO;
import com.work.workhub.member.employ.model.dto.RestDTO;


@Service("restService")
@Transactional
public class RestServiceImpl implements RestService{
	
	private final EmpstatusMapper empstatusMapper;
	
	@Autowired
	public RestServiceImpl(EmpstatusMapper empstatusMapper) {
		this.empstatusMapper = empstatusMapper;
	}
	
	/* 근무유형 select box*/
	@Override
	public List<WorkDTO> selectsBox() {
		
		return empstatusMapper.boxsWork();
	}
	
	//휴가 유형 selectBox
	@Override
	public List<RestCateDTO> rcBox() {
		
		return empstatusMapper.boxRc();
	}
	
	//연차신청서 작성
	@Override
	public boolean insertRest(ImgDTO img, RestDTO rest) throws Exception {
		
		int result = empstatusMapper.insertPara(rest);
		
		int results = empstatusMapper.insertRest(img);
		

        if(result <= 0 || results <= 0) {
            throw new Exception("연차 신청서 등록 실패");
        }


        return result > 0 ? true : false;
	}
	
	//연차 유형 사용한 것
	@Override
	public List<RestDTO> selectrest() {
		
		return empstatusMapper.restselect();
	}
	
	//연차 유형 사용하지 않은 것
	@Override
	public List<RestDTO> selectrests() {
		
		return empstatusMapper.restsselect();
	}
	
	//연차신청서 파라미터  값
//	@Override
//	public boolean insertPara(RestDTO rest) throws Exception {
//		
//		int result = empstatusMapper.insertPara(rest);
//
//        if(result <= 0) {
//            throw new Exception("연차 신청서 데이터 등록 실패");
//        }
//
//
//        return result > 0 ? true : false;
//		
//	}
	

	

}
