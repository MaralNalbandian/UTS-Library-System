package controller;

import au.edu.uts.ap.javafx.*;
import model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


public class CatalogueController extends Controller<Catalogue> {

    @FXML
    private Button showAllBtn;
    @FXML
    private Button showAvailableBtn;
    @FXML
    private Button showByGenreBtn;
    @FXML
    private Button showByAuthorBtn;
    @FXML
    private Button borrowBooksBtn;
    @FXML
    private Button returnBooksBtn;
    @FXML
    private Button placeHoldBtn;
    @FXML
    private Button closeBtn;
    
    
    
    public final Catalogue getCatalogue(){ return model; }
    
    public final Catalogue getBooks() { return model; }
    
    public final Catalogue getGenre() { return model; }
    
       
    
@FXML
    private void showAllBooks(ActionEvent event) throws Exception {
     ObservableList books = getCatalogue().getAllBooks();
     getCatalogue().getAllBooks();
        ViewLoader.showStage(model, "/view/showAllBooks.fxml", "Complete Catalogue", new Stage());

    }
  
    @FXML
    private void showAvailableBooks(ActionEvent event) throws Exception {
      ObservableList books = getCatalogue().getBooksOnShelf();
        ViewLoader.showStage(model, "/view/showAvailableBooks.fxml", "Available Books", new Stage());

    }
    
     @FXML
    private void showByGenre(ActionEvent event) throws Exception {
      //ObservableList books = getCatalogue().getBooksInGenre(genre);
      ViewLoader.showStage(model, "/view/showBooksByGenre.fxml", "Browse By Genre", new Stage());

    }
      @FXML
    private void showByAuthor(ActionEvent event) throws Exception {
      //ObservableList books = getCatalogue().getBooksByAuthor(author);
       ViewLoader.showStage(model, "/view/showBooksByAuthor.fxml", "Browse by Author", new Stage());

    }
      @FXML
    private void borrowBooks(ActionEvent event) throws Exception {
     //ObservableList books = getCatalogue().loanBookToPatron(book, patron);
       ViewLoader.showStage(model, "/view/borrow.fxml", "Borrow a Book", new Stage());

    }
    
      @FXML
    private void returnBooks(ActionEvent event) throws Exception {
     //ObservableList books = getCatalogue().getAllBooks();
        ViewLoader.showStage(model, "/view/return.fxml", "Return a Book", new Stage());

    }
    
      @FXML
    private void placeHold(ActionEvent event) throws Exception {
    // ObservableList books = getCatalogue();
      ViewLoader.showStage(model, "/view/placeHold.fxml", "Place a Hold", new Stage());

    }
    
     @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
    
}
