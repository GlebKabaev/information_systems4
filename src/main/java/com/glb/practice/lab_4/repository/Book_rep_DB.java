package com.glb.practice.lab_4.repository;
import java.sql.*;
import java.util.*;

import com.glb.practice.lab_4.model.Book;
import com.glb.practice.lab_4.model.ShortBook;

import java.io.*;


public class Book_rep_DB implements Repository{
    private static Book_rep_DB instance;
    private final String url = "jdbc:postgresql://localhost:5432/Library_DB";
    private final String user = "myuser";
    private final String password = "mypassword";
    private Book_rep_DB() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //получить объект класса
    public static Book_rep_DB getInstance() {
        if (instance == null) {
            instance = new Book_rep_DB();
        }
        return instance;
    }
    
    // Получить объект по ID
    public Book getBookById(int id){
        String query = "SELECT * FROM Books WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("quantity"),
                        rs.getDouble("depositAmount"),
                        rs.getDouble("rentalCost")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ShortBook getShortBookById(int id){
        String query = "SELECT * FROM Books WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ShortBook(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre")
                        
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addBook(Book book) {
        String query = "INSERT INTO Books (title, author, genre, quantity, depositAmount, rentalCost) VALUES (?, ?, ?, ?, ?, ?)"; // SQL-запрос для добавления книги
        try (Connection conn = DriverManager.getConnection(url, user, password); // Создаем соединение с базой данных
             PreparedStatement stmt = conn.prepareStatement(query)) { // Создаем подготовленный запрос

            // Устанавливаем значения параметров запроса
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getGenre());
            stmt.setInt(4, book.getQuantity());
            stmt.setDouble(5, book.getDepositAmount());
            stmt.setDouble(6, book.getRentalCost());

            stmt.executeUpdate(); // Выполняем запрос, добавляя запись в базу данных
        } catch (SQLException e) {
            // Обработка исключений, связанных с SQL
            e.printStackTrace();
        }
    }
    // Заменить существующую книгу по её ID
    public void updateBookById(int id, Book book) {
        String query = "UPDATE Books SET title = ?, author = ?, genre = ?, quantity = ?, depositAmount = ?, rentalCost = ? WHERE id = ?"; // SQL-запрос для обновления книги
        try (Connection conn = DriverManager.getConnection(url, user, password); // Создаем соединение с базой данных
             PreparedStatement stmt = conn.prepareStatement(query)) { // Создаем подготовленный запрос

            // Устанавливаем значения параметров запроса
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getGenre());
            stmt.setInt(4, book.getQuantity());
            stmt.setDouble(5, book.getDepositAmount());
            stmt.setDouble(6, book.getRentalCost());
            stmt.setInt(7, id); // Устанавливаем ID для идентификации книги

            stmt.executeUpdate(); // Выполняем запрос для обновления записи
        } catch (SQLException e) {
            // Обработка исключений, связанных с SQL
            e.printStackTrace();
        }
    }
    public void deleteBookById(int id) {
        String query = "DELETE FROM Books WHERE id = ?"; // SQL-запрос для удаления книги
        try (Connection conn = DriverManager.getConnection(url, user, password); // Создаем соединение с базой данных
             PreparedStatement stmt = conn.prepareStatement(query)) { // Создаем подготовленный запрос

            stmt.setInt(1, id); // Устанавливаем ID для идентификации книги
            stmt.executeUpdate(); // Выполняем запрос для удаления записи
        } catch (SQLException e) {
            // Обработка исключений, связанных с SQL
            e.printStackTrace();
        }
    }
    public int getCount() {
        String query = "SELECT COUNT(*) FROM Books"; // SQL-запрос для получения количества книг
        try (Connection conn = DriverManager.getConnection(url, user, password); // Создаем соединение с базой данных
             Statement stmt = conn.createStatement(); // Создаем объект Statement для выполнения запроса
             ResultSet rs = stmt.executeQuery(query)) { // Выполняем запрос и получаем результат

            if (rs.next()) { // Если результат не пустой
                return rs.getInt(1); // Возвращаем количество книг
            }
        } catch (SQLException e) {
            // Обработка исключений, связанных с SQL
            e.printStackTrace();
        }
        return 0; // Если произошла ошибка, возвращаем 0
    }
    public List<ShortBook> get_k_n_shortList(int k, int n) throws IOException {
        String query = "SELECT id, title, author, genre FROM Books ORDER BY id LIMIT ? OFFSET ?";
        List<ShortBook> shortBooks = new ArrayList<>();
    
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, n); // Лимит на количество записей
            stmt.setInt(2, k * n); // Сдвиг для выборки
    
            ResultSet rs = stmt.executeQuery();
    
            while (rs.next()) {
                shortBooks.add(new ShortBook(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return shortBooks;
    }
    
}
