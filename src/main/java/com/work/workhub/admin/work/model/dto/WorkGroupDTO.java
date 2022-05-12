package com.work.workhub.admin.work.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class WorkGroupDTO {
	
	private int groupNo;
	private String groupName;
	private String groupEx;
	private int groupDay; 
	private Date groupFirdate;
	private Date groupEnddate;
	private Date groupFirrest;
	private Date groupEndrest; 
	private String groupStatus;
	private int groupRest;
	private Date groupDate;
	private Date groupModdate;
	
}
