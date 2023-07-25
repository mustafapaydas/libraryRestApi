package com.library.libraryApi.Api;

import com.library.libraryApi.DTO.BookDTO;
import com.library.libraryApi.Service.BookService;
import com.library.libraryApi.core.AbstractApi;
import com.library.libraryApi.core.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/book")
public class BookApi extends AbstractApi<BookDTO,Integer> {
    @Autowired
    BookService bookService;

    @Override
    protected AbstractService getService() {
        return bookService;
    }
}
