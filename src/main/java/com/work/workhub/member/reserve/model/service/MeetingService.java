package com.work.workhub.member.reserve.model.service;

import java.util.List;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.member.reserve.model.dto.ResMeetingDTO;

public interface MeetingService {

	List<MeetingRoomDTO> selectAllLocation();

	List<MeetingRoomDTO> selectRoomList();

	boolean reserveRoom(ResMeetingDTO resRoom) throws Exception;

	
	

}
