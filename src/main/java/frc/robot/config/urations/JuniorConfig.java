package frc.robot.config.urations;

import frc.robot.config.Config;

public class JuniorConfig extends Config {

  //////////////////////////////////////////////////////////////////////////////
  // Subsystem Enablers
  public boolean enableBallManagementSubsytem = false;
  public boolean enableClimberSubsytem = false;
  public boolean enableDriveSubsytem = true;
  public boolean enableIntakeSubsytem = false;
  public boolean enableShooterSubsytem = false;
  public boolean enableSpinnyboiSubsytem = false;
  public boolean enableTurretSubsytem = false;
  public boolean enableVisionSubsytem = false;

  //////////////////////////////////////////////////////////////////////////////
  // Motor IDs

  // BallManagement Subsystem
  public int BALL_MANAGEMENT_MOTOR_ID = 14;

  // Climber Subsystem
  public int LEFT_ARM_MOTOR_ID = 12;
  public int RIGHT_ARM_MOTOR_ID = 8;

  // Drive Subsystem
  public int RIGHT_DRIVE_LEADER_ID = 1;
  public int LEFT_DRIVE_LEADER_ID = 2;
  public int RIGHT_DRIVE_FOLLOWER_ID = 3;
  public int LEFT_DRIVE_FOLLOWER_ID = 4;

  // Intake Subsystem
  public int INTAKE_MOTOR_ID = 10;

  // Shooter Subsystem
  public int FEEDER_MOTOR_ID = 15;
  public int SHOOTER_MOTOR_ID = 9;

  // Spinnyboi Subsystem
  public int SPINNYBOI_MOTOR_ID = 11;

  // Turret Subsystem
  public int AZIMUTH_MOTOR_ID = 7;
  public int ELEVATION_MOTOR_ID = 6;

}
