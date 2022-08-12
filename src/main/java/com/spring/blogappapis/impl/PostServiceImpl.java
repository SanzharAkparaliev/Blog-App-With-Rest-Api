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
import java.util.stream.Collectors;

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
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ","post id",postId));
        post.setImageName(postDto.getImageName());
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());

        Post updatedPost = this.postRepository.save(post);
        return this.modelMapper.map(updatedPost,PostDto.class);
    }

    @Override
    public void deletePost(Long postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post ","post id",postId));
        this.postRepository.delete(post);
    }

    @Override
    public List<PostDto> getPosts() {
        List<Post> allposts = this.postRepository.findAll();
        List<PostDto> postDtos = allposts.stream().map(post -> modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Long postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","post id",postId));
        return this.modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category"," category id",categoryId));
        List<Post> posts = this.postRepository.findAllByCategory(category);
        List<PostDto> postDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<PostDto> getPostsByUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User"," user id",userId));
        List<Post> posts = this.postRepository.findAllByUser(user);
        List<PostDto> postDtos = posts.stream().map(post -> this.modelMapper.map(post,PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
