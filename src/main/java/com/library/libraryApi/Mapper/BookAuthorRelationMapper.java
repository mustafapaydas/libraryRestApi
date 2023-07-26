package com.library.libraryApi.Mapper;

import com.library.libraryApi.DTO.BookAuthorRelationDTO;
import com.library.libraryApi.Entity.BookAuthorRelation;
import com.library.libraryApi.core.AbstractMapper;

public class BookAuthorRelationMapper extends AbstractMapper<Integer, BookAuthorRelationDTO, BookAuthorRelation> {
    AuthorMapper authorMapper = new AuthorMapper(this);
    BookMapper bookMapper = new BookMapper(this,0);
    private Integer level;
    public BookAuthorRelationMapper() {
        super(BookAuthorRelationDTO.class, BookAuthorRelation.class);
    }

    public BookAuthorRelationMapper(AbstractMapper<?, ?, ?> parent) {
        super(parent, BookAuthorRelationDTO.class, BookAuthorRelation.class);
    }
    public BookAuthorRelationMapper(AbstractMapper<?, ?, ?> parent,Integer level) {
        super(parent, BookAuthorRelationDTO.class, BookAuthorRelation.class);
        this.level = level;
    }
    @Override
    protected BookAuthorRelationDTO convertToDto(BookAuthorRelation entity) {
        BookAuthorRelationDTO dto = new BookAuthorRelationDTO();
        dto.setId(entity.getId());
        dto.setAuthorType(entity.getAuthorType());
        dto.setAuthor(authorMapper.convertToDto(entity.getAuthor()));
        dto.setBook(bookMapper.convertToDto(entity.getBook()));
        return dto;
    }

    @Override
    protected BookAuthorRelation convertToEntity(BookAuthorRelationDTO dto) {
        BookAuthorRelation entity = new BookAuthorRelation();
        entity.setAuthor(authorMapper.toEntity(dto.getAuthor()));
        entity.setBook(bookMapper.convertToEntity(dto.getBook()));
        entity.setAuthorType(entity.getAuthorType());
        entity.setId(entity.getId());
        return entity;
    }
}
