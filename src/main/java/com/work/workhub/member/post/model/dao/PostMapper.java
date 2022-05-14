package com.work.workhub.member.post.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.post.model.dto.CategoryDTO;
import com.work.workhub.member.post.model.dto.PostDTO;

@Mapper
public interface PostMapper {

	List<PostDTO> findAllPost();

	List<CategoryDTO> findAllCategory();

	int writePost(PostDTO post);

	PostDTO findPostByNo(Integer postNo);

	int updatePost(PostDTO post);



}
