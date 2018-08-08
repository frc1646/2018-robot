package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.subsystems.DriveTrainSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinToOrientation extends Command {
	DriveTrainSubsystem driveTrain = Robot.driveTrain;
	private int targetOrientation = 0;
	final static int tolerance = 5; // degrees; just a guess
	final static double maxSpinSpeed = 0.5;
	
    public SpinToOrientation(int orientation) {
    	this.targetOrientation = orientation;
    	requires(driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    int error() {
    	return (int)Robot.gyro.getAngle() - targetOrientation;

    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	int err = error();
    	if (err < 180) {
    		err += 180;
    	} else if (err > 180) {
    		err -= 180;
    	} else {
    		
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	driveTrain.mecanumRobotCentric(0, 0/*r*/, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(error()) <= tolerance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveTrain.mecanumRobotCentric(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
