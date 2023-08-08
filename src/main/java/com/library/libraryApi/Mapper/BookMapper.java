package com.library.libraryApi.Mapper;

import com.library.libraryApi.DTO.BookDTO;
import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.core.Abstract.AbstractMapper;
import org.springframework.util.ObjectUtils;

public class BookMapper extends AbstractMapper<Integer,BookDTO, Book> {

    public BookMapper() {
        super(BookDTO.class, Book.class);
    }

    public BookMapper(AbstractMapper<?, ?, ?> parent) {
        super(parent,BookDTO.class, Book.class);
    }
    public BookMapper(AbstractMapper<?, ?, ?> parent,Integer level) {
        super(parent,BookDTO.class, Book.class,level);
    }
    CategoryMapper categoryMapper = new CategoryMapper();
    AuthorMapper authorMapper = new AuthorMapper();


    @Override
    protected BookDTO convertToDto(Book entity) {
    BookAuthorRelationMapper bookAuthorRelationMapper = new BookAuthorRelationMapper(this);
        BookDTO dto = new BookDTO();
        dto.setTitle(entity.getTitle());
        if (!ObjectUtils.isEmpty(entity.getCategory())){
            dto.setCategoryDTO(categoryMapper.toDTO(entity.getCategory()));
        }
//        if (level>0){
//            dto.setBookAuthorRelations(bookAuthorRelationMapper.toListDTO(entity.getBookAuthorRelations()));
//        }
        dto.setIsbn(entity.getIsbn());
        dto.setCount(entity.getCount());
        dto.setPageCount(entity.getPageCount());
        return dto;
    }

    @Override
    protected Book convertToEntity(BookDTO dto) {
        BookAuthorRelationMapper bookAuthorRelationMapper = new BookAuthorRelationMapper(this);
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
