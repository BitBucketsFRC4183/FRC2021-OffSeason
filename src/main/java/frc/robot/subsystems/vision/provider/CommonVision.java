package frc.robot.subsystems.vision.provider;

import frc.robot.subsystems.vision.queryable.Queryable;

//TODO zoom shit
public class CommonVision implements Vision {

    private final Queryable limelightTable;

    public CommonVision(Queryable limelightTable) {
        this.limelightTable = limelightTable;
    }

    @Override
    public Coordinates getCoordinates() {

        if (!hasValidTarget()) throw new IllegalStateException("No target!");

        double x = limelightTable.queryDouble("tX");
        double y = limelightTable.queryDouble("tY");

        return new Coordinates(x, y);
    }


    @Override
    public boolean hasValidTarget() {
        return limelightTable.queryDouble("tV") == 1;
    }

    @Override
    public void setLights(boolean enabled) {
        limelightTable.insertDouble("ledMode", enabled ? 3 : 1); //de-ternary if you want to know what the code does

    }
}
