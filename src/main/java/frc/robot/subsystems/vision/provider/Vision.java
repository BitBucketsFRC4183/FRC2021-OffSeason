package frc.robot.subsystems.vision.provider;

import java.util.Optional;

/**
 * Fuck convention
 */
public interface Vision {

    //i wish i had records, and i hate data transfer objects. However, this is a necessary sin so that
    //other developers who are coding in the frc style can use this object
    class Coordinates {

        //don't use the variable names "tx" and "ty", they are not descriptive
        private final double horizontalOffset;
        private final double verticalOffset;

        public Coordinates(double horizontalOffset, double verticalOffset) {
            this.horizontalOffset = horizontalOffset;
            this.verticalOffset = verticalOffset;
        }

        public double getHorizontalAngle() {
            return horizontalOffset;
        }

        public double getVerticalAngle() {
            return verticalOffset;
        }
    }

    /**
     * Gets the coordinates of any currently locked target
     * @return the coordinates of the last locked on target.
     * @throws IllegalStateException if nothing is locked onto
     */
    Coordinates getCoordinates() throws IllegalStateException;

    /**
     * Gets whether the vision provider has a target
     * @return whether it has a target or not
     */
    boolean hasValidTarget();

    /**
     * Sets the lights to on or off
     * @param enabled true if on, false if off
     */
    void setLights(boolean enabled);

}
