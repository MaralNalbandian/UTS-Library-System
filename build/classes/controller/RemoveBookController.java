package controller;

import au.edu.uts.ap.javafx.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class RemoveBookController extends Controller<Catalogue> {
    
    @FXML private Button removeBtn;
    
    @FXML private ListView<Book> booksLv;
    
 
    
  public final Catalogue getCatalogue() { return model; }
  
   public void initialize(){
     //  booksLv.setItems(model.getBooksOnShelf());
    }
 
  
   private Book getSelectedBook() { 
        return booksLv.getSelectionModel().getSelectedItem();     
    }
     
    
      @FXML
    private void handleRemoveBook(ActionEvent event) throws Exception {
      Book book = getSelectedBook();
             

     //ObservableList<Book> book = model.getBooksOnShelf();
        if(book != null){
            model.removeBook(book);
            
                        
       }
        booksLv.setItems(model.getBooksOnShelf());        
   
    }
    
      @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }

}
