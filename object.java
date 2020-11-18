/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.*;

/**
 *
 * @author admin
 */
public class object {
    private  SimpleDoubleProperty objectDistance, objectHeight, focalPoint, imageDistance, imageHeight;
    private  SimpleStringProperty lensType;

    public SimpleDoubleProperty getObjectDistance() {
        return objectDistance;
    }

    public void setObjectDistance(SimpleDoubleProperty objectDistance) {
        this.objectDistance = objectDistance;
    }

    public SimpleDoubleProperty getObjectHeight() {
        return objectHeight;
    }

    public void setObjectHeight(SimpleDoubleProperty objectHeight) {
        this.objectHeight = objectHeight;
    }

    public SimpleDoubleProperty getFocalPoint() {
        return focalPoint;
    }

    public void setFocalPoint(SimpleDoubleProperty focalPoint) {
        this.focalPoint = focalPoint;
    }

    public SimpleDoubleProperty getImageDistance() {
        return imageDistance;
    }

    public void setImageDistance(SimpleDoubleProperty imageDistance) {
        this.imageDistance = imageDistance;
    }

    public SimpleDoubleProperty getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(SimpleDoubleProperty imageHeight) {
        this.imageHeight = imageHeight;
    }

    public SimpleStringProperty getLensType() {
        return lensType;
    }

    public void setLensType(SimpleStringProperty lensType) {
        this.lensType = lensType;
    }

  
}
