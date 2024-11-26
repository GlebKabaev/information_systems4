package com.glb.practice.lab_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glb.practice.lab_4.model.Book;
import com.glb.practice.lab_4.model.BookModel;

@RestController
@RequestMapping("/api/v1/books")
public class RestBookController {
    BookModel bookModel = BookModel.getInstance();
    @GetMapping("/{id}")
    public String getBook(@PathVariable int id) {
        
        System.out.println("Requested book ID: " + id);
        Book book = bookModel.getBookById(id);
        if (book == null) {
            System.out.println("Book not found for ID: " + id);
            return "Book not found"; 
        }
        System.out.println("Found book: " + book);
        return book.toJson();
    }
}
