package com.glb.practice.lab_4.view;
import javax.swing.*;
public interface View {
    public void openFrame();
    //getters
    public JFrame getFrame();
    public JTextField getTitle();
    public JTextField getAuthor();
    public JTextField getGenre();
    public JTextField getQuantity();
    public JTextField getDepositAmount();
    public JTextField getRentalCost();
    public JButton getButton();
    //setters
    public void setTitle(String title);
    public void setAuthor(String author);
    public void setGenre(String genre);
    public void setQuantity(String quantity);
    public void setDepositAmount(String depositAmount);
    public void setRentalCost(String rentalCost);
    public void setButton(JButton button);
}
