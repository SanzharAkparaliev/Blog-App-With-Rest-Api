package com.spring.blogappapis.services;

import com.spring.blogappapis.payloads.PostDto;
import com.spring.blogappapis.payloads.PostResponse;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto post,Long userId,Long categoryId);
    PostDto updatePost(PostDto postDto,Long postId);
    void deletePost(Long postId);
    PostResponse getPosts(int pageNumber, int pageSize,String sortBy,String sortDir);
    PostDto getPostById(Long postId);
    List<PostDto> getPostsByCategory(Long categoryId);
    List<PostDto> getPostsByUser(Long userId);
    List<PostDto> searchPosts(String keyword);
}
