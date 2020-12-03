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
import model.DataModel;
import model.MenuItems;
import optics.Optics;
import optics.OpticsCalc;
import view.MainView;
import view.DataSettingsView;
import view.SettingsView;

import java.util.ArrayList;

public class MainController {
	private MenuItems mi;
	private MainView mbv;

	public MainController(MenuItems m, MainView mb) {
		this.mi = m;
		this.mbv = mb;

		PlayEventHandler peh = new PlayEventHandler();
		mb.setPlayHandler(peh);

		SettingsEventHandler seh = new SettingsEventHandler();
		mbv.setSettingsHandler(seh);

		AboutEventHandler aeh = new AboutEventHandler();
		mbv.setAboutHandler(aeh);

		CloseEventHandler cc = new CloseEventHandler();
		mbv.setCloseHandler(cc);
	}

	private void calculateData(DataModel data) {
		double objDistance = data.getObjectDistance();
		double objHeight = data.getObjectHeight();
		String lensType = data.getLensType();
		double focalLength = lensType.equals("Converging") ? data.getFocalPoint() : -data.getFocalPoint();
		double imgDistance = OpticsCalc.calculateImgDistance(objDistance, focalLength);
		double imgHeight = OpticsCalc.calculateImgHeight(objHeight, objDistance);
		double mag = OpticsCalc.calculateMag(objHeight, objDistance);
		String imgType = (imgDistance >= 0) ? "Real" : "Virtual";

		OpticsCalc.calculateRay1RefractedLength(imgDistance, imgHeight, objHeight, lensType, imgType);
		OpticsCalc.calculateRay1VirtualLength(imgDistance, imgHeight, objHeight, lensType, imgType);
		OpticsCalc.calculateRay2PrimaryLength(objDistance, objHeight);
		OpticsCalc.calculateRay2RefractedLength(imgDistance, imgHeight, lensType, imgType);
		OpticsCalc.calculateRay2VirtualLength(imgDistance, imgHeight, lensType, imgType);
		OpticsCalc.calculateRay3PrimaryLength(imgHeight, objDistance, objHeight, lensType, imgType);
		OpticsCalc.calculateRay3RefractedLength(imgDistance, lensType, imgType);
		OpticsCalc.calculateRay3VirtualLength(imgDistance, lensType, imgType);

		OpticsCalc.calculateRay1Angle(objHeight, focalLength, lensType);
		OpticsCalc.calculateRay2Angle(objHeight, objDistance);
		OpticsCalc.calculateRay3Angle(objHeight, objDistance, imgHeight, lensType, imgType);

		OpticsCalc.calculateRay3NextYStartPos(objHeight, imgHeight, lensType, imgType);

		mbv.setData(objDistance, objHeight, lensType, focalLength, imgDistance, imgHeight, mag, imgType);

	}

	class PlayEventHandler implements EventHandler {
		@Override
		public void handle(Event event) {
			mbv.startAnimation();
		}
	}

	class SettingsEventHandler implements EventHandler {
		@Override
		public void handle(Event event) {
			SettingsView sv = new SettingsView();
			SettingsController sc = new SettingsController(new ArrayList<>(), sv);
			Stage stage = new Stage();

			Scene scene = new Scene(sv, 550, 500);

			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Optics.getS());

			stage.setTitle("Geometric Optics - Settings");
			sv.getStylesheets().add("style.css");

			stage.setScene(scene);
			stage.setResizable(false);
			stage.showAndWait();

			if(sc.getSelectedData() != null)
				calculateData(sc.getSelectedData());

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
			stage.initOwner(Optics.getS());

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