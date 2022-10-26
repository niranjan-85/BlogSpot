package com.blogSpot.backend.Services;

import com.blogSpot.backend.Beans.CategoryBean;
import com.blogSpot.backend.Beans.UserBean;
import com.blogSpot.backend.Payloads.CategoryDto;
import com.blogSpot.backend.Payloads.UserDto;
import com.blogSpot.backend.Repository.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryData) {
        return null;
    }

    @Override
    public CategoryDto updateCategory(CategoryDto updatedCategory, Integer id) {
        return null;
    }

    @Override
    public void deleteCategory() {

    }

    @Override
    public CategoryDto getCategory(Integer id) {
        return null;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return null;
    }

    // Mapper methods

    public CategoryBean dtoToCategoryBean(CategoryDto categoryDto) {
        CategoryBean category = this.modelMapper.map(categoryDto, CategoryBean.class);
        return category;
    }

    public CategoryDto categoryBeanToDto(CategoryBean category) {
        CategoryDto categoryDto = this.modelMapper.map(category, CategoryDto.class);
        return categoryDto;
    }
}
