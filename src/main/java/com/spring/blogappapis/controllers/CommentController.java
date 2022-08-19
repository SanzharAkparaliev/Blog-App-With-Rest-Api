package com.spring.blogappapis.controllers;

import com.spring.blogappapis.entities.Comment;
import com.spring.blogappapis.payloads.ApiResponse;
import com.spring.blogappapis.payloads.CommentDto;
import com.spring.blogappapis.services.CommentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comment")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable("postId") Long postId){
        CommentDto commentDto = this.commentService.createComment(comment,postId);
        return new ResponseEntity<>(commentDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Long commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment deleted successfully",true),HttpStatus.OK);
    }
}
