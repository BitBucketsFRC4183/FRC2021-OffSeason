package frc.robot.config;

import frc.robot.config.urations.JuniorConfig;

public class ConfigChooser {
  public static enum Bot {
    Shawty, Junior
  };

  // Change this line to switch configurations.
  static Bot currentRobot = Bot.Shawty;

  public static Config GetConfig() {
    switch (currentRobot) {
    case Shawty:
      return new Config();
    case Junior:
      return new JuniorConfig();
    default:
      return new Config();
    }
  }

}
