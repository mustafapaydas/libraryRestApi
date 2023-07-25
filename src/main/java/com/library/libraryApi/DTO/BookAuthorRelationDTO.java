package com.library.libraryApi.DTO;

import com.library.libraryApi.Entity.Author;
import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.Enum.EnumAuthorType;
import com.library.libraryApi.core.AbstractDTO;

public class BookAuthorRelationDTO extends AbstractDTO<Integer> {
    private Integer id;
    private Book book;
    private Author author;
    private EnumAuthorType authorType;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public EnumAuthorType getAuthorType() {
        return authorType;
    }

    public void setAuthorType(EnumAuthorType authorType) {
        this.authorType = authorType;
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
