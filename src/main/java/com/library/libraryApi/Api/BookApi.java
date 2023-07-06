package com.library.libraryApi.Api;

import com.library.libraryApi.DTO.BookDTO;
import com.library.libraryApi.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookApi {
    @Autowired
    BookService bookService;
    @PostMapping("/")
    public ResponseEntity<BookDTO> xxx(@RequestBody BookDTO bookDTO){
            return new ResponseEntity<BookDTO>(bookService.create(bookDTO),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> vvv(@PathVariable Integer id){
        return new ResponseEntity<BookDTO>(bookService.findById(id),HttpStatus.OK);
    }
}
