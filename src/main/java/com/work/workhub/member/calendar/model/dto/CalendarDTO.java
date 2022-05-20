package com.work.workhub.member.calendar.model.dto;

import com.work.workhub.member.member.dto.DepartmentDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarDTO {
	
	private String calCode;            //일정번호
	private String calCategoryCode;    //카테고리코드
	private int calDepNo;              //부서번호
	private int calWriterNo;           //작성자사원번호
	private String calName;            //일정제목
	private String calContent;         //일정내용 
	private String calStartDate;       //시작날짜
	private String calEndDate;         //종료날짜
	private String calStartTime;       //시작시간
	private String calEndTime;         //종료시간
	private String calAlldayStatus;    //종일여부 
	
	private CalCategoryDTO calCategory;
	private DepartmentDTO department;

}
