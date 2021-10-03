package frc.robot.subsystems.BallManagement;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class BallManagementSubsystem {

    private WPI_TalonSRX ballmanagement;
    public void initialize(){
        ballmanagement = new WPI_TalonSRX(14)
    }
}
