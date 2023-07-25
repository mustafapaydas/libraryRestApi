package com.library.libraryApi.Entity;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import com.library.libraryApi.core.AbstractEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "tbl_book")
public class Book extends AbstractEntity<Integer> {
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
    @Nullable
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "book",
            orphanRemoval = true,
            cascade = CascadeType.ALL)
    private List<BookAuthorRelation> bookAuthorRelations;

    @Nullable
    public List<BookAuthorRelation> getBookAuthorRelations() {
        return bookAuthorRelations;
    }

    public void setBookAuthorRelations(@Nullable List<BookAuthorRelation> bookAuthorRelations) {
        this.bookAuthorRelations = bookAuthorRelations;
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



    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
