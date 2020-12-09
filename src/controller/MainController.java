package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.DataModel;
import model.MenuItems;
import optics.Optics;
import optics.OpticsCalc;
import view.AboutView;
import view.MainView;
import view.SettingsView;

import java.util.ArrayList;

public class MainController {

	private MenuItems mi;
	private MainView mbv;

	private String theme = "themes/dark.css";
	private String dataPath = "data\\opticsTable.db";

	public MainController(MenuItems m, MainView mb) {
		this.mi = m;
		this.mbv = mb;

		mbv.getStylesheets().add(theme);

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
		double imgHeight = OpticsCalc.calculateImgHeight(objHeight, objDistance, imgDistance);
		double mag = OpticsCalc.calculateMag(imgHeight, objHeight);
		String imgType = (imgDistance >= 0) ? "Real" : "Virtual";

		mbv.setData(objDistance, objHeight, lensType, focalLength, imgDistance, imgHeight, mag, imgType);

		double ray1RefractedLength = OpticsCalc.calculateRay1RefractedLength(imgDistance, imgHeight, objHeight, lensType, imgType);
		double ray1VirtualLength = OpticsCalc.calculateRay1VirtualLength(imgDistance, imgHeight, objHeight, lensType, imgType);
		double ray1Angle = OpticsCalc.calculateRay1Angle(objHeight, focalLength, lensType);

		mbv.setRay1(objDistance, objDistance, ray1RefractedLength, ray1VirtualLength, ray1Angle);

		double ray2PrimaryLength = OpticsCalc.calculateRay2PrimaryLength(objDistance, objHeight);
		double ray2RefractedLength = OpticsCalc.calculateRay2RefractedLength(imgDistance, imgHeight, lensType, imgType);
		double ray2VirtualLength = OpticsCalc.calculateRay2VirtualLength(imgDistance, imgHeight, lensType, imgType);
		double ray2Angle = OpticsCalc.calculateRay2Angle(objHeight, objDistance);

		mbv.setRay2(objDistance, objHeight, ray2PrimaryLength, ray2RefractedLength, ray2VirtualLength, ray2Angle);

		double ray3NextStartYPos = OpticsCalc.calculateRay3NextYStartPos(objHeight, imgHeight, lensType, imgType);
		double ray3PrimaryLength = OpticsCalc.calculateRay3PrimaryLength(imgHeight, objDistance, objHeight, lensType, imgType);
		double ray3RefractedLength = OpticsCalc.calculateRay3RefractedLength(imgDistance, lensType, imgType);
		double ray3VirtualLength = OpticsCalc.calculateRay3VirtualLength(imgDistance, lensType, imgType);
		double ray3Angle = OpticsCalc.calculateRay3Angle(objHeight, objDistance, imgHeight, lensType, imgType);

		mbv.setRay3(objDistance, ray3NextStartYPos, ray3PrimaryLength, ray3RefractedLength, ray3VirtualLength, ray3Angle);

	}

	private void setTheme(String t) {
		theme = t;
		mbv.getStylesheets().clear();
		mbv.getStylesheets().add(theme);
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
			sc.setTheme(theme);
			sc.setDataPath(dataPath);

			stage.setScene(scene);
			stage.setResizable(false);
			stage.showAndWait();

			dataPath = sc.getDataPath();

			setTheme(sc.getTheme());

			if(sc.getSelectedData() != null)
				calculateData(sc.getSelectedData());

		}
	}

	class AboutEventHandler implements EventHandler {
		@Override
		public void handle(Event event) {
			AboutView av = new AboutView();
			Stage stage = new Stage();

			ScrollPane scrollPane = new ScrollPane();

			scrollPane.setContent(av);

			Scene scene = new Scene(scrollPane, 910, 500);

			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(Optics.getS());

			stage.setTitle("About");
			scrollPane.getStylesheets().add(theme);

			stage.setScene(scene);
			stage.setResizable(false);
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