package com.spring.blogappapis.payloads;


import com.spring.blogappapis.entities.Category;
import com.spring.blogappapis.entities.Comment;
import com.spring.blogappapis.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private Long postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private UserDto user;
    private CategoryDto category;
    private Set<CommentDto> comments = new HashSet<>();
}
