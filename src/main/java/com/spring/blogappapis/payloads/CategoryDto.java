package com.spring.blogappapis.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CategoryDto {
    private Long categoryId;

    @NotBlank
    @Size(min = 4,message = "min size of category title is 4")
    private String categoryTitle;
    @NotBlank
    @Size(min = 10,message = "min size of category desc is 10")
    private String categoryDescription;
}
