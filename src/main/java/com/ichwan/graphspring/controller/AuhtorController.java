package com.ichwan.graphspring.controller;

import com.ichwan.graphspring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class AuhtorController {

    @Autowired
    private AuthorService authorService;

    @QueryMapping
    public ResponseEntity<?> getAuthors(){
        return ResponseEntity.ok(authorService.getAuthors());
    }
}
