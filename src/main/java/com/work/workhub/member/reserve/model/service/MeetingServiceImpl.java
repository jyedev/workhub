package com.work.workhub.member.reserve.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.member.reserve.model.dao.MeetingMapper;

@Service("meetingService")
@Transactional
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	private MeetingMapper meetingMapper;
	
	@Override
	public List<MeetingRoomDTO> selectAllLocation() {
		
		return meetingMapper.selectAllLocation();
	}

	@Override
	public List<MeetingRoomDTO> selectRoomList() {
		return meetingMapper.selectRoomList();
	}

}
