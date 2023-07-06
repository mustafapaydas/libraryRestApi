package com.library.libraryApi.Repository;

import com.library.libraryApi.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
