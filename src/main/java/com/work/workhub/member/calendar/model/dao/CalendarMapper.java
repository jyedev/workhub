package com.work.workhub.member.calendar.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.calendar.model.dto.CalendarDTO;

@Mapper
public interface CalendarMapper {

	List<CalendarDTO> selectCalendarList();

}
