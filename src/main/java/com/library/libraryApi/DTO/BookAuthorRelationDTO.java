package com.library.libraryApi.DTO;

import com.library.libraryApi.Entity.Author;
import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.Enum.EnumAuthorType;
import com.library.libraryApi.core.AbstractDTO;

public class BookAuthorRelationDTO extends AbstractDTO<Integer> {
    private Integer id;
    private BookDTO book;
    private AuthorDTO author;
    private EnumAuthorType authorType;

    public BookDTO getBook() {
        return book;
    }

    public void setBook(BookDTO book) {
        this.book = book;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
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
