package com.library.libraryApi.Entity;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import com.library.libraryApi.core.AbstractEntity;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tbl_book")
public class Book extends AbstractEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "isbn",nullable = false,unique = true)
    private String isbn;
    @Column(name = "page_count",nullable = false)
    private Integer pageCount;
    @Column(name = "count")
    private Integer count;
    @JoinColumn(name = "category")
    @JsonIncludeProperties({"id"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "author",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Author> authors;

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

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
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
