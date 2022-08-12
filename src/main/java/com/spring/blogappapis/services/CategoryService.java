package com.spring.blogappapis.services;

import com.spring.blogappapis.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);
    public void deleteCategory(Long categoryId);
    CategoryDto getCategory(Long categoryId);
    List<CategoryDto>getCategories();
}
