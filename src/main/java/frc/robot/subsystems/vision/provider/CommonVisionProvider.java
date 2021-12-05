package frc.robot.subsystems.vision.provider;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.subsystems.vision.queryable.Queryable;
import frc.robot.subsystems.vision.queryable.QueryableTable;

//my visionprovider code implementation
public class CommonVisionProvider implements VisionProvider {

    private final NetworkTableInstance instance;
    private final double queryableDefault;

    public CommonVisionProvider(NetworkTableInstance instance, double queryableDefault) {
        this.instance = instance;
        this.queryableDefault = queryableDefault;
    }

    @Override
    public Vision initialize() {
        NetworkTable limelight = instance.getTable("limelight");
        Queryable queryable = new QueryableTable(limelight,queryableDefault);

        return new CommonVision(queryable);
    }
}
