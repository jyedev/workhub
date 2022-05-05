package com.work.workhub.member.reserve.model.dto;

import java.sql.Date;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.member.member.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResMeetingDTO {
	private int resNo;
	private int memberNo;
	private int roomNo;
	private Date startTime;
	private Date endTime;
	private String meetPurpose;
	private String delYn;
	
	private MemberDTO member;
	private MeetingRoomDTO room;
	
}
