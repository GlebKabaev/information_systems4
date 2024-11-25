
package com.glb.practice.lab_4.view;
import javax.swing.*;

public class AddView implements View {
    private static AddView addView;
    private JFrame frame = new JFrame("Добавить книгу");
    private JTextField title = new JTextField("title");
    private JTextField author = new JTextField("author");
    private JTextField genre = new JTextField("genre");
    private JTextField quantity = new JTextField("quantity");
    private JTextField depositAmount = new JTextField("depositAmount");
    private JTextField rentalCost = new JTextField("rentalCost");
    private JButton button = new JButton("Добавить книгу");

    private AddView() {
        // frame
        frame.setSize(700, 700);
        frame.setLayout(null);
        // title
        title.setBounds(50, 50, 200, 30);
        frame.add(title);
        // author
        author.setBounds(50, 100, 200, 30);
        frame.add(author);
        // genre
        genre.setBounds(50, 150, 200, 30);
        frame.add(genre);
        // quantity
        quantity.setBounds(50, 200, 200, 30);
        frame.add(quantity);
        // depositAmount
        depositAmount.setBounds(50, 250, 200, 30);
        frame.add(depositAmount);
        // rentalCost
        rentalCost.setBounds(50, 300, 200, 30);
        frame.add(rentalCost);
        //addButton
        button.setBounds(260, 300, 200, 30);
        frame.add(button);
    }

    //синглтон
    public static AddView getInstance() {
        if(addView==null){
            addView= new AddView();
        }
        return addView;
    }
    public void openFrame() {
        frame.setVisible(true);
    }
    //getters
    public JFrame getFrame() {
        return frame;
    }
    public JButton getButton(){
        return button;
    }
    public JTextField getTitle() {
        return title;
    }
    public JTextField getAuthor() {
        return author;
    }
    public JTextField getGenre() {
        return genre;
    }
    public JTextField getQuantity() {
        return quantity;
    }
    public JTextField getDepositAmount() {
        return depositAmount;
    }
    public JTextField getRentalCost() {
        return rentalCost;
    }
    //setters
    public void setTitle(String title) {
        this.title.setText(title);
    }
    public void setAuthor(String author) {
        this.author.setText(author);
    }
    public void setGenre(String genre) {
        this.genre.setText(genre);
    }
    public void setQuantity(String quantity) {
        this.quantity.setText(quantity);
    }
    public void setDepositAmount(String depositAmount) {
        this.depositAmount.setText(depositAmount);
    }
    public void setRentalCost(String rentalCost) {
        this.rentalCost.setText(rentalCost);
    }
    public void setAddButton(JButton addButton) {
        this.button = addButton;
    }
    public void setButton(JButton button){
        this.button=button;
    }
}
