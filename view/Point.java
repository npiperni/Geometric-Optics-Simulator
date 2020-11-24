package view;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class Point extends Pane {

    private Circle circle;
    private Label label;

    public Point(String text) {
        circle = new Circle(5);
        this.getChildren().add(circle);

        label = new Label(text);
        label.relocate(-15,-15);
        label.setFont(Font.font("Serif", FontPosture.ITALIC, Font.getDefault().getSize()));
        this.getChildren().add(label);
    }

}
