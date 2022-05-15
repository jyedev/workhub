package com.work.workhub.member.post.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.member.member.dto.UserImpl;
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
	
	
	//게시판 목록 조회
	@GetMapping("list")
	public ModelAndView findPostList(ModelAndView mv) {
		
		List<PostDTO> postList = postService.findAllPost();
		
		mv.addObject("postList", postList);
		mv.setViewName("/post/list");
		
		return mv;
	}
	
	
	//게시글 상세페이지
	@GetMapping("detail/no/{postNo}")
	public ModelAndView selectPostDetail(ModelAndView mv, @PathVariable("postNo") Integer postNo) {

		PostDTO postDTO = postService.findPostByNo(postNo);
		
		mv.addObject("postDTO", postDTO);
		
		mv.setViewName("/post/detail");
		
		return mv;
	}
	
	
	//게시글 카테고리
	@GetMapping(value="category", produces="application/json; charset=UTF-8")
	@ResponseBody
	public List<CategoryDTO> findCategoryList(){
		return postService.findAllCategory();
	}
	
	
	//게시글 작성
	@GetMapping("write")
	public void writePage() {}
	
	@PostMapping("write")
	public String writePost(@ModelAttribute PostDTO post, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) throws Exception {
		
		post.setNo(user.getNo());
		log.info("등록 요청 글 : {}", post);
		
		postService.writePost(post);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("writePost", null, locale));
		
		return "redirect:/post/list";
		
	}
	
	
	//게시글 수정
	@GetMapping("update/no/{postNo}")
	public ModelAndView updatePost(ModelAndView mv, @PathVariable("postNo") Integer postNo) {

		PostDTO postDTO = postService.findPostByNo(postNo);
		
		mv.addObject("postDTO", postDTO);
		mv.setViewName("/post/update");
		
		return mv;
	}
	
	//제목밖에 안넘어옴ㅜ
	@PostMapping("update/no/{postNo}")
	public String updatePost(@RequestBody PostDTO post, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) throws Exception {
		
		post.setNo(user.getNo());
		log.info("수정 요청 postNo : " , post.getPostNo());
		log.info("수정 요청 글 : {}", post);
		
		postService.writePost(post);
		
		rttr.addFlashAttribute("successMessage", messageSource.getMessage("writePost", null, locale));
		
		return "redirect:/post/list";
	}
	
	
	 //게시글 삭제
	@GetMapping("delete/no/{postNo}")
	public String deletePost(@PathVariable("postNo") Integer postNo, @AuthenticationPrincipal UserImpl user) {
		
		PostDTO post = postService.findPostByNo(postNo);
		
		post.setNo(user.getNo());
		log.info("삭제 요청 글 : {}", post.getPostNo());
		
		postService.deletePost(postNo);
		
		
		return null;
	}

	
	
}
