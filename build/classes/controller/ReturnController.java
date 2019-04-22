package controller;

import au.edu.uts.ap.javafx.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import model.*;

public class ReturnController extends Controller<Catalogue> {
    
    private Patron patron;
    
     @FXML private TextField idTf;
    @FXML private Button returnBtn;
    @FXML private Button selectBtn;
    @FXML private ListView<Book> patronBooksLv;
   
    
    public final Catalogue getCatalogue() { return model; }
    
     public void initialize(){
        selectBtn.setDisable(true);
        idTf.textProperty().addListener((o, oldtext, newtext) -> {
        if(newtext.isEmpty()){
            selectBtn.setDisable(true);
        }else {
            selectBtn.setDisable(false);
        }});
            patronBooksLv.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldBook, newBook) -> returnBtn.setDisable(newBook == null));
            
    }
    
    
    
      private Book getSelectedBook() { 
        return patronBooksLv.getSelectionModel().getSelectedItem();     
    }
      
        @FXML private void handleSelectPatron(ActionEvent event) throws Exception {
        int id = Integer.parseInt(idTf.getText());
        patron = model.getPatron(id);
        ObservableList<Book> book = getCatalogue().getPatron(id).currentlyBorrowed();
        patronBooksLv.setItems(book);
        
    }
    
     @FXML private void handleReturn(ActionEvent event) throws Exception {
       Book book = getSelectedBook();
       model.returnBookFromPatron(book, patron);
      // patronBooksLv.setItems(model.getPatron(); //passing in patrons to see what books they can borrow
        
        
    }
     
  
         

    
      @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }

}
