package com.work.workhub.member.reserve.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.member.reserve.model.dao.MeetingMapper;
import com.work.workhub.member.reserve.model.dto.ResMeetingDTO;

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

	@Override
	public boolean reserveRoom(ResMeetingDTO resRoom) throws Exception {
		
		int result = meetingMapper.reserveRoom(resRoom);
		
		if(result <= 0) {
			throw new Exception("회의실 예약 실패");
		}
		
		
		return result > 0 ? true : false;
	}

	@Override
	public List<ResMeetingDTO> selectAllResMeeting() {
		return meetingMapper.selectAllResMeeting();
	}


}
