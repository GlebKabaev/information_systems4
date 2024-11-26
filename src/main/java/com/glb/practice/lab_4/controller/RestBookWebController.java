package com.glb.practice.lab_4.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glb.practice.lab_4.model.Book;
import com.glb.practice.lab_4.model.BookModel;
import com.glb.practice.lab_4.model.ShortBook;

@RestController
@RequestMapping("/api/v1/books")
public class RestBookWebController {
    BookModel bookModel = BookModel.getInstance();
    @GetMapping({"/",""})
    public String getBooks(Model model) {
        List<ShortBook> shortBookList= bookModel.get_k_n_shortList(0,30);
        String stringShortBookList = shortBookList.stream()
                .map(ShortBook::toString)
                .collect(Collectors.joining("\n"));
        return stringShortBookList;
    }
    @GetMapping({"/{id}","/{id}/"})
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
    @DeleteMapping({"/delete/{id}","/delete/{id}/"})
    public void deleteBook(@PathVariable int id){
        bookModel.deleteBookById(id);
    }

}
