package com.work.workhub.admin.reserve.model.service;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;

public interface RoomService {

	void registRoom(MeetingRoomDTO room);

	void modifyRoom(MeetingRoomDTO room);
	

}
