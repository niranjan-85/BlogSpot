package com.blogSpot.backend.Services;

import com.blogSpot.backend.Payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryData);
    CategoryDto updateCategory(CategoryDto updatedCategory,Integer id);
    void deleteCategory();
    CategoryDto getCategory(Integer id);
    List<CategoryDto> getAllCategories();
}
