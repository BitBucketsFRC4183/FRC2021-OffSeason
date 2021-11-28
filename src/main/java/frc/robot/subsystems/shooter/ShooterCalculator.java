package frc.robot.subsystems.shooter;

import java.util.List;

public class ShooterCalculator
{
    public static final int DEFAULT_SPEED = 1000; //RPM
    public static final float FEEDER_OUTPUT = 0.5f;

    private final List<ShooterDictionaryEntry> dictionary;

    public ShooterCalculator()
    {
        this.dictionary = List.of(
                new ShooterDictionaryEntry(109, 4500, 43),
                new ShooterDictionaryEntry(130, 4500, 43.5),
                new ShooterDictionaryEntry(150, 4500, 43),
                new ShooterDictionaryEntry(196, 5200, 46),
                new ShooterDictionaryEntry(206, 5050, 45),
                new ShooterDictionaryEntry(323, 6100, 53),
                new ShooterDictionaryEntry(397, 7400, 59)
        );
    }

    //Simply returns the RPM given an input distance – other logic should be done in the Robot class
    public double getRPM(double distance, double angle) //Angle currently unused
    {
        double speed = DEFAULT_SPEED;

        double difference = Math.abs(this.dictionary.get(0).getDistance() - distance);
        for(ShooterDictionaryEntry e : this.dictionary)
        {
            double checkDiff = Math.abs(e.getDistance() - distance);
            if(checkDiff < difference)
            {
                speed = e.getSpeed();
                difference = checkDiff;
            }
        }

        return speed;
    }

    public static class ShooterDictionaryEntry
    {
        private final double distance; //Inches
        private final double speed; //RPM
        private final double angle; //Degrees

        public ShooterDictionaryEntry(double distance, double speed, double angle)
        {
            this.distance = distance;
            this.speed = speed;
            this.angle = angle;
        }

        public double getDistance()
        {
            return this.distance;
        }

        public double getSpeed()
        {
            return this.speed;
        }

        public double getAngle()
        {
            return this.angle;
        }
    }
}
