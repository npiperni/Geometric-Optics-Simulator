package controller;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.DataModel;
import view.SettingsView;

public class SettingsController {

    private ArrayList<DataModel> data;
    private SettingsView settingsView;

    public SettingsController(ArrayList<DataModel> d, SettingsView v) {
        data = d;
        settingsView = v;

        data = TableDataController.getTableData();

        setData();

        settingsView.setAddButtonHandler(new AddButtonHandler());
        settingsView.setDeleteButtons(new DeleteButtonHandler());
    }

    public void setData() {

        settingsView.getData().clear();
        settingsView.getData().addAll(data);

    }

    class AddButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            DataModel dataModel = new DataModel(settingsView.getObjDistanceValue(), settingsView.getObjHeightValue(),
                    settingsView.getFocalPointValue(), settingsView.getTypeOfLensValue());
            data.add(dataModel);
            setData();
            TableDataController.saveTableData(data);
        }
    }

    class DeleteButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            Button b = (Button) event.getSource();

            TableDataController.deleteEntry(data.get(Integer.parseInt(b.getId())).getObjectDistance());

            data.remove(Integer.parseInt(b.getId()));

            setData();
        }
    }

}
