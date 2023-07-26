package com.library.libraryApi.Mapper;

import com.library.libraryApi.DTO.AuthorDTO;
import com.library.libraryApi.DTO.CategoryDTO;
import com.library.libraryApi.Entity.Author;
import com.library.libraryApi.Entity.Category;
import com.library.libraryApi.core.AbstractMapper;

public class AuthorMapper extends AbstractMapper<Integer, AuthorDTO, Author> {
    public AuthorMapper() {
        super(AuthorDTO.class, Author.class);
    }

    public AuthorMapper(AbstractMapper<?, ?, ?> parent) {
        super(parent, AuthorDTO.class, Author.class);
    }

    @Override
    protected AuthorDTO convertToDto(Author entity) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setFullName(entity.getFullName());
        dto.setLastName(entity.getLastName());

        return dto;
    }

    @Override
    protected Author convertToEntity(AuthorDTO dto) {
        Author entity = new Author();

        return entity;
    }

}
