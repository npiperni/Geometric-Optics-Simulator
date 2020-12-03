package view;

import assets.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import optics.OpticsCalc;

public class AnimationView extends Pane{

    private final double WIDTH = 600;
    private final double HEIGHT = 400;

    private final double MID_HORIZONTAL = WIDTH/2;
    private final double MID_VERTICAL = HEIGHT/2;


    private Point origin = new Point("O");
    private Point focalPoint = new Point("f");
    private Point focalPoint2 = new Point("f '");

    private Rectangle animationScene;

    private Line horizontalLine = new Line(0, MID_VERTICAL, WIDTH, MID_VERTICAL);

    private Lens lens = new Lens("Converging", HEIGHT);

    private Arrow obj = new Arrow(100);
    private Arrow img = new Arrow(-100);

    private Ray ray1 = new Ray();
    private Ray ray2 = new Ray();
    private Ray ray3 = new Ray();

    public AnimationView() {

        animationScene = new Rectangle(WIDTH, HEIGHT, Color.LIGHTGRAY);
        animationScene.setStroke(Color.BLACK);
        this.getChildren().add(animationScene);

        this.getChildren().add(horizontalLine);

        this.getChildren().add(lens);

        lens.relocate(MID_HORIZONTAL, 0);

        this.getChildren().add(obj);
        this.getChildren().add(img);

        obj.relocate(MID_HORIZONTAL - 100, MID_VERTICAL - 100);
        img.relocate(MID_HORIZONTAL + 100, MID_VERTICAL + 100);

        origin.relocate(MID_HORIZONTAL, MID_VERTICAL);
        this.getChildren().add(origin);

        this.getChildren().add(focalPoint);
        this.getChildren().add(focalPoint2);

        focalPoint.relocate(MID_HORIZONTAL + 50, MID_VERTICAL);
        focalPoint2.relocate(MID_HORIZONTAL - 50, MID_VERTICAL);

        this.getChildren().addAll(ray1,ray2,ray3);

        //setViewProperties(3.5*30, 2*30, (4+2/3.0)*1*30, -(2+2/3.0)*1*30, 2*30, "Converging");
    }

    public void setViewProperties(double objDistance, double objHeight, double imgDistance, double imgHeight, double focalDistance, String lensType) {
        lens.setType(lensType);

        obj.setSize(objHeight);
        obj.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);

        img.setSize(imgHeight);
        img.relocate(MID_HORIZONTAL + imgDistance, MID_VERTICAL - imgHeight);

        focalPoint.relocate(MID_HORIZONTAL + focalDistance, MID_VERTICAL);
        focalPoint2.relocate(MID_HORIZONTAL - focalDistance, MID_VERTICAL);

        ray1.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
        ray1.setNextStartingPosition(objDistance, 0);
        ray1.setLengths(objDistance, OpticsCalc.getRay1RefractedLength(), OpticsCalc.getRay1VirtualLength());
        ray1.setRotations(0, OpticsCalc.getRay1Angle());

        ray2.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
        ray2.setNextStartingPosition(objDistance, objHeight);
        ray2.setLengths(OpticsCalc.getRay2PrimaryLength(), OpticsCalc.getRay2RefractedLength(), OpticsCalc.getRay2VirtualLength());
        ray2.setRotations(OpticsCalc.getRay2Angle(), OpticsCalc.getRay2Angle());

        ray3.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
        ray3.setNextStartingPosition(objDistance, OpticsCalc.getRay3NextYPos());
        ray3.setLengths(OpticsCalc.getRay3PrimaryLength(), OpticsCalc.getRay3RefractedLength(), OpticsCalc.getRay3VirtualLength());
        ray3.setRotations(OpticsCalc.getRay3Angle(), 0);

    }

    public void startAnimation() {
        ray1.animate();
        ray2.animate();
        ray3.animate();
    }

}