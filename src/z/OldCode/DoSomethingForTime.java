package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This is an abstract class from which can be built commands that do something
 * for a specified period of time.
 */
public class DoSomethingForTime extends Command {
	double endTime;
	double driveTime;
	
    private static double curTimeInMSecs() {
    	return 1000 * Timer.getFPGATimestamp();
    }
    
    public DoSomethingForTime(double time) {
    	this.driveTime = time;    	
    }

    // Called just before this Command runs the first time
    @Override protected void initialize() {
    	endTime = curTimeInMSecs() + driveTime;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override protected boolean isFinished() {
        return curTimeInMSecs() >= endTime;
    }
}
