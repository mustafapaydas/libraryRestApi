package com.library.libraryApi.Mapper;

import com.library.libraryApi.DTO.BookDTO;
import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.core.AbstractMapper;
import org.springframework.util.ObjectUtils;

public class BookMapper extends AbstractMapper<Integer,BookDTO, Book> {
    CategoryMapper categoryMapper = new CategoryMapper();
    AuthorMapper authorMapper = new AuthorMapper();
    @Override
    protected BookDTO convertToDto(Book entity) {
        BookDTO dto = new BookDTO();
        dto.setTitle(entity.getTitle());
        if (!ObjectUtils.isEmpty(entity.getCategory())){
            dto.setCategoryDTO(categoryMapper.toDTO(entity.getCategory()));
        }

        dto.setIsbn(entity.getIsbn());
        dto.setCount(entity.getCount());
        dto.setPageCount(entity.getPageCount());
        return dto;
    }

    @Override
    protected Book convertToEntity(BookDTO dto) {
        Book entity = new Book();
        entity.setTitle(dto.getTitle());
        if (!ObjectUtils.isEmpty(dto.getCategoryDTO())){
            entity.setCategory(categoryMapper.toEntity(dto.getCategoryDTO()));
        }
        if (!ObjectUtils.isEmpty(dto.getBookAuthorRelations())){
//            entity.setBookAuthorRelations();
        }

        entity.setIsbn(dto.getIsbn());
        entity.setPageCount(dto.getPageCount());
        entity.setCount(dto.getCount());
        return entity;
    }
}
