package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.MenuItems;
import optics.Main;
import view.MainView;
import view.SettingsView;

import java.util.ArrayList;

public class MainController {
	MenuItems mi;
	MainView mbv;

	public MainController(MenuItems m, MainView mb) {
		this.mi = m;
		this.mbv = mb;

		SettingsEventHandler seh = new SettingsEventHandler();
		mbv.setSettingsHandler(seh);

		AboutEventHandler aeh = new AboutEventHandler();
		mbv.setAboutHandler(aeh);

		CloseEventHandler cc = new CloseEventHandler();
		mbv.setCloseHandler(cc);
	}

	class SettingsEventHandler implements EventHandler {
		@Override
		public void handle(Event event) {
			SettingsView sv = new SettingsView();
			SettingsController sc = new SettingsController(new ArrayList<>(), sv);
			Stage stage = new Stage();

			Scene scene = new Scene(sv, 500, 500);

			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.getS());

			stage.setTitle("Geometric Optics - Settings");
			sv.getStylesheets().add("style.css");

			stage.setScene(scene);
			stage.showAndWait();
		}
	}

	class AboutEventHandler implements EventHandler {
		@Override
		public void handle(Event event) {
			Pane root = new Pane();
			Stage stage = new Stage();

			VBox vb = new VBox();
			Text t = new Text("ABOUT");
			t.setFill(Color.WHITE);

			vb.getChildren().add(t);

			root.getChildren().add(vb);

			Scene scene = new Scene(root, 400, 300);

			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Main.getS());

			stage.setTitle("About");
			root.getStylesheets().add("style.css");

			stage.setScene(scene);
			stage.showAndWait();
		}
	}

	class CloseEventHandler implements EventHandler {
		@Override
		public void handle(Event event) {
			System.exit(0);
		}
	}
}