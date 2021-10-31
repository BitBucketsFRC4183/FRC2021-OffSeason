package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.BitBucketsSubsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.climber.ClimberSubsystem;
import frc.robot.utils.PS4Constants;

import java.util.ArrayList;
import java.util.List;


public class Robot extends TimedRobot {

    public static final List<BitBucketsSubsystem> robotSubsystems = new ArrayList<>();
    private final Buttons buttons = new Buttons();

    private ClimberSubsystem climberSubsystem;
    
    @Override
    public void robotInit() {


        climberSubsystem = new ClimberSubsystem();
        climberSubsystem.initialize();
        
        //Initialize all subsystems (do this AFTER subsystem objects are created and instantiated)
        robotSubsystems.forEach(BitBucketsSubsystem::init);
        
        climberSubsystem.setDefaultCommand(new RunCommand(
        () -> climberSubsystem.moveArms(
            buttons.operatorControl.getRawAxis(buttons.climbLeftAmnt),
            buttons.operatorControl.getRawAxis(buttons.climbRightAmnt)),climberSubsystem)
        );

    }

    @Override
    public void robotPeriodic() {

        //Run periodic function on all subsystems each time robotPeriodic is called
        robotSubsystems.forEach(BitBucketsSubsystem::periodic);

        CommandScheduler.getInstance().run();
        climberSubsystem.updateDashboard();
    }

    @Override
    public void teleopInit() {

    }

    public static Robot win() {
        return new Robot();
    }

}