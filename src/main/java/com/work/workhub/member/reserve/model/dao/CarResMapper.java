package com.work.workhub.member.reserve.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.admin.reserve.model.dto.CarDTO;
import com.work.workhub.member.reserve.model.dto.ResCarDTO;

@Mapper
public interface CarResMapper {

	List<CarDTO> selectCarList();

	List<ResCarDTO> selectAllResCarList();

}
