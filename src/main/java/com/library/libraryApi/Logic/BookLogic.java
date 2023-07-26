package com.library.libraryApi.Logic;

import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.Repository.BookRepository;
import com.library.libraryApi.core.Abstract.AbstractLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public class BookLogic extends AbstractLogic<Integer, Book> {
    @Autowired
    BookRepository bookRepository;

    @Override
    protected JpaRepository<Book, Integer> getRepository() {
        return bookRepository;
    }
}
