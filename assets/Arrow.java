
package assets;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Arrow extends Pane{

    double size;
    Line line = new Line(0,0,0,0);
    Polygon triangle = new Polygon(
            0,0,
            -10,10,
            10,10
    );



    public Arrow(double size) {
        super();

        line.setStartX(0);
        line.setEndX(0);
        line.setStartY(0);

        this.size = size;
        buildArrow();

    }


    public double getSize(){
        return size;
    }

    public void setSize(double size) {
        this.getChildren().clear();
        this.size = size;
        buildArrow();
    }

    private void buildArrow() {
        line.setEndY(size);

        if(size < 0){
            triangle.setRotate(180);
            triangle.relocate(-10,-10);
        }

        Shape arrow = Shape.union(line, triangle);
        this.getChildren().add(arrow);
    }

}
