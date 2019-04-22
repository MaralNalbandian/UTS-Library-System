package controller;

import au.edu.uts.ap.javafx.*;
import java.awt.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import model.*;

public class RemovePatronController extends Controller<Library> {
    
    @FXML private TextField idTf;
    
    @FXML private ListView<Patron> patronsLv;

   public final Library getLibrary(){
        return model; }
    
 
    
    @FXML public void initialize(){
       //patronsLv.setItems(model.getPatrons());
    }
    
    //private Patron getSelectedPatron() {
        //return patronsLv.getSelectionModel().getSelectedItem();
    //}
    
    private Patron getSelectedPatron() { 
        return patronsLv.getSelectionModel().getSelectedItem();     
    }
    
     @FXML
    private void handleRemovePatron(ActionEvent event) throws Exception {
        Patron patron = getSelectedPatron();
        if(patron != null){
            model.removePatron(patron);
        }
        
        
        
      //ObservableList<Patron> patron = patronsLv.getSelectionModel().getSelectedItems();

     //if(patron != null)
         
       //removePatron(patron);
              
        }
    
      @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
}
