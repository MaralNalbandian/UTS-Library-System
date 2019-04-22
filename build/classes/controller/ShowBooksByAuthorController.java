package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.*;

public class ShowBooksByAuthorController extends Controller<Catalogue> {

    @FXML
    private ListView<Author> authorLv;
    @FXML
    private ListView<Book> booksByAuthorLv;
    
    private Author author;

    public final Catalogue getCatalogue() {
        return model;
    }

    @FXML
    public void initialize() {
        authorLv.setItems(model.getAuthors());
    }
    
     private Author getSelectedAuthor() { 
        return authorLv.getSelectionModel().getSelectedItem();     
    }
    
    //private Author getSelectedAuthor() { return booksByAuthorLv.getSelectionModel().getSelectedItems(); }

    @FXML
    private void showBooksByAuthor(ActionEvent event) throws Exception {

        //Author author = authorLv.getSelectionModel().getSelectedItem();
       // booksByAuthorLv.setItems(model.getBooksByAuthor(author));
       
       author = getSelectedAuthor();
    }
    
    @FXML
    private void handleDisplay(ActionEvent event) throws Exception {
              author = getSelectedAuthor(); 
              booksByAuthorLv.setItems(model.getBooksByAuthor(author));

        
    }
    

    @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }

}
