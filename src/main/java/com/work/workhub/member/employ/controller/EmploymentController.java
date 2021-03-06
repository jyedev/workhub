package com.work.workhub.member.employ.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.work.model.dto.MemberGroupDTO;
import com.work.workhub.admin.work.model.dto.RestCateDTO;
import com.work.workhub.admin.work.model.dto.WorkDTO;
import com.work.workhub.admin.work.model.dto.WorkGroupDTO;
import com.work.workhub.member.employ.model.dto.AttDTO;
import com.work.workhub.member.employ.model.dto.RestDTO;
import com.work.workhub.member.employ.model.service.EmploymentService;
import com.work.workhub.member.member.dto.UserImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/employ")
public class EmploymentController {
	
	private EmploymentService employmentService;
	private MessageSource messageSource;
	
	@Autowired
	public EmploymentController(EmploymentService employmentService, MessageSource messageSource) {
		this.employmentService = employmentService;
		this.messageSource = messageSource;
	}
	
	/* ???????????? select box*/
	@GetMapping("employmentSelect")
	public ModelAndView employmentSelect(ModelAndView mv) {
		
		//?????? ?????? select box
		List<WorkDTO> attList = employmentService.selectBox();
		
		//??? ?????? ??????
		List<AttDTO> myList = employmentService.selectMy();

		mv.addObject("attList",attList);
		mv.addObject("myList",myList);
		
		
		mv.setViewName("employ/employmentSelect");
		
		return mv;
	}
		
		
		//???????????? ?????? ????????? ???
		@GetMapping("in")
		public String employmentIn(@ModelAttribute AttDTO post, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) throws Exception {
			
			post.setNo(user.getNo());
			
			log.info("?????? ?????? ??? : {}", post);
			
			
			employmentService.employmentIn(post);
			
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("employmentIn", null, locale));
			
