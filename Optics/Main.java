package Optics;

import controller.MenuBarController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.MenuItems;
import view.MenuBarView;

public class Main extends Application {
    private static Stage s;

    @Override
    public void start(Stage stage) throws Exception{
        MenuBarView mbt = new MenuBarView();
        MenuItems mi = new MenuItems();
        MenuBarController mbc = new MenuBarController(mi, mbt);

        BorderPane bp = new BorderPane(mbt);

        s = stage;

        bp.getStylesheets().add("style.css");

        stage.setTitle("Menu Bar Test");
        Scene scene = new Scene(bp, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getS() {
        return s;
    }

    public static void setS(Stage s) {
        Main.s = s;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
