package com.spring.blogappapis.controllers;


import com.spring.blogappapis.payloads.ApiResponse;
import com.spring.blogappapis.payloads.CategoryDto;
import com.spring.blogappapis.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto category = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("catId") Long categoryId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("catId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(new ApiResponse("category is deleted seccessfully !!",true),HttpStatus.OK);
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getSingleCategory(@PathVariable("catId") Long categoryId){
        CategoryDto categoryDto = this.categoryService.getCategory(categoryId);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
        List<CategoryDto> categoryDtos = this.categoryService.getCategories();
        return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
    }
}
