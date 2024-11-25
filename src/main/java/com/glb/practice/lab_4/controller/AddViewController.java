package com.glb.practice.lab_4.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.glb.practice.lab_4.view.*;
import com.glb.practice.lab_4.model.*;
import com.glb.practice.lab_4.factory.view.*;

public class AddViewController implements Controller {
private static AddViewController addViewController;
private ViewFactory viewFactory;
private View updateAddView;
private BookModel bm=BookModel.getInstance();
private AddViewController(){
    viewFactory=UpdateAddViewFactory.getInstance();
    updateAddView= viewFactory.create();
}
public static AddViewController getInstance(){
    if(addViewController==null){
        addViewController=new AddViewController();
    }
    return addViewController;
}
public  void setActionListener(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            String title = updateAddView.getTitle().getText();
            String author = updateAddView.getAuthor().getText();
            String genre = updateAddView.getGenre().getText();
            int quantity = Integer.parseInt(updateAddView.getQuantity().getText());
            double depositAmount = Double.parseDouble(updateAddView.getDepositAmount().getText());
            double rentalCost = Double.parseDouble(updateAddView.getRentalCost().getText());
            Book book=new Book(quantity, title, author, genre, quantity, depositAmount, rentalCost);
            bm.addBook(book);
            
            }
        });
    }



    
}
