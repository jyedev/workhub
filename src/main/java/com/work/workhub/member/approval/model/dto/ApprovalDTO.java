package com.work.workhub.member.approval.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ApprovalDTO {

	private int no;
	private int memNo;
	private String title;
	private String content;
	private String status;
	private Date createdDate;
	private Date dueDate;
}
