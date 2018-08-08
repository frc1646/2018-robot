package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.subsystems.DriveTrainSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StrafeWhileVisionTarget extends DoSomethingWithTimeout {

	DriveTrainSubsystem driveTrain = Robot.driveTrain; 
	double directionChange;
	double strafeSpeed = 0.9;
	private final static double TIMEOUT = 2000;
	
    public StrafeWhileVisionTarget(double directionChange) {
    	super( TIMEOUT );
    	requires(driveTrain);
    	this.directionChange = directionChange;
    }

    // Called just before this Command runs the first time
    @Override protected void initialize() {
    	super.initialize();
    	double xVal = directionChange * strafeSpeed;
    	double rVal = 0;
    	double yVal = 0;
    	
    	driveTrain.mecanumRobotCentric(xVal, rVal, yVal);
    }

    // Make this return true when this Command no longer needs to run execute()
    /*@Override protected boolean isFinished() {
       // return super.isFinished() || !Robot.camera.isValid(Robot.camera.getCenterX());
    }*/

    // Called once after isFinished returns true
    @Override protected void end() {
    	//Should we stop?	
    	super.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override protected void interrupted() {
    	super.interrupted();
    }
}
