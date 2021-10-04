package frc.robot.subsystems.vision.queryable;

/**
 * Hide implementation details and access to things we don't give a shit about
 */
public interface Queryable {

    /**
     * Queries the queryable for a value
     * @param key the key
     * @return the value
     */
    double queryDouble(String key);

    /**
     * Inserts a value into a queryable
     * @param key the key
     * @param newValue new value
     * @throws IllegalStateException when the keyed value is present but not of correct type
     * @return ??? (to fix)
     */
    void insertDouble(String key, double newValue);

}
