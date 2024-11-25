package com.glb.practice.lab_4.view;
import java.util.List;

import javax.swing.*;
// import com.glb.practice.lab_4.controller.Observer;
public class MainView  {
    private static MainView mainView;
    private JFrame frame = new JFrame("Главное окно");
    private JLabel label = new JLabel("Welcome");
    private JList<String> jlist=new JList<>() ;
    private JButton button=new JButton("Show full book info");
    private JButton getButton = new JButton("Обновить"); 
    private JButton addButton = new JButton("Добавить книгу");
    private JButton updateButton =new JButton("Изменить книгу");
    private JButton deleteButton = new JButton("Удалить книгу");
    private JButton next =new JButton(">");
    private JButton back =new JButton("<");
    private JLabel numPage = new JLabel("1");
    private JTextField minField = new JTextField();
    private JTextField maxField = new JTextField();
    private String[] sortOptions = {"id", "title", "author", "genre", "quantity", "depositAmount", "rentalCost"};
    private JComboBox<String> sortComboBox = new JComboBox<>(sortOptions);
    
    
    // public void update(ArrayList<String> newInfo) {
    //     jlist=new JList<>(newInfo.toArray(new String[0]));
    // }
    private MainView() {
        // frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.setLayout(null);
        //lable
        label.setBounds(50, 150, 200, 30);
        frame.add(label); 
        // textField
        ;
        // button
        button.setBounds(50, 80, 200, 30); 
        frame.add(button);
        // getButton
        getButton.setBounds(260, 80, 200, 30);
        frame.add(getButton); 
        //addButton
        addButton.setBounds(470, 80, 200, 30);
        frame.add(addButton);
        //updateButton
        updateButton.setBounds(50, 120, 200, 30);
        frame.add(updateButton);
        //deleteButton
        deleteButton.setBounds(260,120,200,30);
        frame.add(deleteButton);
        //jlist
        jlist.setBounds(50,180, 520, 520);
        frame.add(jlist); 
        //backButton
        back.setBounds(200+70, 700, 50, 30);
        frame.add(back);
        //nextButton
        next.setBounds(200+170, 700, 50, 30);
        frame.add(next);
        //numPage
        numPage.setBounds(200+140, 700, 40, 40);
        frame.add(numPage);
        //combobox
        sortComboBox.setBounds(470, 120, 120, 30);
        frame.add(sortComboBox);
        //minField
        minField.setBounds(610, 120,70,30);
        frame.add(minField);
        //maxField
        maxField.setBounds(690, 120,70,30);
        frame.add(maxField);
    }
    public void openFrame() {
        frame.setVisible(true);
    }
    //синглтон 
    public static MainView getInstance() {
        if(mainView == null){
            mainView = new MainView();
        }
        return mainView;
    }
    //getters
    public JFrame getFrame() {
        return frame;
    }
    public JLabel getLabel() {
        return label;
    }
    public JList<String> getJlist() {
        return jlist;
    }
    
    public JButton getButton() {
        return button;
    }
    public JButton getGetButton() {
        return getButton;
    }
    public JButton getAddButton() {
        return addButton;
    }
    public JButton getUpdateButton() {
        return updateButton;
    }
    public JButton getDeleteButton() {
        return deleteButton;
    }
    public JButton getNext() {
        return next;
    }
    public JButton getBack() {
        return back;
    }
    public JLabel getNumPage(){
        return numPage;
    }
    public JComboBox<String> getSortComboBox() {
        return sortComboBox;
    }
    public JTextField getMinField() {
        return minField;
    }
    public JTextField getMaxField() {
        return maxField;
    }
    //setters
    public void setLabel(String text) {
        label.setText(text);
    }
    public void setJlist(List<String> newInfo) {
        jlist.setListData(newInfo.toArray(new String[0]));
    }
    
    public void setButton(JButton newButton) {
        button = newButton;
    }
    public void setGetButton(JButton newGetButton) {
        getButton = newGetButton;
    }
    public void setAddButton(JButton newAddButton) {
        addButton = newAddButton;
    }
    public void setupdateButton(JButton newUpdateButton){
        updateButton = newUpdateButton;
    }
    public void setNext(JButton newNext){
        next = newNext;
    }
    public void setBack(JButton newBack){
        back = newBack;
    }
    public void setNumPage(int numPage){
        this.numPage.setText(String.valueOf(numPage));
    }
    public void setDeleteButton(JButton newDeleteButton){
        deleteButton = newDeleteButton;
    }
    public void setCombobox(JComboBox<String> newCombobox){
        sortComboBox = newCombobox;
    }
    public void setMinField(JTextField minField){
        this.minField = minField;
    }
    public void setMaxField(JTextField maxField){
        this.maxField = maxField;
    }
    
    
}
