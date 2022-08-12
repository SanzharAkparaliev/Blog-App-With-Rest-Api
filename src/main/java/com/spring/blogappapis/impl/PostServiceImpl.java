package com.spring.blogappapis.impl;

import com.spring.blogappapis.entities.Category;
import com.spring.blogappapis.entities.Post;
import com.spring.blogappapis.entities.User;
import com.spring.blogappapis.exceptions.ResourceNotFoundException;
import com.spring.blogappapis.payloads.PostDto;
import com.spring.blogappapis.repositories.CategoryRepository;
import com.spring.blogappapis.repositories.PostRepository;
import com.spring.blogappapis.repositories.UserRepository;
import com.spring.blogappapis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public PostDto createPost(PostDto postDto, Long userId, Long categoryId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"," user id ",userId));
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category ","category id",categoryId));

        Post post = this.modelMapper.map(postDto,Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepository.save(post);
        return this.modelMapper.map( newPost,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long postId) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public List<Post> getPosts() {
        return null;
    }

    @Override
    public PostDto getPostById(Long postId) {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory(Category category) {
        return null;
    }

    @Override
    public List<Post> getPostsByUser(User user) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
