package com.work.workhub.member.reserve.dto.reserve;

import java.sql.Date;

import com.work.workhub.admin.dto.reserve.MeetingRoomDTO;
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
