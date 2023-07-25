package com.DEAiFISH.tx.controller;

import com.DEAiFISH.tx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    public void buyBook(Integer bookId, Integer userId) {
        bookService.buyBook(bookId, userId);
    }
}