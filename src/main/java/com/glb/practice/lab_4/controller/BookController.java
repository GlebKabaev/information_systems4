package com.glb.practice.lab_4.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface BookController {
    public String getBooks(Model model);

    public String getBook(int id, Model model);

    public String deleteBook(int id);

    public String formNewBook(Model model);

    public String formEditBook(Model model, int id);

    public String formUpdateBook(int id,
            String title,
            String author,
            String genre,
            int quantity,
            double depositAmount,
            double rentalCost);

    public String saveBook(String title,
            String author,
            String genre,
            int quantity,
            double depositAmount,
            double rentalCost);

}
