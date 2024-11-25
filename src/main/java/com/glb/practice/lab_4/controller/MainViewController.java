package com.glb.practice.lab_4.controller;

import com.glb.practice.lab_4.factory.view.UpdateAddViewFactory;
import com.glb.practice.lab_4.factory.view.ViewFactory;
import com.glb.practice.lab_4.factory.controller.*;
import com.glb.practice.lab_4.model.Book;
import com.glb.practice.lab_4.model.BookModel;
import com.glb.practice.lab_4.model.ShortBook;
import javax.swing.*;
import java.util.*;

import com.glb.practice.lab_4.view.FullInfoView;
import com.glb.practice.lab_4.view.MainView;
import com.glb.practice.lab_4.view.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainViewController implements Observer {
    private ViewFactory viewFactory;
    private ControllerFactory controllerFactory;
    private MainView mainView = MainView.getInstance();
    
    private static MainViewController mvc;

    private MainViewController() {
        setGetFullInfoActionListener(mainView.getButton());
        setGetActionListener(mainView.getGetButton());
        setAddActionListener(mainView.getAddButton());
        setUpdateActionListener(mainView.getUpdateButton());
        setNextActionListener(mainView.getNext());
        setBackActionListener(mainView.getBack());
        setDeleteActionListener(mainView.getDeleteButton());
        setIgnoreNotNumbers(mainView.getMaxField());
        setIgnoreNotNumbers(mainView.getMinField());
    }

    public static MainViewController getInstance() {
        if (mvc == null) {
            mvc = new MainViewController();
        }
        return mvc;
    }

    private void setGetActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                update();
            }
        });
    }

    private void setAddActionListener(JButton button) {

        button.addActionListener(e->{
                viewFactory = UpdateAddViewFactory.getInstance();
                View updateAddView = viewFactory.create();
                updateAddView.getFrame().setTitle("Add Book");
                for (ActionListener al : updateAddView.getButton().getActionListeners()) {
                    updateAddView.getButton().removeActionListener(al);
                }
                controllerFactory = AddViewControllerFactory.getInstance();
                Controller addViewController = controllerFactory.create();
                addViewController.setActionListener(updateAddView.getButton());
                updateAddView.openFrame();
            });
        }
    //cool lambda func
    private void setDeleteActionListener(JButton button) {
        button.addActionListener(e->{
            BookModel bm = BookModel.getInstance();
            
            try {
                String stringBook = mainView.getJlist().getSelectedValue();
                    // Найдем индекс начала и конца значения id
                    int idStart = stringBook.indexOf("id='") + 4; // 4 символа после "id='"
                    int idEnd = stringBook.indexOf("'", idStart); // Найдем следующую одинарную кавычку после id
                    // Извлекаем значение id
                   int id = Integer.parseInt(stringBook.substring(idStart, idEnd));
            bm.deleteBookById(id);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, "Выберите книгу из списка!");
                    
                    return;
            }
        });
    }

    private void setIgnoreNotNumbers(JTextField field) {
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Игнорируем символ
                }
            }
        });
    }

    private void setUpdateActionListener(JButton button) {

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                viewFactory = UpdateAddViewFactory.getInstance();
                controllerFactory = UpdateViewControllerFactory.getInstance();
                View updateAddView = viewFactory.create();
                updateAddView.getFrame().setTitle("Update Book");
                for (ActionListener al : updateAddView.getButton().getActionListeners()) {
                    updateAddView.getButton().removeActionListener(al);
                }
                Controller updateViewController = controllerFactory.create();
                updateViewController.setActionListener(updateAddView.getButton());
                String stringBook = "";
                int id;
                BookModel bm = BookModel.getInstance();
                Book oldBook;
                try {
                    stringBook = mainView.getJlist().getSelectedValue();
                    // Найдем индекс начала и конца значения id
                    int idStart = stringBook.indexOf("id='") + 4; // 4 символа после "id='"
                    int idEnd = stringBook.indexOf("'", idStart); // Найдем следующую одинарную кавычку после id
                    // Извлекаем значение id
                    id = Integer.parseInt(stringBook.substring(idStart, idEnd));
                    oldBook = bm.getBookById(id);
                    updateAddView.getTitle().setText(oldBook.getTitle());
                    updateAddView.getAuthor().setText(oldBook.getAuthor());
                    updateAddView.getGenre().setText(oldBook.getGenre());
                    updateAddView.getQuantity().setText(String.valueOf(oldBook.getQuantity()));
                    updateAddView.getDepositAmount().setText(String.valueOf(oldBook.getDepositAmount()));
                    updateAddView.getRentalCost().setText(String.valueOf(oldBook.getRentalCost()));
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Выберите книгу из списка!");
                    updateAddView.getFrame().dispose();
                    return;
                }
                updateAddView.openFrame();
            }
        });
    }

    private void setNextActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = Integer.parseInt(mainView.getNumPage().getText());
                k++;
                mainView.setNumPage(k);
                update();
            }
        });
    }

    private void setBackActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = Integer.parseInt(mainView.getNumPage().getText());
                k--;
                if (k < 1)
                    k = 1;
                    mainView.setNumPage(k);
                update();
            }
        });
    }

    private void setGetFullInfoActionListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FullInfoView fullInfoView = FullInfoView.getInstance();
                String stringBook = "";
                int id;
                BookModel bm = BookModel.getInstance();
                Book book;
                try {
                    stringBook = mainView.getJlist().getSelectedValue();
                    // Найдем индекс начала и конца значения id
                    int idStart = stringBook.indexOf("id='") + 4; // 4 символа после "id='"
                    int idEnd = stringBook.indexOf("'", idStart); // Найдем следующую одинарную кавычку после id
                    // Извлекаем значение id
                    id = Integer.parseInt(stringBook.substring(idStart, idEnd));
                    book = bm.getBookById(id);
                    fullInfoView.setId(String.valueOf(id));
                    fullInfoView.setTitle(book.getTitle());
                    fullInfoView.setAuthor(book.getAuthor());
                    fullInfoView.setGenre(book.getGenre());
                    fullInfoView.setQuantity(String.valueOf(book.getQuantity()));
                    fullInfoView.setDepositAmount(String.valueOf(book.getDepositAmount()));
                    fullInfoView.setRentalCost(String.valueOf(book.getRentalCost()));
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, "Выберите книгу из списка!");

                    return;
                }

                fullInfoView.openFrame();
            }
        });
    }

    public void update() {
        JList<String> jlist = mainView.getJlist();
        int n = 30;
        
        if(!mainView.getMaxField().getText().equals("") && !mainView.getMinField().getText().equals("")){
            if(Integer.parseInt(mainView.getMaxField().getText()) < Integer.parseInt(mainView.getMinField().getText())){
                JOptionPane.showMessageDialog(null, "Минимальное значение не должно привышать максимальное");
            }
        }
        String sort = (String) mainView.getSortComboBox().getSelectedItem(); // Выпадающий список сортировки
        int min=0;
        int max=Integer.MAX_VALUE;
        if(!mainView.getMinField().getText().equals("")){
            min=Integer.parseInt(mainView.getMinField().getText());
        }
        if(!mainView.getMaxField().getText().equals("")){
            max=Integer.parseInt(mainView.getMaxField().getText());   
        }
        int k = Integer.parseInt(mainView.getNumPage().getText());
        BookModel bm = BookModel.getInstance();
        List<ShortBook> books;
        String[] arr = new String[n];
        try {

            books = bm.sort_get_k_n_shortList(k - 1, n,sort,min,max);
            for (int i = 0; i < books.size(); i++) {
                arr[i] = books.get(i).toString();
            }
            jlist.setListData(arr);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

}
