package au.edu.uts.ap.javafx;
import javafx.event.ActionEvent;

import javafx.stage.*;

public abstract class Controller<M> {
    protected M model;
    protected Stage stage;
}
