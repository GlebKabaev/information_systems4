package com.glb.practice.lab_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glb.practice.lab_4.model.Book;
import com.glb.practice.lab_4.model.BookModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/books")
public class BookWebController {
    BookModel bookModel = BookModel.getInstance();

    @GetMapping({"/",""})
    public String getBooks(Model model) {
        model.addAttribute("books", bookModel.get_k_n_shortList(0,30));
        return "books";
    }
    

}
