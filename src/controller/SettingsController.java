package controller;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import model.DataModel;
import view.DataSettingsView;
import view.PathSettingsView;
import view.SettingsView;
import view.ThemeSettingsView;

public class SettingsController {

    private ArrayList<DataModel> data;
    private DataModel selectedData;

    private SettingsView settingsView;
    private DataSettingsView dataSettingsView;
    private ThemeSettingsView themeSettingsView;
    private PathSettingsView pathSettingsView;

    private ToggleGroup themeToggleGroup;
    private String theme;
    private String dataPath;

    public SettingsController(ArrayList<DataModel> d, SettingsView sv) {
        data = d;
        settingsView = sv;

        dataSettingsView = new DataSettingsView();
        themeSettingsView = new ThemeSettingsView();
        pathSettingsView = new PathSettingsView();
        settingsView.setContent(dataSettingsView, themeSettingsView, pathSettingsView);

        try {
            data = TableDataController.getTableData();
        } catch (SQLException e) {
            handleDataBaseException(e);
        }

        setData();

        dataSettingsView.setAddButtonHandler(new AddButtonHandler());
        dataSettingsView.setDeleteButtons(new DeleteButtonHandler());
        dataSettingsView.setSelectButtons(new SelectButtonHandler());

        pathSettingsView.setBrowseButtonHandler(new BrowseButtonHandler());
        pathSettingsView.setPathButtonHandler(new SetPathButtonHandler());

        setThemeChangeListener();
    }

    public void setData() {
        dataSettingsView.getData().clear();
        dataSettingsView.getData().addAll(data);
    }

    public DataModel getSelectedData() {
        return selectedData;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String t) {
        theme = t;
        settingsView.getStylesheets().clear();
        settingsView.getStylesheets().add(theme);
        themeSettingsView.selectCurrentTheme(theme);
    }

    private void setThemeChangeListener() {
        themeToggleGroup = themeSettingsView.getToggleGroup();
        themeToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (themeToggleGroup.getSelectedToggle() != null) {
                    theme = "themes/" + themeToggleGroup.getSelectedToggle().getUserData().toString() + ".css";
                    settingsView.getStylesheets().clear();
                    settingsView.getStylesheets().add(theme);
                }
            }
        });
    }

    public String getDataPath() {
        return dataPath;
    }

    public void setDataPath(String dataPath) {
        this.dataPath = dataPath;
        pathSettingsView.setTextFieldText(dataPath);
    }

    private void handleDataBaseException(SQLException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("DataBase Error");
        alert.setHeaderText("There was an error accessing the database");
        alert.setContentText("Are you sure the file is a database file compatible with this program?");

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);

        TextArea textArea = new TextArea(sw.toString());

        alert.getDialogPane().setExpandableContent(textArea);

        alert.showAndWait();
    }

    class AddButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            int id;
            if(data.size() == 0) {
                id = 1;
            }else {
                id = data.get(data.size() - 1).getId() + 1;
            }
            DataModel dataModel = new DataModel(dataSettingsView.getObjDistanceValue(), dataSettingsView.getObjHeightValue(),
                    dataSettingsView.getFocalPointValue(), dataSettingsView.getTypeOfLensValue(), id);
            data.add(dataModel);
            setData();
            try {
                TableDataController.saveTableData(data);
            } catch (SQLException e) {
                handleDataBaseException(e);
            }
        }
    }

    class DeleteButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            Button b = (Button) event.getSource();

            try {
                TableDataController.deleteEntry(data.get(Integer.parseInt(b.getId())).getId());
            } catch (SQLException e) {
                handleDataBaseException(e);
            }

            data.remove(Integer.parseInt(b.getId()));

            setData();
        }
    }

    class SelectButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            RadioButton b = (RadioButton) event.getSource();

            selectedData = data.get(Integer.parseInt(b.getId()));
        }
    }

    class BrowseButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Database");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("DB", "*.db"));
            Node node = (Node) event.getSource();
            File file = fileChooser.showOpenDialog(node.getScene().getWindow());
            if (file != null)
                pathSettingsView.setTextFieldText(file.getPath());
        }
    }

    class SetPathButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            String inputPath = pathSettingsView.getTextFieldText();
            File file = new File(inputPath);
            if (file.exists()) {
                if (inputPath.equals("data\\opticsTable.db")) {
                    TableDataController.setUseCustomPath(false);
                }else {
                    TableDataController.setCustomDatabasePath(inputPath);
                    TableDataController.setUseCustomPath(true);
                }
                try {
                    data = TableDataController.getTableData();
                } catch (SQLException e) {
                    handleDataBaseException(e);
                }
                dataPath = inputPath;
                setData();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Path Error");
                alert.setHeaderText(null);
                alert.setContentText("File Not Found");
                alert.showAndWait();
            }
        }
    }

}
