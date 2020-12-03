
package assets;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Lens extends Pane{

    private double size;
    private String type;

    Line line = new Line(0, 0, 0, 0);
    Polygon uprightTriangle = new Polygon(
            0,0,
            -10,10,
            10,10
    );
    Polygon invertedTriangle = new Polygon(
            -10,0,
            10,0,
            0,10
    );


    public Lens(String lensType, double size) {
        super();

        this.size = size;
        this.type = lensType;
        buildLens();

    }

    public void setType(String type) {
        this.getChildren().clear();
        this.type = type;
        buildLens();
    }

    private void buildLens() {
        line.setEndY(size);
        Shape upper;
        Shape finalShape;
        if(type.equals("Converging"))  {
            uprightTriangle.relocate(-10,0);
            invertedTriangle.relocate(-10, size - 10);
            upper = Shape.union(line, uprightTriangle);
            finalShape = Shape.union(upper, invertedTriangle);
        }else {
            uprightTriangle.relocate(-10, size - 10);
            invertedTriangle.relocate(-10,0);
            upper = Shape.union(line, invertedTriangle);
            finalShape = Shape.union(upper, uprightTriangle);
        }
        this.getChildren().add(finalShape);
    }

}
