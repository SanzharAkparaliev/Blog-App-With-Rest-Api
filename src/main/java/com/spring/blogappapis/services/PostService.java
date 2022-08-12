package com.spring.blogappapis.services;

import com.spring.blogappapis.entities.Post;
import com.spring.blogappapis.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto post,Long userId,Long categoryId);
    PostDto updatePost(PostDto postDto,Long postId);
    void deletePost(Long postId);
    List<PostDto> getPosts();
    PostDto getPostById(Long postId);
    List<PostDto> getPostsByCategory(Long categoryId);
    List<PostDto> getPostsByUser(Long userId);
    List<Post> searchPosts(String keyword);
}
