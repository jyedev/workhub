package com.work.workhub.member.approval.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.work.workhub.member.member.dto.MemberDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalDTO {

	private int no;
	private int memNo;
	private String title;
	private String content;
	private String status;
	private Date createdDate;
	private Date dueDate;
	
	private MemberDTO receiver;
	private MemberDTO sender;
}
