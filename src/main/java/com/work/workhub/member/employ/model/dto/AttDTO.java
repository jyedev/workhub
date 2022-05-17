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
   
   private int attNo;
   private int no;
   private int workNo;
   private Date attGo;
   private Date attOff;
   private Date attAdd;
   private Date attOver;
   private Date attNight;
   private String attReason;
   private Date attDate;
   private String attStatus;
   private Date attModdate;
   
  
}