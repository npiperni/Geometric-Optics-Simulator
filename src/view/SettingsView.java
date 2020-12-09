package view;

import javafx.scene.Node;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class SettingsView extends Pane {

    private TabPane tp;
    private Tab tab1;
    private Tab tab2;
    private Tab tab3;

    public SettingsView(){
        super();

        tp = new TabPane();

        tp.setTabMinWidth(100);
        tp.setTabMaxWidth(100);


        tab1 = new Tab("Data Input");
        tab2 = new Tab("Theme");
        tab3 = new Tab("Import Data");

        tp.getTabs().addAll(tab1, tab2, tab3);

        tp.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        VBox vb = new VBox();
        vb.setMaxWidth(Double.MAX_VALUE);

        this.getChildren().add(tp);
    }

    public void setContent(Node dataSettingsView, Node themeSettingsView, Node pathSettingsView) {
        tab1.setContent(dataSettingsView);
        tab2.setContent(themeSettingsView);
        tab3.setContent(pathSettingsView);
    }
}