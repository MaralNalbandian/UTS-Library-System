package controller;

import au.edu.uts.ap.javafx.Controller;

import javafx.fxml.FXML;
import model.*;
import javafx.fxml.FXML;;
import javafx.event.ActionEvent;
import javafx.scene.control.TableView;



public class ShowAvailableBooksController extends Controller<Catalogue>  {
    
      
    
@FXML private TableView<Book> availableBooksLv;

   public final Catalogue getCatalogue() { return model; }

    
    public void initialise(){
           availableBooksLv.setItems(model.getBooksOnShelf());
    }
        
  @FXML private void handleShowAvailable(ActionEvent event) throws Exception {
       // ObservableList books = getCatalogue().getAllBooks();
        model.getBooksOnShelf();
        availableBooksLv.setItems(model.getBooksOnShelf());
        
                
   }
    
    
    
     @FXML private void handleExit(ActionEvent event) throws Exception {
                stage.close();

          }
    
}

