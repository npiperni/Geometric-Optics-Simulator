
package assets;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Arrow extends Pane{

    private double size;
    private Line line = new Line(0,0,0,0);
    private Polygon uprightTriangle = new Polygon(
            0,0,
            -10,10,
            10,10
            );
    private Polygon invertedTriangle = new Polygon(
            -10,-10,
            10,-10,
            0,0
    );



    public Arrow(double size) {
        super();

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
        Shape arrow;
        if(size > 0){
            arrow = Shape.union(line, uprightTriangle);
        }else {
            arrow = Shape.union(line, invertedTriangle);
        }
        this.getChildren().add(arrow);
    }

}
