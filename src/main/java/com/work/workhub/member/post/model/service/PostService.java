package com.work.workhub.member.post.model.service;

import java.util.List;

import com.work.workhub.member.post.model.dto.CategoryDTO;
import com.work.workhub.member.post.model.dto.PostDTO;

public interface PostService {

	List<PostDTO> findAllPost();

	List<CategoryDTO> findAllCategory();

	boolean writePost(PostDTO post) throws Exception;

	PostDTO findPostByNo(Integer postNo);

	int deletePost(Integer postNo);

	
}
