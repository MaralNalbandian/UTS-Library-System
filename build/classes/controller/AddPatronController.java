package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

public class AddPatronController extends Controller<Library> {

    @FXML
    private TextField idTf;
    @FXML
    private TextField nameTf;
    @FXML
    private Button addPatronBtn;
    
    @FXML
    private Text addedText;

    public final Library getLibrary() {
        return model;
    }

    public final Library getPatron() {
        return model;
    }

    public final Library addPatron() {
        return model;
    }

    @FXML
    private void handleAddPatron(ActionEvent event) throws Exception {
        int ID = Integer.parseInt(idTf.getText());
        String name = nameTf.getText();
        
        if(model.getPatron(ID) == null){
            getLibrary().addPatron(ID, name);
            addedText.setText("Patron added.");
        }else{
            addedText.setText("Patron already exists!");
        }
        
                    
    }

    @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }

}
