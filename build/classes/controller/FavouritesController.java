package controller;

import au.edu.uts.ap.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.*;

public class FavouritesController extends Controller<Library> {

    public final Library getLibrary() {
        return model;
    }

    @FXML
    private TextField idTf;
    @FXML
    private Button favouritesBtn;
    @FXML
    private ListView<Book> favouritesLv;
    @FXML
    private Text patronSelectedText;

    public void initialize() {
        patronSelectedText.setText("No Patron Selected");

        favouritesBtn.setDisable(true);
        idTf.textProperty().addListener((o, oldtext, newtext) -> {
            if (newtext.isEmpty()) {
                favouritesBtn.setDisable(true);
            } else {
                favouritesBtn.setDisable(false);
            }
        });

    }

    @FXML
    private void showFavourites(ActionEvent event) throws Exception {

        int ID = Integer.parseInt(idTf.getText());
        Patron patronId = model.getPatron(ID);

        if (patronId != null) {
            String patronName = patronId.getName();
            patronSelectedText.setText(patronName + "'s " + "favourite books:");
            favouritesLv.setItems(model.getPatron(ID).favourites());
        } else {
            patronSelectedText.setText("Invalid Patron ID");

        }
    }

    @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }

}
