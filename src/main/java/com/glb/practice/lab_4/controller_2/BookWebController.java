package com.glb.practice.lab_4.controller_2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glb.practice.lab_4.model.Book;
import com.glb.practice.lab_4.model.BookModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/books")
public class BookWebController {
    BookModel bookModel = BookModel.getInstance();

    // @GetMapping({"/",""})
    // public String getBooks(Model model) {
    // model.addAttribute("books", bookModel.get_k_n_shortList(0,30));
    // return "books";
    // }
    @GetMapping("/{id}")
    public String getBook(@PathVariable int id) {
        System.out.println("Requested book ID: " + id);
        Book book = bookModel.getBookById(id);
        if (book == null) {
            System.out.println("Book not found for ID: " + id);
            return "Book not found"; // Это вернется как JSON, так как используется @RestController
        }
        System.out.println("Found book: " + book);
        return book.toJson();
    }

}
