package com.library.libraryApi.Mapper;

import com.library.libraryApi.DTO.BookAuthorRelationDTO;
import com.library.libraryApi.Entity.BookAuthorRelation;
import com.library.libraryApi.core.AbstractMapper;

public class BookAuthorRelationMapper extends AbstractMapper<Integer, BookAuthorRelationDTO, BookAuthorRelation> {
    @Override
    protected BookAuthorRelationDTO convertToDto(BookAuthorRelation entity) {

        return null;
    }

    @Override
    protected BookAuthorRelation convertToEntity(BookAuthorRelationDTO dto) {
        return null;
    }
}
