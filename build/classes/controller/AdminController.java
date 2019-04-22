package controller;
import javafx.event.*;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;

public class AdminController extends Controller<Library>  {
    
    @FXML private Button addPatronBtn;
    @FXML private Button removePatronBtn;
    @FXML private Button addBookToCatBtn;
    @FXML private Button removeBookFromCatBtn;
    
    public void initialise(){
        
    }
    
   
    
      public final Library getLibrary() {
        return model;
    }    
      
     

     @FXML private void addPatron(ActionEvent event) throws Exception {
    Library library = getLibrary();
      ViewLoader.showStage(library, "/view/addPatron.fxml", "Add Patron", new Stage());
         
    }
     
     @FXML private void removePatron(ActionEvent event) throws Exception {
    //Catalogue catalogue = getCatalogue();
    
     ViewLoader.showStage(model, "/view/removePatron.fxml", "Remove Patron", new Stage());
         
    }
     
     @FXML private void addBookToCat(ActionEvent event) throws Exception {
        Catalogue catalogue = getLibrary().getCatalogue();
   
      ViewLoader.showStage(catalogue, "/view/addBook.fxml", "Add Book", new Stage());
         
    }
     
       @FXML private void removeBookFromCat(ActionEvent event) throws Exception {
    //Catalogue catalogue = getCatalogue();
    Catalogue catalogue = getLibrary().getCatalogue();
      ViewLoader.showStage(catalogue, "/view/removeBook.fxml", "Remove Book", new Stage());
         
    }
   @FXML private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }

}
