package com.glb.practice.lab_4.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glb.practice.lab_4.model.Book;
import com.glb.practice.lab_4.model.BookModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/books")
public class BookWebController implements BookController {
    BookModel bookModel = BookModel.getInstance();

    @GetMapping({"/",""})
    public String getBooks(Model model) {
        model.addAttribute("books", bookModel.get_k_n_shortList(0,Integer.MAX_VALUE));
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

    @GetMapping({"/new","/new/"})
    public String formNewBook(Model model) {
       // Book book =new Book(0,"","","",0,0,0);//а так нормально вообще?
        model.addAttribute("book", new Book());
        return "book_add"; 
    }
    @GetMapping({"/edit/{id}","/edit/{id}/"})
    public String formEditBook(Model model, @PathVariable int id) {
        Book book = bookModel.getBookById(id);
        model.addAttribute("book", book);
        return "book_edit"; 
    }
    
    @PostMapping({"/update/{id}","/update/{id}/"})
    public String formUpdateBook(@PathVariable int id,
        @RequestParam("title") String title,
        @RequestParam("author") String author,
        @RequestParam("genre") String genre,
        @RequestParam("quantity") int quantity,
        @RequestParam("depositAmount") double depositAmount,
        @RequestParam("rentalCost") double rentalCost) {
            Book book = new Book(id,title,author,genre,quantity,depositAmount,rentalCost);
            bookModel.updateBookById(id, book);
            return "redirect:/books";
    }
    @PostMapping({"/save", "/save/"})
    public String saveBook(
        @RequestParam("title") String title,
        @RequestParam("author") String author,
        @RequestParam("genre") String genre,
        @RequestParam("quantity") int quantity,
        @RequestParam("depositAmount") double depositAmount,
        @RequestParam("rentalCost") double rentalCost) {

            Book book = new Book(0, title, author, genre, quantity, depositAmount, rentalCost);
            bookModel.addBook(book);

        return "redirect:/books";
    }
}
