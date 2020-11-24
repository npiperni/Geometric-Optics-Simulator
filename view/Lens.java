
package view;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Lens extends Pane{

    private double size;

    Line line;
    Polygon triangle = new Polygon(
            0,0,
            -10,10,
            10,10
    );
    Polygon invertedTriangle = new Polygon(
            0,0,
            -10,10,
            10,10
    );


    public Lens(String lensType, double size) {
        line = new Line(0, 0, 0, size);
        this.size = size;
        invertedTriangle.setRotate(180);
        setType(lensType);
    }

    public void setType(String type) {
        if(type.equals("Converging"))  {

            invertedTriangle.relocate(-10, size - 10);
            Shape upper = Shape.union(line, triangle);
            Shape finalShape = Shape.union(upper, invertedTriangle);
            this.getChildren().add(finalShape);


        }else if(type.equals("Diverging")){

            triangle.relocate(-10, size - 10);
            Shape upper = Shape.union(line, invertedTriangle);
            Shape finalShape = Shape.union(upper, triangle);
            this.getChildren().add(finalShape);

        }else{
            System.out.println("An error has occurred");
        }
    }

}
