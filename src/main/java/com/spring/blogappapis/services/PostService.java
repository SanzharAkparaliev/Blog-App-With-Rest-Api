package com.spring.blogappapis.services;

import com.spring.blogappapis.entities.Category;
import com.spring.blogappapis.entities.Post;
import com.spring.blogappapis.entities.User;
import com.spring.blogappapis.payloads.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto post,Long userId,Long categoryId);
    PostDto updatePost(PostDto postDto,Long postId);
    void deletePost(Long postId);
    List<Post> getPosts();
    PostDto getPostById(Long postId);
    List<Post> getPostsByCategory(Category category);
    List<Post> getPostsByUser(User user);
    List<Post> searchPosts(String keyword);
}
