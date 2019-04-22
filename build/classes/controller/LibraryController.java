package controller;

import javafx.event.*;
import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import au.edu.uts.ap.javafx.*;
import javafx.application.Platform;
import model.*;

public class LibraryController extends Controller<Library> {

    @FXML
    private Button closeBtn;
    @FXML
    private Button adminBtn;
    @FXML
    private Button catalogueBtn;

    public void initialize() {
    }

    public final Library getLibrary() {
        return model;
    }

   

    @FXML
    private void exploreCatalogue(ActionEvent event) throws Exception {
        Catalogue catalogue = getLibrary().getCatalogue();
        ViewLoader.showStage(model.getCatalogue(), "/view/catalogue.fxml", "Catalogue", new Stage());

    }

    @FXML
    private void viewPatron(ActionEvent event) throws Exception {
         ViewLoader.showStage(model, "/view/record.fxml", "Patron Record", new Stage());

    }

    @FXML
    private void viewFavourites(ActionEvent event) throws Exception {
        ViewLoader.showStage(model, "/view/favourites.fxml", "Favourites", new Stage());

    }

    @FXML
    private void handleAdmin(ActionEvent event) throws Exception {
        //Library library = getLibrary();
        ViewLoader.showStage(model, "/view/admin.fxml", "Administration Menu", new Stage());
    }

    @FXML
    private void handleExit(ActionEvent event) throws Exception {
        System.exit(0);
    }

}
