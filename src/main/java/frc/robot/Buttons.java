package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.utils.PS4Constants;

public class Buttons {

    Joystick driverControl = new Joystick(0);
    Joystick operatorControl = new Joystick(1);
    JoystickButton driveAutoAim = new JoystickButton(driverControl, PS4Constants.CIRCLE.getId());

    //SpinnyBoi Subsystem
    JoystickButton operatorSpinForward = new JoystickButton(operatorControl, PS4Constants.TRIANGLE.getId());
    JoystickButton operatorSpinBackward = new JoystickButton(operatorControl, PS4Constants.CROSS.getId());

    //Climber Subsystem
    int climbLeftAmnt = PS4Constants.LEFT_STICK_Y.getId();
    int climbRightAmnt = PS4Constants.RIGHT_STICK_Y.getId();

    //Shooter Subsystem

    JoystickButton operatorAimBot = new JoystickButton(operatorControl, PS4Constants.R2.getId());
    JoystickButton operatorSpinUp = new JoystickButton(operatorControl, PS4Constants.L1.getId());
    JoystickButton operatorFeeder = new JoystickButton(operatorControl, PS4Constants.L2.getId());
    JoystickButton operatorSpinBMS = new JoystickButton(operatorControl, PS4Constants.CIRCLE.getId());
    JoystickButton operatorZero = new JoystickButton(operatorControl, PS4Constants.SQUARE.getId());

    int operatorAzimuth = PS4Constants.RIGHT_STICK_X.getId();
    int operatorElevation = PS4Constants.RIGHT_STICK_Y.getId();

    POVButton operatorNextElevation = new POVButton(operatorControl, 90); // right
    POVButton operatorLastElevation = new POVButton(operatorControl, 270); // left

    //intake and outtake subsystems
    POVButton operatorIntakeIn = new POVButton(operatorControl, 0); 
    POVButton operatorIntakeOut = new POVButton(operatorControl, 180);
    JoystickButton operatorToggleIntake = new JoystickButton(operatorControl, PS4Constants.R1.getId());

    JoystickButton setElevationToDashboardNum = new JoystickButton(operatorControl, PS4Constants.OPTIONS.getId());
    public int driveSpeedAxis = PS4Constants.LEFT_STICK_Y.getId();
    public int driveTurnAxis = PS4Constants.RIGHT_STICK_X.getId();
    JoystickButton operatorClimbActivated = new JoystickButton(operatorControl, PS4Constants.PS4.getId());
    JoystickButton driverClimbActivated = new JoystickButton(driverControl, PS4Constants.PS4.getId());
}
