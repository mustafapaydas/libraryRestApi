package com.library.libraryApi.Entity;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.library.libraryApi.Enum.EnumAuthorType;
import com.library.libraryApi.core.AbstractEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_book_author_relation")
public class BookAuthorRelation extends AbstractEntity<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JsonIncludeProperties({"id"})
    @ManyToOne
    @JoinColumn(
            name = "book",
            referencedColumnName = "id",
            nullable = false,
            foreignKey =
            @ForeignKey(
                    name = "fk_book_author",
                    value = ConstraintMode.CONSTRAINT,
                    foreignKeyDefinition =
                            "FOREIGN KEY (book) REFERENCES tbl_book(id) ON DELETE SET NULL"))
    private Book book;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id", nullable = false)
    private Author author;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "author_type",columnDefinition = "enum_author_type")
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
