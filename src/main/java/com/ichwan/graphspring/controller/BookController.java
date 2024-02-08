package com.ichwan.graphspring.controller;

import com.ichwan.graphspring.dto.BookInput;
import com.ichwan.graphspring.entity.Book;
import com.ichwan.graphspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @MutationMapping
    Book addBook(@Argument BookInput bookInput){
        return bookService.create(bookInput);
    }
}
