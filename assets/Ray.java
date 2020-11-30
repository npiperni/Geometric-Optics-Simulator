package assets;

import javafx.scene.layout.Pane;

public class Ray extends Pane {

    private RaySegment primaryRay;
    private RaySegment refractedRay;
    private RaySegment virtualRay;

    public Ray() {
        primaryRay = new RaySegment();
        refractedRay = new RaySegment();
        virtualRay = new RaySegment(true);

        primaryRay.et.setOnFinished(event -> refractedRay.extend());
        refractedRay.et.setOnFinished(event -> virtualRay.extend());

        this.getChildren().addAll(primaryRay, refractedRay, virtualRay);
    }

    public void animate() {
        primaryRay.extend();
    }

    public void setStartingNextPosition(double RayXPos, double RayYPos) {
        refractedRay.relocate(RayXPos,RayYPos);
        virtualRay.relocate(RayXPos,RayYPos);
    }

    public void setLengths(double primaryRayLength, double refractedRayLength, double virtualRayLength) {

        primaryRay.resetLength();
        refractedRay.resetLength();
        virtualRay.resetLength();

        primaryRay.setExtendLength(primaryRayLength);
        refractedRay.setExtendLength(refractedRayLength);
        virtualRay.setExtendLength(virtualRayLength);

    }

    public void setRotations(double primaryRayAngle, double refractedRayAngle) {
        primaryRay.rotate(primaryRayAngle);
        refractedRay.rotate(refractedRayAngle);
        virtualRay.rotate(180 + refractedRayAngle);
    }

}
