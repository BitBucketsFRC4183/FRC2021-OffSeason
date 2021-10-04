package frc.robot;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.vision.coordinate.CoordinateDistance;
import frc.robot.subsystems.vision.provider.CommonVisionProvider;
import frc.robot.subsystems.vision.provider.Vision;


public class Robot extends TimedRobot {

    @Override
    public void robotInit() {

        NetworkTableInstance commonInstance = NetworkTableInstance.getDefault(); //in case anyone else requires networktables access
        commonInstance.startClientTeam(4183);

        Vision vision = new CommonVisionProvider(commonInstance, 0.0).initialize();
        //do something with the vision """"subsystem"""" (if you need it dependency inject it into your subsystem)

        if (vision.hasValidTarget()) {
            System.out.println("target acquired - arming salvo");
        }

        vision.getCoordinatesInstant().ifPresent(coords -> {

            System.out.println(coords.getHorizontalOffset());

            double toTarget = new CoordinateDistance(coords).distance();

            System.out.println(toTarget);
        });


    }

    @Override
    public void robotPeriodic() {
        // always run the CommandScheduler during periodic
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    public static Robot win() {
        return new Robot();
    }

}