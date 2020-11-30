package view;

import assets.*;
import javafx.scene.control.Button;
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

        origin.relocate(MID_HORIZONTAL, MID_VERTICAL);
        this.getChildren().add(origin);

        this.getChildren().add(focalPoint);

        this.getChildren().add(focalPoint2);

        this.getChildren().addAll(ray1,ray2,ray3);

        //setViewProperties(3.5*30, 2*30, (4+2/3.0)*1*30, -(2+2/3.0)*1*30, 2*30, "Converging");
        Button tempButton = new Button("Play");
        this.getChildren().add(tempButton);
        tempButton.setOnAction(event ->
                setViewProperties(6*30, 2*30, OpticsCalc.calculateImgDistance(6,2) *30, OpticsCalc.calculateImgHeight(2,6)*30, 2*30, "Converging"));
        //setViewProperties(3.5*30, 2*30, OpticsCalc.calculateImgDistance(3.5,2) *30, OpticsCalc.calculateImgHeight(2,3.5)*30, 2*30, "Converging");
    }

    public void setViewProperties(double objDistance, double objHeight, double imgDistance, double imgHeight, double focalDistance, String lensType) {
        lens.setType(lensType);

        obj.setSize(objHeight);
        obj.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);

        img.setSize(imgHeight);
        img.relocate(MID_HORIZONTAL + imgDistance, MID_VERTICAL - imgHeight);

        focalPoint.relocate(MID_HORIZONTAL + focalDistance, MID_VERTICAL);
        focalPoint2.relocate(MID_HORIZONTAL - focalDistance, MID_VERTICAL);

        //primaryRay1.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
        //primaryRay1.setLength(objDistance);

        //refractedRay1.relocate(MID_HORIZONTAL, MID_VERTICAL - objHeight);
        //refractedRay1.setLength(Math.sqrt(Math.pow(objHeight,2) + Math.pow(focalDistance,2)));
        //refractedRay1.rotate(90 - Math.toDegrees(Math.atan(Math.abs(focalDistance) / objHeight)));
        //refractedRay1.rotate(45);

        //primaryRay1.animate();
        
        //refractedRay1.animate();
        ray1.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
        ray1.setStartingNextPosition(objDistance, 0);
        ray1.setLengths(objDistance, Math.sqrt(Math.pow(imgDistance,2) + Math.pow(Math.abs(imgHeight) + Math.abs(objHeight),2)),60);
        ray1.setRotations(0,90 - Math.toDegrees(Math.atan(Math.abs(focalDistance) / objHeight)));

        ray2.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
        ray2.setStartingNextPosition(objDistance, objHeight);
        ray2.setLengths(Math.sqrt(Math.pow(objHeight,2) + Math.pow(objDistance,2)), Math.sqrt(Math.pow(imgHeight,2) + Math.pow(imgDistance,2)),0);
        ray2.setRotations(Math.toDegrees(Math.atan(Math.abs(objHeight) / objDistance)), Math.toDegrees(Math.atan(Math.abs(objHeight) / objDistance)));

        ray3.relocate(MID_HORIZONTAL - objDistance, MID_VERTICAL - objHeight);
        ray3.setStartingNextPosition(objDistance, objHeight + Math.abs(imgHeight));
        ray3.setLengths(Math.sqrt(Math.pow(objDistance,2) + Math.pow(Math.abs(imgHeight) + Math.abs(objHeight),2)), imgDistance, 60);
        ray3.setRotations(Math.toDegrees(Math.atan((Math.abs(objHeight) + Math.abs(imgHeight)) / objDistance)), 0);

        ray1.animate();
        ray2.animate();
        ray3.animate();


    }

    private void setRays() {

    }

}