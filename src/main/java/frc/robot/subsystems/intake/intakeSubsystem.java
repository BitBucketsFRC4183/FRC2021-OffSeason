package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.utils.PS4Constants;

public class intakeSubsystem {

    private static final String operatorControl = null;
    private WPI_TalonSRX intake;
    public void initialize() {
        intake = new WPI_TalonSRX(1);
        
    }
    
    POVButton operatorIntake = new POVButton(operatorControl, 180); // down
    POVButton operatorOutake = new POVButton(operatorControl, 0); // up
    JoystickButton operatorToggleIntake = new JoystickButton(operatorControl, PS4Constants.R1.getId());

}
