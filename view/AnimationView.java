package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class AnimationView extends Pane{

    private final double WIDTH = 600;
    private final double HEIGHT = 400;

    private final double MID_HORIZONTAL = WIDTH/2;
    private final double MID_VERTICAL = HEIGHT/2;


    Point origin = new Point("O");
    Point focalPoint = new Point("f");
    Point focalPoint2 = new Point("f '");

    Rectangle animationScene;

    Line horizontalLine = new Line(0, MID_VERTICAL, WIDTH, MID_VERTICAL);
    Lens lens = new Lens("Converging", HEIGHT);

    Arrow obj = new Arrow(100);
    Arrow img = new Arrow(-100);

    public AnimationView() {

        animationScene = new Rectangle(WIDTH, HEIGHT, Color.LIGHTGRAY);
        animationScene.setStroke(Color.BLACK);
        this.getChildren().add(animationScene);

        this.getChildren().add(horizontalLine);

        this.getChildren().add(lens);

        lens.relocate(MID_HORIZONTAL, 0);

        this.getChildren().add(obj);
        this.getChildren().add(img);

        origin.relocate(MID_HORIZONTAL, MID_VERTICAL);
        this.getChildren().add(origin);

        this.getChildren().add(focalPoint);

        this.getChildren().add(focalPoint2);

        setViewProperties(80, 100, 80, -100, 50, "Converging");
    }

    public void setViewProperties(double objDistance, double objHeight, double imgDistance, double imgHeight, double focalDistance, String lensType) {
        lens.setType(lensType);

        obj.setSize(objHeight);
        obj.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);

        img.setSize(imgHeight);
        img.relocate(MID_HORIZONTAL + imgDistance, MID_VERTICAL - imgHeight);

        focalPoint.relocate(MID_HORIZONTAL + focalDistance, MID_VERTICAL);
        focalPoint2.relocate(MID_HORIZONTAL - focalDistance, MID_VERTICAL);

    }

}