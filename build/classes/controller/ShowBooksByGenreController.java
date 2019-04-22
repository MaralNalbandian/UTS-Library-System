package controller;

import au.edu.uts.ap.javafx.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.*;

public class ShowBooksByGenreController extends Controller<Catalogue> {
    
    @FXML private ListView<Genre> genreLv;
    @FXML private ListView<Book> booksInGenreLv;
    
    @FXML private Button displayBtn;
    
    private Genre genre;
    
    
    
    public final Catalogue getCatalogue(){
        return model; }
    
    @FXML public void initialize(){
        genreLv.setItems(model.getGenres());
    }
    
      private Genre getSelectedGenre() { 
        return genreLv.getSelectionModel().getSelectedItem();     
    }
    
      @FXML
    private void showBooksByGenre(ActionEvent event) throws Exception {
    
      //Genre genre = genreLv.getSelectionModel().getSelectedItem();
     // booksInGenreLv.setItems(model.getBooksInGenre(genre));
     genre = getSelectedGenre();
    }
    
      @FXML
    private void handleDisplay(ActionEvent event) throws Exception {
               genre = getSelectedGenre(); 
              booksInGenreLv.setItems(model.getBooksInGenre(genre));

        
    }
    
      @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }

}
