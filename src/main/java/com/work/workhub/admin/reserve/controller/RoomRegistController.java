package com.work.workhub.admin.reserve.controller;


import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.admin.reserve.model.dto.MeetingRoomDTO;
import com.work.workhub.admin.reserve.model.service.RoomService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("asset/room")
public class RoomRegistController {

    private RoomService roomService;
    private MessageSource messageSource;

    @Autowired
    public RoomRegistController(RoomService roomService, MessageSource messageSource) {
        this.roomService = roomService;
        this.messageSource = messageSource;
    }

    /* 회의실 등록용 화면 이동*/
    @GetMapping("regist")
    public void registRoom() {

    }


    @PostMapping("regist")
    public String registRoom(@ModelAttribute MeetingRoomDTO room, RedirectAttributes rttr, Locale locale, @RequestParam MultipartFile singleFile, HttpServletRequest request, Model model) throws Exception {



        log.error("등록요청메뉴 : {}",room);
        log.warn("등록요청메뉴 : {}",room);
        log.info("등록요청메뉴 : {}",room);
        log.debug("등록요청메뉴 : {}", room);
        log.trace("등록요청메뉴 : {}", room);

        roomService.registRoom(room);

        rttr.addFlashAttribute("successMessage", messageSource.getMessage("registRoom", null, locale));
        
		
		log.info("singleFile : {}" + singleFile);

		// file 저장 경로 설정
		String root = request.getSession().getServletContext().getRealPath("resources");

		System.out.println("root : " + root);

		String savePath = root + "\\uploadFiles";

		File mkdir = new File(savePath);
		if (!mkdir.exists()) {
			mkdir.mkdirs();
		}

		// file name change
		String originFileName = singleFile.getOriginalFilename();
		String ext = originFileName.substring(originFileName.lastIndexOf("."));
		String savedName = UUID.randomUUID().toString().replace("-", "") + ext;

		// file Save
		try {
			singleFile.transferTo(new File(savePath + "\\" + savedName));
			model.addAttribute("message", "파일 업로드 성공!");

		} catch (IllegalStateException | IOException e) {
			model.addAttribute("message", "파일 업로드 실패!");
		}

        return "redirect:/asset/room/list";

    }
    
	
}