			return "redirect:/employ/employmentSelect";
			
		}
		
		//???????????? ?????? ????????? ???
		@GetMapping("out")
		public String employmentOut(@ModelAttribute AttDTO post, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) throws Exception {
			
			post.setNo(user.getNo());
			
			log.info("?????? ?????? ??? : {}", post);
			
			
			employmentService.employmentOut(post);
			
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("employmentOut", null, locale));
			
			return "redirect:/employ/employmentSelect";
			
		}
		
				
		//?????? ??????
		@GetMapping("employmentSelects")
		public ModelAndView employmentSelects(ModelAndView mv) {
			
			
			//?????? ??????
			List<AttDTO> attenList = employmentService.attenSelect();
			

			mv.addObject("attenList",attenList);
			
			mv.setViewName("employ/employmentSelect");
			
			return mv;
		}
		
		//select box ?????? ??????
		@PostMapping("other")
		public String employmentOther(@ModelAttribute AttDTO post, @AuthenticationPrincipal UserImpl user ,RedirectAttributes rttr, Locale locale) throws Exception {
			
			post.setNo(user.getNo());
			
			log.info("?????? ?????? ??? : {}", post);
			
			
			employmentService.employmentOther(post);
			
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("employmentOther", null, locale));
			
			return "redirect:/employ/employmentSelect";
			
		}
		
		//???????????? ?????? ?????????
		@GetMapping("employmentModify")
		public ModelAndView employmentModify(ModelAndView mv, @RequestParam int attNo) {
			
			//??? ?????? ?????? ???
			List<AttDTO> atList = employmentService.beforedData(attNo);
			
			//?????? ?????? select box
			List<RestCateDTO> sList = employmentService.sBox();

			mv.addObject("atList",atList);
			mv.addObject("sList",sList);

			mv.setViewName("employ/employmentModify");
			
			return mv;
			
		}
		
		//???????????? ??????
		@PostMapping("employmentModifyGo")
		public String employmentModifyGo(@ModelAttribute AttDTO post, @AuthenticationPrincipal UserImpl user ,RedirectAttributes rttr, Locale locale) throws Exception {
			
			
			post.setNo(user.getNo());
			
			

			log.info("?????? ?????? ??? : {}", post);

			employmentService.employmentModifyGo(post);
			
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("employmentModifyGo", null, locale));
			
			return "redirect:/employ/employmentSelect";
			
		}
		
		
		
		//???????????? ??????
		@GetMapping("employDelete")
		public String employDelete(@RequestParam int attNo ,@ModelAttribute AttDTO post, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) throws Exception {
			
			post.setNo(user.getNo());
			
			log.info("?????? ?????? ??? : {}", post);
			
			
			employmentService.employDelete(post, attNo);
			
			rttr.addFlashAttribute("successMessage", messageSource.getMessage("employDelete", null, locale));
			
			return "redirect:/employ/employmentSelect";
			
		}	
		
		
		
		//?????? ?????? ????????????
		@GetMapping("excelDown")
		public void excelDown(HttpServletResponse response) throws Exception {


		    // ?????? ??????

		    List<AttDTO> excelList = employmentService.excelDown();


		    // ????????? ??????

		    Workbook wb = new HSSFWorkbook();

		    Sheet sheet = wb.createSheet("?????????");

		    Row row = null;

		    Cell cell = null;

		    int rowNo = 0;



		    // ????????? ????????? ?????????

		    CellStyle headStyle = wb.createCellStyle();

		    // ?????? ???????????? ????????????.

		    headStyle.setBorderTop(BorderStyle.THIN);

		    headStyle.setBorderBottom(BorderStyle.THIN);

		    headStyle.setBorderLeft(BorderStyle.THIN);

		    headStyle.setBorderRight(BorderStyle.THIN);



		    // ???????????? ??????????????????.

		    headStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());

		    headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);



		    // ???????????? ????????? ???????????????.

		    headStyle.setAlignment(HorizontalAlignment.CENTER);
		    
		    //?????? ????????? ??? ???????????? ??????
		    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		    

		    // ???????????? ?????? ????????? ???????????? ??????

		    CellStyle bodyStyle = wb.createCellStyle();

		    bodyStyle.setBorderTop(BorderStyle.THIN);

		    bodyStyle.setBorderBottom(BorderStyle.THIN);

		    bodyStyle.setBorderLeft(BorderStyle.THIN);

		    bodyStyle.setBorderRight(BorderStyle.THIN);



		    // ?????? ??????

		    row = sheet.createRow(rowNo++);

		    cell = row.createCell(0);

		    cell.setCellStyle(headStyle);

		    cell.setCellValue("??????????????????");

		    cell = row.createCell(1);

		    cell.setCellStyle(headStyle);

		    cell.setCellValue("??????");

		    cell = row.createCell(2);

		    cell.setCellStyle(headStyle);

		    cell.setCellValue("????????????");
		    
		    cell = row.createCell(3);

		    cell.setCellStyle(headStyle);

		    cell.setCellValue("??????");
		    
		    cell = row.createCell(4);

		    cell.setCellStyle(headStyle);

		    cell.setCellValue("?????? ??????");
		    
		    cell = row.createCell(5);

		    cell.setCellStyle(headStyle);

		    cell.setCellValue("?????????");
		    
		    cell = row.createCell(6);

		    cell.setCellStyle(headStyle);

		    cell.setCellValue("?????????");



		    // ????????? ?????? ??????

		    for(AttDTO ex : excelList) {

		        row = sheet.createRow(rowNo++);

		        cell = row.createCell(0);

		        cell.setCellStyle(bodyStyle);

		        cell.setCellValue(ex.getAttNo());

		        cell = row.createCell(1);

		        cell.setCellStyle(bodyStyle);

		        cell.setCellValue(ex.getName());

		        cell = row.createCell(2);

		        cell.setCellStyle(bodyStyle);

		        cell.setCellValue(ex.getWorkName());
		        
		        cell = row.createCell(3);

		        cell.setCellStyle(bodyStyle);

		        cell.setCellValue(ex.getAttGo());
		        
		        cell = row.createCell(4);

		        cell.setCellStyle(bodyStyle);

		        cell.setCellValue(ex.getAttReason());
		        
		        cell = row.createCell(5);

		        cell.setCellStyle(bodyStyle);
		        
		        //?????? ?????? ?????? ??????????????? ????????? format ?????? ??????
		        cell.setCellValue(ex.getAttDate());
		        
		        cell = row.createCell(6);

		        cell.setCellStyle(bodyStyle);
		        
		        //format??? ????????? null ?????? ?????? ????????? ?????? null??? ?????? ???????????? format ????????? if?????? ?????? 
		        cell.setCellValue(ex.getAttModdate());
		       
		   
		    }


		    // ????????? ????????? ????????? ?????? ????????? ????????????..

		    String fileName = "????????????.xls";
		    fileName = new String(fileName.getBytes("euc-kr"), "8859_1");
		    response.setHeader("Content-Disposition", "attachment; fileName=\"" + fileName + "\";");
		    response.setHeader("Content-Transfer-Encoding", "binary");


		    // ?????? ??????

		    wb.write(response.getOutputStream());

		    wb.close();

		}

		
		
		
		
		
}
