package com.spring.blogappapis.controllers;

import com.spring.blogappapis.payloads.PostDto;
import com.spring.blogappapis.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable("userId") Long userId,@PathVariable("categoryId") Long categoryId){
        PostDto savePost = this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<>(savePost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable("userId")Long userId){
        List<PostDto> postDtos = this.postService.getPostsByUser(userId);
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable("categoryId")Long categoryId){
        List<PostDto> postDtos = this.postService.getPostsByCategory(categoryId);
        return  new ResponseEntity<>(postDtos,HttpStatus.OK);
    }
}
