package frc.robot.subsystems.vision.queryable;

import edu.wpi.first.networktables.NetworkTable;

/**
 * Table implementation of queryable
 */
public class QueryableTable implements Queryable {

    private final NetworkTable table;
    private final double defaultValue;

    public QueryableTable(NetworkTable table, double defaultValue) {
        this.table = table;
        this.defaultValue = defaultValue;
    }

    @Override
    public double queryDouble(String key) {
        return table.getEntry(key).getDouble(defaultValue);
    }

    @Override
    public void insertDouble(String key, double newValue) {
        if (!table.getEntry(key).setDouble(newValue)) {
            throw new IllegalStateException("Incorrect type in table!");
        }
    }
}
