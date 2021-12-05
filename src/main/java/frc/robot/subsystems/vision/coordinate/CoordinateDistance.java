package frc.robot.subsystems.vision.coordinate;

import frc.robot.subsystems.vision.provider.Vision;

public class CoordinateDistance implements Distance {

    private final Vision.Coordinates coordinates;
    private final double targetHeight;
    private final double cameraHeight;
    private final double cameraAngle;

    public CoordinateDistance(Vision.Coordinates coordinates, double targetHeight, double cameraHeight, double cameraAngle) {
        this.coordinates = coordinates;
        this.targetHeight = targetHeight;
        this.cameraHeight = cameraHeight;
        this.cameraAngle = cameraAngle;
    }

    //default constructor. up to user to decide whether they want to use some configuration library to provide targetHeight.. etc or just use constants
    public CoordinateDistance(Vision.Coordinates coordinates) {
        this.coordinates = coordinates;
        //taken from VisionConstants. Preferable to use a conf library + verbose constructor.
        this.targetHeight = 89.75; //i wonder if there is a way to calculate this from robot input alone e.g. based on angle & distance
        this.cameraHeight = 22.6;
        this.cameraAngle = 30;
    }

    @Override
    public double distance() {
        //haha! stole your math!

        return (targetHeight - cameraHeight) / Math.tan(Math.toRadians(cameraAngle + coordinates.getVerticalAngle()));
    }
}
