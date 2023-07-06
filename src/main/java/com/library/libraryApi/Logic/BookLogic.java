package com.library.libraryApi.Logic;

import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookLogic {
    @Autowired
    BookRepository _repo;

    public void create() {
        Book book = new Book();
        book.setTitle("xxxxxxxx");
        _repo.save(book);
    }
}
