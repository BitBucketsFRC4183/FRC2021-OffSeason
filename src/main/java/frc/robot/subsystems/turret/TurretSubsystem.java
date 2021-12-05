package frc.robot.subsystems.turret;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.config.Config;
import frc.robot.config.MotorConfig;
import frc.robot.config.Config.TurretConfig;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.MathUtils;
import frc.robot.utils.MotorUtils;

public class TurretSubsystem extends BitBucketsSubsystem {
    
    public TurretSubsystem(Config config, DashboardConfig dashboardConfig) {
        super(config, dashboardConfig);
        //TODO Auto-generated constructor stub
    }

    //Class lacks dashboard updates as of right now
    private WPI_TalonSRX elevation;
    private WPI_TalonSRX azimuth;
    private int positionSlot = 0;

    //PID
    private double kP = 0.14014/4;
    private double kI = 0.005;
    private double kD = 10 * 0.14014/4; //10 * kP
    private double kF = 1023.9 / 17300;
    private double azimuthGearRatio = config.turretConfig.AZIMUTH_GEAR_RATIO;
    private double elevationGearRatio = config.turretConfig.ELEVATION_GEAR_RATIO;
    private double ticksPerRevolution = config.turretConfig.TICKS_PER_REVOLUTION;

    public void init() {
        elevation = new WPI_TalonSRX(config.ELEVATION_MOTOR_ID);

        elevation.config_kF(positionSlot, kF);
        elevation.config_kP(positionSlot, kP);
        elevation.config_kI(positionSlot, kI);
        elevation.config_kD(positionSlot, kD);

        azimuth = new WPI_TalonSRX(config.AZIMUTH_MOTOR_ID);

        azimuth.config_kF(positionSlot, kF);
        azimuth.config_kP(positionSlot, kP);
        azimuth.config_kI(positionSlot, kI);
        azimuth.config_kD(positionSlot, kF);
    }

 
    public void setAzimuth(double degrees) {
         double position = degrees / 360.0 / azimuthGearRatio * ticksPerRevolution;
         position = MathUtils.clamp(position, config.turretConfig.AZIMUTH_CLAMP_MIN_ticks, config.turretConfig.AZIMUTH_CLAMP_MAX_ticks);
         azimuth.set(ControlMode.Position, position);
    }

    public void setElevation(double degrees) {
        double position = degrees / 360.0 / elevationGearRatio * ticksPerRevolution;
        position = MathUtils.clamp(position, config.turretConfig.ELEVATION_CLAMP_MIN_ticks, config.turretConfig.ELEVATION_CLAMP_MAX_ticks); 
        elevation.set(ControlMode.Position, position);
    }

    public double elevationConvert(double distance) {
        double exampleReturn = 45;
        return exampleReturn;
    }

    public WPI_TalonSRX getElevation() {
        return elevation;
    }
    
    public WPI_TalonSRX getAzimuth() {
        return azimuth;
    }

    @Override
    protected void addMotorsToList() {
        this.motorList.add(elevation);
        this.motorList.add(azimuth);
    }

    @Override
    public void periodic() {
        
    }

    @Override
    public void disable() {
        stopAzimuth();
        stopElevation();
    }
    
    public void stopAzimuth() {
        azimuth.set(0);
    }

    public void stopElevation() {
        elevation.set(0);
    }
}
