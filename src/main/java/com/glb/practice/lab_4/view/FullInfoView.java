package com.glb.practice.lab_4.view;
import javax.swing.*;
public class FullInfoView {
    private static FullInfoView fullInfoView;
    private JFrame frame=new JFrame();
    private JLabel id = new JLabel();
    private JLabel title = new JLabel();
    private JLabel author = new JLabel();
    private JLabel genre = new JLabel();
    private JLabel quantity = new JLabel();
    private JLabel depositAmount = new JLabel();
    private JLabel rentalCost = new JLabel();
    //Constructor
    private FullInfoView() {
        //frame
        frame.setSize(700, 700);
        frame.setLayout(null);
        // labels
        id.setBounds(50, 50, 200, 30);
        frame.add(id);
        title.setBounds(50, 100, 200, 30);
        frame.add(title);
        author.setBounds(50, 150, 200, 30);
        frame.add(author);
        genre.setBounds(50, 200, 200, 30);
        frame.add(genre);
        quantity.setBounds(50, 250, 200, 30);
        frame.add(quantity);
        depositAmount.setBounds(50, 300, 200, 30);
        frame.add(depositAmount);
        rentalCost.setBounds(50, 350, 200, 30);
        frame.add(rentalCost);
    }
    public  void openFrame() {
        frame.setVisible(true);
    }
    public static FullInfoView getInstance() {
        if(fullInfoView==null) {
            fullInfoView = new FullInfoView();
        }
        return fullInfoView;
    }
    //getters
    public JLabel getId() {
        return id;
    }
    public JLabel getTitle() {
        return title;
    }
    public JLabel getAuthor() {
        return author;
    }
    public JLabel getGenre(){
        return genre;
    }
    public JLabel getQuantity() {
        return quantity;
    }
    public JLabel getDepositAmount() {
        return depositAmount;
    }
    public JLabel getRentalCost() {
        return rentalCost;
    }
    //setters
    public void setId(String id) {
        this.id.setText(id);
    }
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

}
