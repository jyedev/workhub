package com.work.workhub.member.calendar.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.member.calendar.model.dao.CalendarMapper;
import com.work.workhub.member.calendar.model.dto.CalendarDTO;


@Service
@Transactional
public class CalendarServiceImpl implements CalendarService {
	
	private CalendarMapper calendarMapper;
	
	@Autowired
	public CalendarServiceImpl (CalendarMapper calendarMapper) {
		this.calendarMapper = calendarMapper;
	}

	@Override
	public List<CalendarDTO> selectCalendarList() {
		return calendarMapper.selectCalendarList();
	}

}
