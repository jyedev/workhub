package com.work.workhub.member.calendar.model.service;

import java.util.List;

import com.work.workhub.member.calendar.model.dto.CalendarDTO;

public interface CalendarService {

	List<CalendarDTO> selectCalendarList(int no);

}
