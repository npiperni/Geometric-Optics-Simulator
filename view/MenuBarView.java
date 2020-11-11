package view;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import model.MenuItems;

public class MenuBarView extends BorderPane {
    MenuItems mi = new MenuItems();
    ObservableList<MenuItems> fileData = mi.getFileData();
    ObservableList<MenuItems> helpData = mi.getHelpData();
    MenuBar mb = new MenuBar();

    public MenuBarView(){
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
