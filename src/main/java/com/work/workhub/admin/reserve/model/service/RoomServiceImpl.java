package com.work.workhub.admin.reserve.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.work.workhub.admin.reserve.model.dao.RoomMapper;
import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;

@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {

    private final RoomMapper roomMapper;

    @Autowired
    public RoomServiceImpl(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public boolean registRoom(MeetingRoomDTO room) throws Exception {
        int result = roomMapper.registRoom(room);

        if(result <= 0) {
            throw new Exception("차량 자산 등록 실패");
        }


        return result > 0 ? true : false;
    }

    @Override
    public boolean modifyRoom(MeetingRoomDTO room) throws Exception {
        // TODO Auto-generated method stub
        return false;
    }

	@Override
	public List<MeetingRoomDTO> selectAllRoom() {
		return roomMapper.selectRoomList();
	}

}