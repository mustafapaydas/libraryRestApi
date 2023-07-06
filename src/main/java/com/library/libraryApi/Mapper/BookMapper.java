package com.library.libraryApi.Mapper;

import com.library.libraryApi.DTO.BookDTO;
import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.core.AbstractMapper;

public class BookMapper extends AbstractMapper<BookDTO, Book> {
    @Override
    protected BookDTO convertToDto(Book entity) {
        BookDTO dto = new BookDTO();
        dto.setTitle(entity.getTitle());
        dto.setIsbn(entity.getIsbn());
        dto.setCount(entity.getCount());
        dto.setPageCount(entity.getPageCount());
        return dto;
    }

    @Override
    protected Book convertToEntity(BookDTO dto) {
        Book entity = new Book();
        entity.setTitle(dto.getTitle());
        entity.setIsbn(dto.getIsbn());
        entity.setPageCount(dto.getPageCount());
        entity.setCount(dto.getCount());
        return entity;
    }
}
