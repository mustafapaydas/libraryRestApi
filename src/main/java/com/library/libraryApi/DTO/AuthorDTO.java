package com.library.libraryApi.DTO;

import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.core.Abstract.AbstractDTO;

import java.util.List;

public class AuthorDTO extends AbstractDTO<Integer> {
    private Integer id;
    private String firstName;
    private String lastName;
    private String fullName;
    private List<Book> books;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
