package controller;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import model.DataModel;
import view.DataSettingsView;
import view.SettingsView;

public class SettingsController {

    private ArrayList<DataModel> data;
    private DataModel selectedData;

    private SettingsView settingsView;
    private DataSettingsView dataSettingsView;

    public SettingsController(ArrayList<DataModel> d, SettingsView sv) {
        data = d;
        settingsView = sv;

        dataSettingsView = new DataSettingsView();
        settingsView.setContent(dataSettingsView);

        data = TableDataController.getTableData();

        setData();

        dataSettingsView.setAddButtonHandler(new AddButtonHandler());
        dataSettingsView.setDeleteButtons(new DeleteButtonHandler());
        dataSettingsView.setSelectButtons(new SelectButtonHandler());
    }

    public void setData() {

        dataSettingsView.getData().clear();
        dataSettingsView.getData().addAll(data);

    }

    public DataModel getSelectedData() {
        return selectedData;
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
            TableDataController.saveTableData(data);
        }
    }

    class DeleteButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            Button b = (Button) event.getSource();

            TableDataController.deleteEntry(data.get(Integer.parseInt(b.getId())).getId());

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

}
