package com.glb.practice.lab_4.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.glb.practice.lab_4.factory.view.UpdateAddViewFactory;
import com.glb.practice.lab_4.factory.view.ViewFactory;
import com.glb.practice.lab_4.model.Book;
import com.glb.practice.lab_4.model.BookModel;
import com.glb.practice.lab_4.view.View;
import com.glb.practice.lab_4.view.MainView;
public class UpdateViewController implements Controller {
    private static UpdateViewController uvc;
    private ViewFactory viewFactory;
    private MainView mv= MainView.getInstance();
    private UpdateViewController(){
        //setUpdateBookActionListener(updateAddView.getButton());
    }
    public static UpdateViewController getInstance(){
        if(uvc==null){
            uvc=new UpdateViewController();
        }
        return uvc;
    }
    public  void setActionListener(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewFactory = UpdateAddViewFactory.getInstance();
                View updateAddView = viewFactory.create();
                String stringBook="";
                int id;
                BookModel bm=BookModel.getInstance();
               
                try{
                stringBook=mv.getJlist().getSelectedValue();
                // Найдем индекс начала и конца значения id
                int idStart = stringBook.indexOf("id='") + 4;  // 4 символа после "id='"
                int idEnd = stringBook.indexOf("'", idStart);  // Найдем следующую одинарную кавычку после id 
                // Извлекаем значение id
                id=Integer.parseInt(stringBook.substring(idStart, idEnd));
                
                }catch(Exception err){
                    JOptionPane.showMessageDialog(null, "Выберите книгу из списка!");
                    updateAddView.getFrame().dispose();
                    return;
                }
                String title =updateAddView.getTitle().getText();
                String author = updateAddView.getAuthor().getText();
                String genre = updateAddView.getGenre().getText();
                int quantity = Integer.parseInt(updateAddView.getQuantity().getText());
                double depositAmount = Double.parseDouble(updateAddView.getDepositAmount().getText());
                double rentalCost=Double.parseDouble(updateAddView.getRentalCost().getText());
                Book book=new Book(id,title,author,genre,quantity,depositAmount,rentalCost);
                
                bm.updateBookById(id, book);
            }
        });
    
    }
}
