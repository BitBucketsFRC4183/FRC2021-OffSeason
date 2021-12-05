package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Buttons;
import frc.robot.Constants;
import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.PS4Constants;


public class IntakeSubsystem extends BitBucketsSubsystem {

    public IntakeSubsystem(Config config, DashboardConfig dashboardConfig) {
        super(config, dashboardConfig);
        //TODO Auto-generated constructor stub
    }

    private WPI_TalonSRX intake;
    //toggleState tracks what mode the intake solenoid is running in (true == intake, false == outtake)
    public boolean toggleState;
    //declaring a double soleniod for the intake
    DoubleSolenoid intakeSolenoid;

    @Override
    public void init() {
        intake = new WPI_TalonSRX(config.INTAKE_MOTOR_ID);
        intakeSolenoid = new DoubleSolenoid(0, 1);
    }
    //intake starts (runs forward)

    @Override
    protected void addMotorsToList() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void periodic() {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void disable() {
        // TODO Auto-generated method stub
        
    }


    public void spinForward() {
        intake.set(ControlMode.PercentOutput, 0.5);
    }


    public void spinBackward() {
        intake.set(ControlMode.PercentOutput, -0.5);
    }

    public void stopSpinning() {
        intake.set(ControlMode.PercentOutput, 0);
    }

    public void toggle() {
        if (toggleState == false) {
            intakeSolenoid.set(Value.kForward);
            toggleState = true;
        }
        
        else {
            intakeSolenoid.set(Value.kReverse);
            toggleState = false; 
        }
    }

}
