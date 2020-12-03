package transition;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class ExtendLineTransition extends Transition {

    private double toX;
    private double toY;
    private double fromX;
    private double fromY;
    private Line line;

    public ExtendLineTransition(Duration duration, Line line) {
        this.line = line;
        setCycleDuration(duration);
        this.setInterpolator(Interpolator.LINEAR);
        // Set some initial values
        fromX = 1;
        fromY = 1;
        toX = 1;
        toY = 1;
    }

    public ExtendLineTransition(Duration duration) {
        this(duration, null);
    }

    public ExtendLineTransition() {
        //Default Duration
        this(Duration.seconds(5));
    }

    @Override
    protected void interpolate(double frac) {
        double x = fromX + frac * (toX - fromX);
        double y = fromY + frac * (toY - fromY);
        line.setEndX(x);
        line.setEndY(y);
    }

    public double getToX() {
        return toX;
    }

    public void setToX(double toX) {
        this.toX = toX;
    }

    public double getToY() {
        return toY;
    }

    public void setToY(double toY) {
        this.toY = toY;
    }

    public double getFromX() {
        return fromX;
    }

    public void setFromX(double fromX) {
        this.fromX = fromX;
    }

    public double getFromY() {
        return fromY;
    }

    public void setFromY(double fromY) {
        this.fromY = fromY;
    }

}
