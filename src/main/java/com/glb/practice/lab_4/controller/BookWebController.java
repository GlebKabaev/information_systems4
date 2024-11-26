package com.glb.practice.lab_4.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @GetMapping({"/{id}","/{id}/"})
    public String getBook(@PathVariable int id,Model model) {
        model.addAttribute("book", bookModel.getBookById(id));
        return "book";
    }
    @DeleteMapping({"/delete/{id}","/delete/{id}/"})
    public String deleteBook(@PathVariable int id){
        bookModel.deleteBookById(id);
        return "books";
    }

}
