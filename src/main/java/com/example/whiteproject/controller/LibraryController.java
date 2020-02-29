package com.example.whiteproject.controller;

import com.example.whiteproject.pojo.Book;
import com.example.whiteproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("api/books")
    public List<Book> list(){
        return bookService.list();
    }
}
