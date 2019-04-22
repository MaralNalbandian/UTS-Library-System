package controller;

import au.edu.uts.ap.javafx.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import model.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;

public class RecordController extends Controller<Library> {

    @FXML
    private TextField IDTf;
    @FXML
    private Button recordBtn;
    @FXML
    private ListView<Book> currentlyBorrowedRecordLv;
    @FXML
    private ListView<Book> borrowingHistoryLv;

    @FXML
    private Text patronSelectedText;

    public final Library getLibrary() {
        return model;
    }

    private Patron patron;

    private String getPatronName() {
        return patron.getName();
    }

    private Integer getPatronId() {
        return patron.getId();
    }

    public void initialize() {
        patronSelectedText.setText("No Patron Selected");

        recordBtn.setDisable(true);
        IDTf.textProperty().addListener((o, oldtext, newtext) -> {
            if (newtext.isEmpty()) {
                recordBtn.setDisable(true);

            } else {
                recordBtn.setDisable(false);

            }
        });

    }

    @FXML
    private void handleRecord(ActionEvent event) throws Exception {

        int ID = Integer.parseInt(IDTf.getText());
        //String name = patron.getName();
        Patron patron = model.getPatron(ID);
        //Book book = model.getCatalogue().getAllBooks();
        //Book title = ;
        
        
if(patron != null){
        patronSelectedText.setText(" " + patron + " " + " ");
        currentlyBorrowedRecordLv.setItems(model.getPatron(ID).currentlyBorrowed());
        borrowingHistoryLv.setItems(model.getPatron(ID).borrowingHistory().sorted());
}else{
     patronSelectedText.setText("Invalid Patron ID");
}

      

    }

    @FXML
    private void handleExit(ActionEvent event) throws Exception {
        stage.close();
    }
}
