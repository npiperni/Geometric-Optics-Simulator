package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import model.DataModel;

public class SettingsView extends Pane {

    private TableView<DataModel> tv = new TableView<>();

    private TextField addObjDistance = new TextField();
    private TextField addObjHeight = new TextField();
    private TextField addFocalPoint = new TextField();
    private ComboBox<String> addTypeOfLens = new ComboBox<>();
    private Button addButton = new Button("ADD");

    ObservableList<DataModel> list = FXCollections.observableArrayList();

    private TableColumn firstCol = new TableColumn("Object Distance");
    private TableColumn secondCol = new TableColumn("Object Height");
    private TableColumn thirdCol = new TableColumn("Focal Point");
    private TableColumn fourthCol = new TableColumn("Type of Lens");
    private TableColumn deleteCol = new TableColumn();

    public SettingsView(){
        super();

        this.getChildren().add(tv);
        setUpTable();

        addObjDistance.setPromptText("Object Distance");
        addObjDistance.relocate(0, 400);
        this.getChildren().add(addObjDistance);

        addObjHeight.setPromptText("Object Height");
        addObjHeight.relocate(150, 400);
        this.getChildren().add(addObjHeight);

        addFocalPoint.setPromptText("Focal Point");
        addFocalPoint.relocate(0, 430);
        this.getChildren().add(addFocalPoint);

        addTypeOfLens.setPromptText("Type of Lens");
        addTypeOfLens.getItems().addAll("Converging", "Diverging");
        addTypeOfLens.relocate(150, 430);
        this.getChildren().add(addTypeOfLens);

        addButton.relocate(260, 430);
        this.getChildren().add(addButton);

    }

    public void setUpTable(){
        firstCol.setMinWidth(100);
        firstCol.setCellValueFactory(new PropertyValueFactory<DataModel, Double>("objectDistance"));

        secondCol.setMinWidth(100);
        secondCol.setCellValueFactory(new PropertyValueFactory<DataModel, Double>("objectHeight"));

        thirdCol.setMinWidth(100);
        thirdCol.setCellValueFactory(new PropertyValueFactory<DataModel, Double>("focalPoint"));

        firstCol.setMinWidth(100);
        fourthCol.setCellValueFactory(new PropertyValueFactory<DataModel, String>("lensType"));

        deleteCol.setMinWidth(100);

        tv.setItems(list);
        tv.getColumns().addAll(firstCol, secondCol, thirdCol, fourthCol, deleteCol);
    }

    public ObservableList<DataModel> getData() {
        return list;
    }

    public double getObjDistanceValue() {
        double value = Double.parseDouble(addObjDistance.getText());
        addObjDistance.clear();
        return value;
    }

    public double getObjHeightValue() {
        double value = Double.parseDouble(addObjHeight.getText());
        addObjHeight.clear();
        return value;
    }

    public double getFocalPointValue() {
        double value = Double.parseDouble(addFocalPoint.getText());
        addFocalPoint.clear();
        return value;
    }

    public String getTypeOfLensValue() {
        String value = addTypeOfLens.getValue();
        // I tried to restore the ComboBox to the prompt text but it didn't work
        //addTypeOfLens.getSelectionModel().clearSelection();
        return value;
    }

    public void setAddButtonHandler(EventHandler handler) {
        addButton.setOnAction(handler);
    }

    public void setDeleteButtons(EventHandler handler) {
        Callback<TableColumn<DataModel, String>, TableCell<DataModel, String>> cellFactoryBT = new Callback<TableColumn<DataModel, String>, TableCell<DataModel, String>>() {
            @Override
            public TableCell call(final TableColumn<DataModel, String> param) {
                final TableCell<DataModel, String> cell = new TableCell<DataModel, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        Button btn = new Button("DELETE");
                        btn.setPrefWidth(100);

                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setId(String.valueOf(getIndex()));
                            setGraphic(btn);
                            setText(null);
                            btn.setOnAction(handler);
                        }
                    }

                };
                return cell;
            }
        };
        deleteCol.setCellFactory(cellFactoryBT);
    }

}
