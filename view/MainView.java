package view;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.MenuItems;

public class MainView extends BorderPane {
    MenuItems mi = new MenuItems();
    ObservableList<MenuItems> fileData = mi.getFileData();
    ObservableList<MenuItems> helpData = mi.getHelpData();
    MenuBar mb = new MenuBar();

    private Label objectDistance, objectHeight, imageHeight, imageDistance, focalLength, mag, typeOfLens, typeOfImage;

    // This is just a placeholder


    public MainView(){
        super();

        Menu fileMenu = new Menu("_File");
        for(MenuItems m: fileData){
            fileMenu.getItems().add(new MenuItem(m.getItemName()));
        }

        Menu helpMenu = new Menu("_Help");
        for(MenuItems m: helpData){
            helpMenu.getItems().add(new MenuItem(m.getItemName()));
        }
        helpMenu.getItems().add(1, new SeparatorMenuItem());

        mb.getStylesheets().add("style.css");

        mb.getMenus().addAll(fileMenu, helpMenu);

        this.setTop(mb);

        objectDistance = new Label("DO: ");
        objectDistance.setFont(Font.font(24));
        objectDistance.setTextFill(Color.WHITE);

        objectHeight = new Label("HO: ");
        objectHeight.setFont(Font.font(24));
        objectHeight.setTextFill(Color.WHITE);

        imageDistance = new Label("DI: ");
        imageDistance.setFont(Font.font(24));
        imageDistance.setTextFill(Color.WHITE);

        imageHeight = new Label("HI: ");
        imageHeight.setFont(Font.font(24));
        imageHeight.setTextFill(Color.WHITE);

        focalLength = new Label("f: ");
        focalLength.setFont(Font.font(24));
        focalLength.setTextFill(Color.WHITE);

        mag = new Label("M: ");
        mag.setFont(Font.font(24));
        mag.setTextFill(Color.WHITE);

        typeOfLens = new Label("Type of Lens: ");
        typeOfLens.setFont(Font.font(24));
        typeOfLens.setTextFill(Color.WHITE);

        typeOfImage = new Label("Type of Image: ");
        typeOfImage.setFont(Font.font(24));
        typeOfImage.setTextFill(Color.WHITE);


        VBox vb = new VBox();
        vb.getChildren().addAll(objectDistance, objectHeight, imageDistance, imageHeight, focalLength, mag, typeOfLens, typeOfImage);

        vb.relocate(650, 60);

        AnimationView animationView = new AnimationView();
        animationView.relocate(20,30);

        Pane mainScreen = new Pane();
        mainScreen.getChildren().addAll(animationView,vb);

        this.setCenter(mainScreen);
    }

    public void setSettingsHandler(EventHandler handler){
        mb.getMenus().get(0).getItems().get(1).setOnAction(handler);
    }

    public void setAboutHandler(EventHandler handler){
        mb.getMenus().get(1).getItems().get(0).setOnAction(handler);
    }

    public void setCloseHandler(EventHandler handler){
        mb.getMenus().get(1).getItems().get(2).setOnAction(handler);
    }
}
