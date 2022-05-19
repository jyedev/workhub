package com.work.workhub.member.employ.model.dto;

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
public class AttDTO {
   
	//근태관리
	
   private int attNo;
   private int no;
   private int workNo;
   private String workName;
   private String attGo;
   private Date attOff;
   private Date attAdd;
   private Date attOver;
   private Date attNight;
   private String attReason;
   private Date attDate;
   private String attStatus;
   private Date attModdate;
   
  
}