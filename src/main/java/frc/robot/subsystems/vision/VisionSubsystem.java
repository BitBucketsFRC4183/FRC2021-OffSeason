package frc.robot.subsystems.vision;

import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;

import java.util.SplittableRandom;

public class VisionSubsystem extends BitBucketsSubsystem  {
   private double angle;
   private double distance;

   public VisionSubsystem(Config config, DashboardConfig dashboardConfig) {
      super(config, dashboardConfig);
   }

   //hi matt it's zak i am sorry for invading ur code
//if u could write the vision func in a way that returns the angle and dist for me that would be epic 
   public double getAngle() {
      angle = 32.0;
      return angle;
   }
   public double getDistance() {
      distance = 87.0;
      return distance;
   }

   //Also temporary, just randomly decides if target exists or not
   public boolean hasTarget()
   {
      return new SplittableRandom().nextInt(2) < 1;
   }

   @Override
   public void init() {

   }

   @Override
   protected void addMotorsToList() {

   }

   @Override
   public void periodic() {

   }

   @Override
   public void disable() {

   }
}
