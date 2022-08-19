package com.spring.blogappapis.services;

import com.spring.blogappapis.payloads.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto,Long postId);
    void deleteComment(Long commentId);
}
