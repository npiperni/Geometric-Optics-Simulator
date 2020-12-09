package view;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class PathSettingsView extends GridPane {

    private Label label = new Label("PATH: ");

    private TextField path = new TextField("data\\opticsTable.db");

    private Button browse = new Button("Browse");
    private Button setPath = new Button("Set Path");

    public PathSettingsView() {
        super();

        path.setPrefWidth(300);

        this.setAlignment(Pos.CENTER);
        this.setHgap(5);
        this.setVgap(20);

        label.setStyle("-fx-font-weight: bold");

        this.add(label, 0, 0);
        this.add(path,1,0);
        this.add(browse, 2,0);

        this.add(setPath, 2, 1);
    }

    public void setTextFieldText(String path) {
        this.path.setText(path);
    }

    public String getTextFieldText() {
        return path.getText();
    }

    public void setBrowseButtonHandler(EventHandler handler) {
        browse.setOnAction(handler);
    }

    public void setPathButtonHandler(EventHandler handler) {
        setPath.setOnAction(handler);
    }

}
