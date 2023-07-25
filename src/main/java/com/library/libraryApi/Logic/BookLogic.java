package com.library.libraryApi.Logic;

import com.library.libraryApi.Entity.Book;
import com.library.libraryApi.Repository.BookRepository;
import com.library.libraryApi.core.AbstractLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class BookLogic extends AbstractLogic<Integer, Book> {
    @Autowired
    BookRepository bookRepository;

    @Override
    protected JpaRepository<Book, Integer> getRepository() {
        System.out.println("\n\nccccccccccccccc");
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        System.out.println("\n\nccccccccccccccc");

        return bookRepository;
    }
}
