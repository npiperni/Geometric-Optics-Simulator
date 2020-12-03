package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataModel {

    private final int ID;
    private final SimpleDoubleProperty objectDistance, objectHeight, focalPoint;
    private final SimpleStringProperty lensType;

    public DataModel(double objectDistance, double objectHeight, double focalPoint, String lensType, int id) {
        this.objectDistance = new SimpleDoubleProperty(objectDistance);
        this.objectHeight = new SimpleDoubleProperty(objectHeight);
        this.focalPoint = new SimpleDoubleProperty(focalPoint);
        this.lensType = new SimpleStringProperty(lensType);
        this.ID = id;
    }

    public double getObjectDistance() {
        return objectDistance.get();
    }

    public void setObjectDistance(double objectDistance) {
        this.objectDistance.set(objectDistance);
    }

    public double getObjectHeight() {
        return objectHeight.get();
    }

    public void setObjectHeight(double objectHeight) {
        this.objectHeight.set(objectHeight);
    }

    public double getFocalPoint() {
        return focalPoint.get();
    }

    public void setFocalPoint(double focalPoint) {
        this.focalPoint.set(focalPoint);
    }

    public String getLensType() {
        return lensType.get();
    }

    public void setLensType(String lensType) {
        this.lensType.set(lensType);
    }

    public int getId() {
        return ID;
    }

}
