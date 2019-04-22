package controller;

import au.edu.uts.ap.javafx.*;
import java.awt.event.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowAllBooksController extends Controller<Catalogue> {
    
    @FXML private TextField titleTf;
    @FXML private TextField authorTf;
    @FXML private TextField genreTf;
    @FXML private TableView<Book> allBooksLv;
  
    private Book book;
    //@FXML private ObservableList<Book> books = FXCollections.observableArrayList();
    
   //@FXML public final ObservableList<Book> getAllBooks() { return books; }
    
     public void initialise(){
           allBooksLv.setItems(model.getAllBooks());
    }
        
    public final Catalogue getCatalogue() { return model; }

   // public final Catalogue getAllBooks(){ return model; }
    
    @FXML private void handleShowAll(ActionEvent event) throws Exception {
       // ObservableList books = getCatalogue().getAllBooks();
        model.getAllBooks();
        allBooksLv.setItems(model.getAllBooks());
        
                
   }
    
    @FXML private void handleExit(ActionEvent event) throws Exception {
                stage.close();

          }
    
}
