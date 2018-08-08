package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1646.robot.subsystems.DriveTrainSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class StrafeUntilVisionTarget extends DoSomethingWithTimeout {
	//CameraSubsystem camera = Robot.camera;
	DriveTrainSubsystem driveTrain = Robot.driveTrain;
	double directionChange;
	double strafeSpeed = 0.9;
	private final static double TIMEOUT = 10000;
	private final static double TOLERANCE = 5;
	
	public StrafeUntilVisionTarget(double directionChange) {
    	super( TIMEOUT );
    	//requires( camera );
    	requires(driveTrain);
    	this.directionChange = directionChange;
    }

    // Called just before this Command runs the first time
    @Override protected void initialize() {
    	super.initialize();
    }
    
    // Called repeatedly when this Command is scheduled to run
    @Override protected void execute() {
    	double xVal = directionChange * strafeSpeed;
    	double rVal = 0;
    	double yVal = 0;
    	
    	driveTrain.mecanumRobotCentric(xVal, rVal, yVal);
    }

    // Make this return true when this Command no longer needs to run execute()
    //This is the until condition that we are strafing until the vision target
    @Override protected boolean isFinished() {
    	/*double centerX = camera.getCenterX();
    	if (camera.isValid(centerX)) {
    		//Is the target nearly centered?
    		double tapeX = camera.make0Centered(centerX);
    		if(Math.abs(tapeX) < TOLERANCE) {
    			return true;
    		}
    		//We're assuming the tolerance is big enough to prevent overshooting
    		assert (tapeX >= 0) == (directionChange > 0) : "OverShot";
    	}*/
        return super.isFinished();
    }

    // Called once after isFinished returns true
    @Override protected void end() {
    	driveTrain.mecanumRobotCentric(0, 0, 0);
    	super.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override protected void interrupted() {
    	end();
    	super.interrupted();
    }
}
