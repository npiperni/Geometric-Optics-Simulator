package view;

import assets.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

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

    public void setAnimationAssetProperties(double objDistance, double objHeight, double imgDistance, double imgHeight, double focalDistance, String lensType) {
        lens.setType(lensType);

        obj.setSize(objHeight);
        obj.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);

        img.setSize(imgHeight);
        img.relocate(MID_HORIZONTAL + imgDistance, MID_VERTICAL - imgHeight);

        focalPoint.relocate(MID_HORIZONTAL + focalDistance, MID_VERTICAL);
        focalPoint2.relocate(MID_HORIZONTAL - focalDistance, MID_VERTICAL);

        ray1.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
        ray2.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
        ray3.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
    }

    public void setRay1Properties(double nextStartingXPos, double primaryLength, double refractedLength, double virtualLength, double angle) {
        ray1.setNextStartingPosition(nextStartingXPos, 0);
        ray1.setLengths(primaryLength, refractedLength, virtualLength);
        ray1.setRotations(0, angle);
    }

    public void setRay2Properties(double nextStartingXPos, double nextStartingYPos, double primaryLength, double refractedLength, double virtualLength, double angle) {
        ray2.setNextStartingPosition(nextStartingXPos, nextStartingYPos);
        ray2.setLengths(primaryLength, refractedLength, virtualLength);
        ray2.setRotations(angle, angle);
    }

    public void setRay3Properties(double nextStartingXPos, double nextStartingYPos, double primaryLength, double refractedLength, double virtualLength, double angle) {
        ray3.setNextStartingPosition(nextStartingXPos, nextStartingYPos);
        ray3.setLengths(primaryLength, refractedLength, virtualLength);
        ray3.setRotations(angle, 0);
    }

    public void startAnimation() {
        ray1.animate();
        ray2.animate();
        ray3.animate();
    }

}