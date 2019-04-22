package controller;

import au.edu.uts.ap.javafx.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.*;

public class BorrowController extends Controller<Catalogue>{

    @FXML private TextField idTf;
    @FXML private Button borrowBtn;
    @FXML private Button selectBtn;
    @FXML private ListView<Book> booksLv;
    
    private Patron patron;
    
    public final Catalogue getCatalogue() { return model; }
    
    public void initialize(){
        selectBtn.setDisable(true);
        idTf.textProperty().addListener((o, oldtext, newtext) -> {
        if(newtext.isEmpty()){
            selectBtn.setDisable(true);
        }else {
            selectBtn.setDisable(false);
        }});
        
        booksLv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldBook, newBook) -> borrowBtn.setDisable(newBook == null));
            
    }
    
    
      
    
     private Book getSelectedBook() { 
        return booksLv.getSelectionModel().getSelectedItem();     
    }
    
    
     @FXML private void handleSelectPatron(ActionEvent event) throws Exception {
        int id = Integer.parseInt(idTf.getText());
        patron = model.getPatron(id);
        ObservableList<Book> book = getCatalogue().getBorrowableBooks(patron);
        booksLv.setItems(book);
        
    }
     
     @FXML private void handleBorrow(ActionEvent event) throws Exception {
       Book book = getSelectedBook();
      // int id = Integer.parseInt(idTf.getText());
      // Patron patron = model.getPatron(id);
    // if(patron.hasBook(book) == false){
       model.loanBookToPatron(book, patron);
       booksLv.setItems(model.getBorrowableBooks(patron)); //passing in patrons to see what books they can borrow
     
     
     }
     
    
     @FXML private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
}
