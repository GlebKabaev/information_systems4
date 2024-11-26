package com.glb.practice.lab_4.model;
import java.util.ArrayList;
import java.util.List;
// import com.glb.practice.lab_4.controller.MainViewController;
import com.glb.practice.lab_4.repository.*;
public class BookModel implements Observable{
    private static BookModel bm;
    private Book_rep_DB db= Book_rep_DB.getInstance();
    private Repository edb=ExtendRep.getInstance(db);
    public static BookModel getInstance(){
        if(bm==null){
            bm=new BookModel();
        }
        return bm;
    }
    private BookModel(){
        // MainViewController mvc=MainViewController.getInstance();
        // addObserver(mvc);
    }

    public  void addBook(Book book){
        db.addBook(book);
        
        notifyObservers();
    }
    public void updateBookById(int id,Book book){
        db.updateBookById(id, book);
        notifyObservers();
    }
    public void deleteBookById(int id){
        db.deleteBookById(id);
        notifyObservers();
    }
    public int getCount(){
        return db.getCount();
    }
    public Book getBookById(int id){
        return db.getBookById(id);
    }
    public ShortBook getShortBookById(int id){
        return db.getShortBookById(id);
    }
    public List<ShortBook> get_k_n_shortList(int k, int n){
        try {
            return db.get_k_n_shortList(k, n);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<ShortBook>();
    }
    public List<ShortBook> sort_get_k_n_shortList(int k, int n, String sort, int min, int max){
        if (edb instanceof SortableRepository sortableRepository) {
            try {
                return sortableRepository.sort_get_k_n_shortList(k, n, sort, min, max);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<ShortBook>();
    }
}
