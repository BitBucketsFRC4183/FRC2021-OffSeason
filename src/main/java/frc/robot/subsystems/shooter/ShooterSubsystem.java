package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.DashboardKey;

public class ShooterSubsystem extends BitBucketsSubsystem
{
    private boolean isFeeding;
    private boolean isShooting;

    private WPI_TalonSRX feederMotor;
    private WPI_TalonSRX shooterMotor;

    private double shooterTargetSpeed_RPM;

    public ShooterSubsystem(Config config,DashboardConfig dbConfig)
    {
        super(config,dbConfig);
    }

    @Override
    public void init()
    {
        this.feederMotor = new WPI_TalonSRX(config.FEEDER_MOTOR_ID);
        this.shooterMotor = new WPI_TalonSRX(config.SHOOTER_MOTOR_ID);

        this.isFeeding = false;
        this.isShooting = false;

        this.shooterTargetSpeed_RPM = 0;
    }

    @Override
    protected void addMotorsToList()
    {
        this.motorList.add(this.feederMotor);
        this.motorList.add(this.shooterMotor);
    }

    @Override
    public void periodic()
    {

    }

    public void spinFeeder(float target)
    {
        int shooterVelocity = this.shooterMotor.getSelectedSensorVelocity();
        int errorMargin = 200;

        if(this.isShooting && shooterVelocity >= this.shooterTargetSpeed_RPM - errorMargin && shooterVelocity <= this.shooterTargetSpeed_RPM + errorMargin)
        {
            this.isFeeding = true;
            this.feederMotor.set(ControlMode.PercentOutput, target);
            this.setDashboardValue(DashboardKey.SHOOTER_STATE, "Shooter reached Target Speed");
            this.setDashboardValue(DashboardKey.FEEDER_STATE, "Feeder Active");
        }
        else
        {
            this.stopFeeder();
            this.setDashboardValue(DashboardKey.FEEDER_STATE, "Off: Shooter is not up to Speed");
        }
    }

    public void stopFeeder()
    {
        this.isFeeding = false;
        this.feederMotor.set(0);

        this.setDashboardValue(DashboardKey.FEEDER_STATE, "Off");
    }

    public void spinShooter(double targetRPM)
    {
        this.isShooting = true;
        this.shooterTargetSpeed_RPM = targetRPM;
        this.shooterMotor.set(ControlMode.Velocity, targetRPM);

        this.setDashboardValue(DashboardKey.SHOOTER_STATE, "Shooter Active: Spinning to " + targetRPM);
    }

    public void stopShooter()
    {
        this.isShooting = false;
        this.shooterMotor.set(0);

        this.setDashboardValue(DashboardKey.SHOOTER_STATE, "Off");

        if(this.isFeeding()) this.stopFeeder();
    }

    @Override
    public void disable()
    {
        this.stopFeeder();
        this.stopShooter();
    }

    public boolean isFeeding()
    {
        return this.isFeeding;
    }

    public boolean isShooting()
    {
        return this.isShooting;
    }
}