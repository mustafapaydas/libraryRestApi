package com.library.libraryApi.DTO;

import com.library.libraryApi.Entity.BookAuthorRelation;
import com.library.libraryApi.core.AbstractDTO;

import java.util.List;

public class BookDTO extends AbstractDTO<Integer> {
    private Integer id;
    private String title;
    private String isbn;
    private Integer count;
    private Integer pageCount;
    private CategoryDTO categoryDTO;
    private List<BookAuthorRelationDTO> bookAuthorRelations;



    public List<BookAuthorRelationDTO> getBookAuthorRelations() {
        return bookAuthorRelations;
    }

    public void setBookAuthorRelations(List<BookAuthorRelationDTO> bookAuthorRelations) {
        this.bookAuthorRelations = bookAuthorRelations;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
