package com.library.libraryApi.Entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.library.libraryApi.core.Abstract.AbstractEntity;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "tbl_category")
public class Category extends AbstractEntity<Integer> {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @JsonIncludeProperties({"id"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @OrderBy("title ASC")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
