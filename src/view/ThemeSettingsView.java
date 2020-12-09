package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;


public class ThemeSettingsView extends GridPane {

    private RadioButton darkRadioButton = new RadioButton();
    private RadioButton lightRadioButton = new RadioButton();
    private RadioButton pinkRadioButton = new RadioButton();

    private Label darkLabel = new Label("Dark Mode");
    private Label lightLabel = new Label("Light Mode");
    private Label pinkLabel = new Label("Unicorn Mode");

    private final ToggleGroup group = new ToggleGroup();

    public ThemeSettingsView() {
        super();

        this.setAlignment(Pos.CENTER);
        this.setHgap(5);
        this.setVgap(10);

        darkLabel.setStyle("-fx-font-weight: bold");
        lightLabel.setStyle("-fx-font-weight: bold");
        pinkLabel.setStyle("-fx-font-weight: bold");

        darkRadioButton.setToggleGroup(group);
        darkRadioButton.setUserData("dark");

        lightRadioButton.setToggleGroup(group);
        lightRadioButton.setUserData("light");

        pinkRadioButton.setToggleGroup(group);
        pinkRadioButton.setUserData("pink");

        this.add(darkLabel, 0, 0);
        this.add(darkRadioButton, 1, 0);


        this.add(lightLabel, 0, 1);
        this.add(lightRadioButton, 1, 1);

        this.add(pinkLabel, 0, 2);
        this.add(pinkRadioButton, 1, 2);

    }

    public ToggleGroup getToggleGroup() {
        return group;
    }

    public void selectCurrentTheme(String theme) {
        // This might not be the best way to do this but I need something that works
        if (theme.equals("themes/light.css"))
            lightRadioButton.setSelected(true);
        else if (theme.equals("themes/dark.css"))
            darkRadioButton.setSelected(true);
        else if (theme.equals("themes/pink.css"))
            pinkRadioButton.setSelected(true);
    }

}
