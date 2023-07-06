package com.library.libraryApi.Api;

import com.library.libraryApi.Logic.BookLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BookApi {
    @Autowired
    BookLogic logic;
    @GetMapping("/zzz")
    public ResponseEntity<String> xxx(){
            logic.create();
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
