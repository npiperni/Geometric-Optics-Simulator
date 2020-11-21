/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class AnimationView extends Pane{

    private final double WIDTH = 600;
    private final double HEIGHT = 400;

    //private final double MID_HORIZONTAL = WIDTH/2;
    //private final double MID_VERTICAL = HEIGHT/2;

    Rectangle animationScene;

    Line horizontalLine = new Line(0, HEIGHT/2, WIDTH, HEIGHT/2);
    Line verticalLine = new Line(WIDTH/2, 0, WIDTH/2, HEIGHT);

    Arrow obj = new Arrow(100);
    Arrow img = new Arrow(-100);

    public AnimationView() {
        animationScene = new Rectangle(WIDTH, HEIGHT, Color.LIGHTGRAY);
        animationScene.setStroke(Color.BLACK);
        this.getChildren().add(animationScene);

        this.getChildren().add(horizontalLine);

        this.getChildren().add(verticalLine);

        obj.relocate(WIDTH/2 - 40,HEIGHT/2 - obj.getSize());
        img.relocate(WIDTH/2 + 40, HEIGHT/2 - img.getSize());
        this.getChildren().add(obj);
        this.getChildren().add(img);
    }
}
