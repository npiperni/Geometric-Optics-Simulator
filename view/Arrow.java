
package view;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Arrow extends Pane{
    Line line = new Line();
    Polygon triangle = new Polygon(
    0,0,
    -10,10,
    10,10
    );



    public Arrow(double size) {
     super();

     this.line.setStartX(0);
     this.line.setEndX(0);
     this.line.setStartY(0);
     this.line.setEndY(size);


     if(size < 0){
        triangle.setRotate(180);
        triangle.relocate(-10,-10);
     }

     Shape arrow = Shape.union(line, triangle);

     this.getChildren().add(arrow);

    }


    public double getSize(){
    return this.line.getEndY();
    }
}
