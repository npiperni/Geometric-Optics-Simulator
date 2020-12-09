package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MenuItems {
    private String itemName;
    private static ObservableList<MenuItems> fileData =
            FXCollections.observableArrayList(
                new MenuItems("Play"),
                new MenuItems("Settings")
            );
    private static ObservableList<MenuItems> helpData =
            FXCollections.observableArrayList(
                    new MenuItems("About"),
                    new MenuItems("Close")
            );

    public MenuItems(){

    }

    public MenuItems(String itemName){
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ObservableList<MenuItems> getFileData() {
        return fileData;
    }

    public void setFileData(ObservableList<MenuItems> fileData) {
        this.fileData = fileData;
    }

    public ObservableList<MenuItems> getHelpData() {
        return helpData;
    }

    public void setHelpData(ObservableList<MenuItems> helpData) {
        this.helpData = helpData;
    }

    @Override
    public String toString() {
        return "MenuItems{" +
                "itemName='" + itemName + '\'' +
                '}';
    }
}
