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
    private MenuItems mi = new MenuItems();
    private ObservableList<MenuItems> fileData = mi.getFileData();
    private ObservableList<MenuItems> helpData = mi.getHelpData();
    private MenuBar mb = new MenuBar();

    private AnimationView animationView;

    private Label objectDistance, objectHeight, imageHeight, imageDistance, focalLength, mag, typeOfLens, typeOfImage;


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

        objectDistance = new Label("Object Distance: ");
        objectDistance.setFont(Font.font(24));
        objectDistance.setTextFill(Color.WHITE);

        objectHeight = new Label("Object Height: ");
        objectHeight.setFont(Font.font(24));
        objectHeight.setTextFill(Color.WHITE);

        imageDistance = new Label("Image Distance: ");
        imageDistance.setFont(Font.font(24));
        imageDistance.setTextFill(Color.WHITE);

        imageHeight = new Label("Image Height: ");
        imageHeight.setFont(Font.font(24));
        imageHeight.setTextFill(Color.WHITE);

        focalLength = new Label("Focal Length: ");
        focalLength.setFont(Font.font(24));
        focalLength.setTextFill(Color.WHITE);

        mag = new Label("Magnification: ");
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

        animationView = new AnimationView();
        animationView.relocate(20,30);

        Pane mainScreen = new Pane();
        mainScreen.getChildren().addAll(animationView,vb);

        this.setCenter(mainScreen);
    }

    public void setData(double objDistance, double objHeight, String lensType, double focalLength, double imgDistance, double imgHeight, double mag, String imgType) {
        this.objectDistance.setText("Object Distance: " + String.format("%.2f", objDistance));
        this.objectHeight.setText("Object Height: " + String.format("%.2f", objHeight));
        this.imageDistance.setText("Image Distance: " + String.format("%.2f", imgDistance));
        this.imageHeight.setText("Image Height: " + String.format("%.2f", imgHeight));
        this.focalLength.setText("Focal Length: " + String.format("%.2f", focalLength));
        this.mag.setText("Magnification : " + String.format("%.2f", mag));
        this.typeOfLens.setText("Type of Lens: " + lensType);
        this.typeOfImage.setText("Type of Image: " + imgType);

        animationView.setViewProperties(objDistance, objHeight, imgDistance, imgHeight, focalLength, lensType);
    }

    public void startAnimation() {
        animationView.startAnimation();
    }

    public void setPlayHandler(EventHandler handler) {
        mb.getMenus().get(0).getItems().get(0).setOnAction(handler);
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
