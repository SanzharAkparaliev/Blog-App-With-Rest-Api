package com.spring.blogappapis.impl;

import com.spring.blogappapis.entities.Comment;
import com.spring.blogappapis.entities.Post;
import com.spring.blogappapis.exceptions.ResourceNotFoundException;
import com.spring.blogappapis.payloads.CommentDto;
import com.spring.blogappapis.repositories.CommentRepository;
import com.spring.blogappapis.repositories.PostRepository;
import com.spring.blogappapis.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Long postId) {
       Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post","post id" ,postId));
        Comment comment = this.modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepository.save(comment);
        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment  comment = this.commentRepository.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment","comment id",commentId));
        this.commentRepository.delete(comment);
    }
}
