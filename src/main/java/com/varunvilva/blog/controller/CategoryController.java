package com.varunvilva.blog.controller;


import com.varunvilva.blog.constant.Message;
import com.varunvilva.blog.domain.entity.Category;
import com.varunvilva.blog.dto.in.CategoryRequest;
import com.varunvilva.blog.dto.out.ApiResponse;
import com.varunvilva.blog.dto.out.CategoryDto;
import com.varunvilva.blog.mapper.CategoryMapper;
import com.varunvilva.blog.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService service;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryDto>>>getAllCategories(){
        List<Category>categories = service.getAllCategories();
        List<CategoryDto> categoryDto= categories.stream().map(categoryMapper::toDto).toList();
        return ResponseEntity.status(HttpStatus.valueOf(200)).body(new ApiResponse<>(categoryDto, Message.SUCCESS));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> createCategory(@Valid @RequestBody CategoryRequest categoryRequest){
        Category category = categoryMapper.toEntity(categoryRequest);
        service.createCategory(category);
        return ResponseEntity.status(HttpStatus.valueOf(201)).body(new ApiResponse<>(category, Message.SUCCESS));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteCategory(@PathVariable UUID id){
        service.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
