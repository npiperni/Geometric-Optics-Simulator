package assets;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import transition.ExtendLineTransition;

public class RaySegment extends Pane {

    private Rotate r = new Rotate(0, 0, 0);

    private Line line;

    private double extendLength;

    ExtendLineTransition et;

    public RaySegment(double length, boolean isVirtual) {
        line = new Line(0, 0, 0, 0);
        line.setStrokeWidth(1.5);
        line.setStroke(Color.RED);
        this.extendLength = length;

        if (isVirtual)
            line.getStrokeDashArray().addAll(5d);

        line.getTransforms().add(r);
        this.getChildren().add(line);

        et = new ExtendLineTransition(Duration.seconds(5), line);
    }

    public RaySegment(boolean isVirtual) {
        this(0, isVirtual);
    }

    public RaySegment() {
        this(false);
    }

    public RaySegment(double length) {
        this(length, false);
    }

    public void setExtendLength(double length) {
        this.extendLength = length;
    }

    public void resetLength() {
        line.setEndX(0);
    }

    public void extend() {
        et.setFromX(0);
        et.setToX(extendLength);
        et.play();
    }

    public void rotate(double angle) {
        r.setAngle(angle);
    }

}
