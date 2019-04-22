
import au.edu.uts.ap.javafx.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import javafx.stage.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.*;
import javafx.scene.image.ImageView;


import model.Library;


public class LibraryApplication extends Application {
    
    public static void main(String[] args){
        launch(args);
    }
    
       
    @Override
    public void start(Stage stage) throws Exception {

        ViewLoader.showStage(new Library(), "/view/library.fxml", "Main menu", stage);
        
       
    }

}
