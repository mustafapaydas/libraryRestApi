package com.library.libraryApi.Mapper;

import com.library.libraryApi.DTO.CategoryDTO;
import com.library.libraryApi.Entity.Category;
import com.library.libraryApi.core.Abstract.AbstractMapper;

public class CategoryMapper extends AbstractMapper<Integer, CategoryDTO,Category> {
    @Override
    protected CategoryDTO convertToDto(Category entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setTitle(entity.getTitle());
        return dto;
    }

    @Override
    protected Category convertToEntity(CategoryDTO dto) {
        Category entity = new Category();
        entity.setTitle(dto.getTitle());
        return entity;
    }

}
