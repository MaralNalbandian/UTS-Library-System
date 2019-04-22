package controller;


import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.*;
import model.*;

public class AddBookController extends Controller<Catalogue> {

     @FXML
    private TextField addBookTf;
     
    @FXML
    private TextField addAuthorTf;
     
    @FXML
    private TextField addGenreTf;
    
    @FXML
    private Button addBookBtn;
    
    @FXML
    private Text addedText;
     
    public void initialize() {
        
    }
       
    public final Catalogue getCatalogue() { return model; }
     
    
   @FXML private void handleAddBook(ActionEvent event) throws Exception {
        String title = addBookTf.getText();
        String author = addAuthorTf.getText();
        String genre = addGenreTf.getText();
        
           if(model.hasBook(title, author) == false){
             getCatalogue().addBook(title, author, genre);
            addedText.setText("Book added to Catalogue.");
        }else{
            addedText.setText("That book is already in the Catalogue.");
        }
        
                    
    
       
        
      
    } 
   
    @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
}

