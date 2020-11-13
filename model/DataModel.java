package model;

public class DataModel {

    private double objectDistance, objectHeight, focalPoint;

    public DataModel(double objectDistance, double objectHeight, double focalPoint) {
        this.objectDistance = objectDistance;
        this.objectHeight = objectHeight;
        this.focalPoint = focalPoint;
    }

    public double getObjectDistance() {
        return objectDistance;
    }

    public void setObjectDistance(double objectDistance) {
        this.objectDistance = objectDistance;
    }

    public double getObjectHeight() {
        return objectHeight;
    }

    public void setObjectHeight(double objectHeight) {
        this.objectHeight = objectHeight;
    }

    public double getFocalPoint() {
        return focalPoint;
    }

    public void setFocalPoint(double focalPoint) {
        this.focalPoint = focalPoint;
    }
}
