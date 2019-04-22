package controller;

import au.edu.uts.ap.javafx.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;

public class PlaceHoldController extends Controller<Catalogue> {
    
     
    
     @FXML private TextField idTf;
    @FXML private Button holdBtn;
    @FXML private Button selectBtn;
    @FXML private ListView<Book> booksLv;
    @FXML
    private Text heldText;

     
    
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
            (observable, oldBook, newBook) -> holdBtn.setDisable(newBook == null));
           
     
            
    }
    
        private Book getSelectedBook() { 
        return booksLv.getSelectionModel().getSelectedItem();     
    }
         private Patron getPatron() { 
        return patron;     
    }   
         
         private String getPatronName(){
             return patron.getName();
         }
        
        @FXML private void handleSelectPatron(ActionEvent event) throws Exception {
        int id = Integer.parseInt(idTf.getText());
        patron = model.getPatron(id);
        ObservableList<Book> book = getCatalogue().getBooksOnShelf();
        booksLv.setItems(book);
    }
    
     @FXML private void handleHold(ActionEvent event) throws Exception {
      Book selectedBook = getSelectedBook();    
      booksLv.setItems(model.getBorrowableBooks(patron)); 
          if(getSelectedBook().isHeldBy(patron) == false){
               selectedBook.addHold(getPatron());
        heldText.setText("Hold placed on " + getSelectedBook() + " for " + getPatronName());
      } else{
          heldText.setText(getPatronName() + " has already placed a hold on " + getSelectedBook());
      }
        
    }
     @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
}
