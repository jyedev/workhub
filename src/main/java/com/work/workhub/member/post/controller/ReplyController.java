package com.work.workhub.member.post.controller;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.workhub.member.member.controller.MemberController;
import com.work.workhub.member.post.model.service.PostService;
import com.work.workhub.member.post.model.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/reply")
public class ReplyController {
	
	private ReplyService replyService;
	private MessageSource messageSource;
	
	
	//댓글 등록
//	@GetMapping("writeReply")
//	public String writeReply(@ModelAttribute ReplyDTO replyDTO, @PathVariable("postNo") Integer postNo, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr) throws Exception {
//		
//		replyDTO.setNo(user.getNo());
//		log.info("등록 요청 댓글 : {}", replyDTO);
//		
//		postService.writeReply(replyDTO);
//		
//		return "redirect:/post/detail/no/{postNo}";
//	}
	
	
	//댓글 수정
//	@GetMapping("update/no/{postNo}")
//	public ModelAndView updatePost(ModelAndView mv, @PathVariable("postNo") Integer postNo) {
//
//		PostDTO postDTO = postService.findPostByNo(postNo);
//		
//		mv.addObject("postDTO", postDTO);
//		mv.setViewName("/post/update");
//		
//		return mv;
//	}
	
	//제목밖에 안넘어옴ㅜ
//	@PostMapping("update/no/{postNo}")
//	public String updatePost(@RequestBody PostDTO post, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) throws Exception {
//		
//		post.setNo(user.getNo());
//		log.info("수정 요청 postNo : " , post.getPostNo());
//		log.info("수정 요청 글 : {}", post);
//		
//		postService.writePost(post);
//		
//		rttr.addFlashAttribute("successMessage", messageSource.getMessage("writePost", null, locale));
//		
//		return "redirect:/post/list";
//	}
	
	//댓글 삭제
//	@GetMapping("delete/no/{replyNo}")
//	public String deletePost(@PathVariable("replyNo") Integer replyNo, @AuthenticationPrincipal UserImpl user, RedirectAttributes rttr, Locale locale) {
//		
//		ReplyDTO reply = postService.findReplyByNo(replyNo);
//		
//		post.setNo(user.getNo());
//		log.info("삭제 요청 글 : {}", post.getPostNo());
//		
//		postService.deletePost(postNo);
//		
//		rttr.addFlashAttribute("successMessage", messageSource.getMessage("deletePost", null, locale));
//		
//		return "redirect:/post/list";
//	}

	

}
