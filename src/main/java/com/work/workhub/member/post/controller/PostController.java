package com.work.workhub.member.post.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.member.post.model.dto.CategoryDTO;
import com.work.workhub.member.post.model.dto.PostDTO;
import com.work.workhub.member.post.model.service.PostService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/post")
public class PostController {
	
	private PostService postService;
	private MessageSource messageSource;
	
	@Autowired
	public PostController(PostService postService, MessageSource messageSource) {
		this.postService = postService;
		this.messageSource = messageSource;
	}
	
	@GetMapping("list")
	public ModelAndView findPostList(ModelAndView mv) {
		
//		List<PostDTO> postList = postService.findAllPost();
//		
//		mv.addObject("postList", postList);
		mv.setViewName("post/list");
		
		return mv;
	}
	
	//detail 따로 빼서 작성
	@GetMapping("detail")
	public ModelAndView findPostDetail(ModelAndView mv) {
		
		mv.setViewName("post/detail");
		
		return mv;
	}
	
	//category
	@GetMapping(value="category", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<CategoryDTO> findCategoryList(){
		return postService.findAllCategory();
	}
	
	//write
	@GetMapping("write")
	public void writePage() {}
	
	@PostMapping("write")
	public String writePost(@ModelAttribute PostDTO post, RedirectAttributes rttr, Locale locale) throws Exception {
		
		log.error("등록 요청 글 : {}", post);
		log.warn("등록 요청 글 : {}", post);
		log.info("등록 요청 글 : {}", post);
		log.debug("등록 요청 글 : {}", post);
		log.trace("등록 요청 글 : {}", post);
		
		postService.writePost(post);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("writePost", null, locale));
		
		return "redirect:/post/list";
		
	}
}
