package frc.robot.subsystems.drive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;

public class DriveSubsystem extends BitBucketsSubsystem{
    
    public DriveSubsystem(Config config, DashboardConfig dashboardConfig) {
        super(config, dashboardConfig);
        //TODO Auto-generated constructor stub
    }
    private WPI_TalonSRX leftDriveLeader;
    private WPI_TalonSRX rightDriveLeader;
    private WPI_TalonSRX rightDriveFollower;
    private WPI_TalonSRX leftDriveFollower;
    private DifferentialDrive differentialDrive;
    @Override
    public void init() {
        rightDriveLeader = new WPI_TalonSRX(config.RIGHT_DRIVE_LEADER_ID);
        leftDriveLeader = new WPI_TalonSRX(config.LEFT_DRIVE_LEADER_ID);
        rightDriveFollower = new WPI_TalonSRX(config.RIGHT_DRIVE_FOLLOWER_ID);
        leftDriveFollower = new WPI_TalonSRX(config.LEFT_DRIVE_FOLLOWER_ID);

        //rightDriveLeader.setInverted(true);
        
        rightDriveFollower.follow(rightDriveLeader);
        leftDriveFollower.follow(leftDriveLeader);

        //DifferentialDrive m_drive = new DifferentialDrive(leftDriveLeader, rightDriveLeader);
    }

    public void prevent(double leftStick, double rightStick){
        leftStick = Math.abs(leftStick);
        rightStick = Math.abs(rightStick);
    }
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
    double slowdown = 0.5;
    public void drive(double speed, double turn) {

        leftDriveLeader.set(ControlMode.PercentOutput, (speed + turn) * slowdown);
        rightDriveLeader.set(ControlMode.PercentOutput, (speed - turn) * -1 * slowdown);
    }
    

    
}
