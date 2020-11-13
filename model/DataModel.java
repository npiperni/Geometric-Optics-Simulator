package model;

public class DataModel {

    private double objectDistance, objectHeight, imageDistance, imageHeight, mag, focalPoint;

    public DataModel(double objectDistance, double objectHeight, double imageDistance, double imageHeight, double mag, double focalPoint) {
        this.objectDistance = objectDistance;
        this.objectHeight = objectHeight;
        this.imageDistance = imageDistance;
        this.imageHeight = imageHeight;
        this.mag = mag;
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

    public double getImageDistance() {
        return imageDistance;
    }

    public void setImageDistance(double imageDistance) {
        this.imageDistance = imageDistance;
    }

    public double getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(double imageHeight) {
        this.imageHeight = imageHeight;
    }

    public double getMag() {
        return mag;
    }

    public void setMag(double mag) {
        this.mag = mag;
    }

    public double getFocalPoint() {
        return focalPoint;
    }

    public void setFocalPoint(double focalPoint) {
        this.focalPoint = focalPoint;
    }
}
