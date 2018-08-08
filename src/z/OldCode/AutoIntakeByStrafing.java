package z.OldCode;

import org.usfirst.frc.team1646.robot.PGJoystick;
import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public final class AutoIntakeByStrafing extends DoSomethingWithTimeout {

	private PGJoystick joystick;
	private double forwardSpeed = 0.8;
	private final static double TIMEOUT = 10000;
	double direction;
	
    public AutoIntakeByStrafing(double direction) {
    	super( TIMEOUT );
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	requires(Robot.intake);
    	this.direction = direction;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    @Override protected void execute() {
    	/*if (SmartDashboard.getBoolean("validCenterX", false)) {
    		//TODO Make same changes as to StrafeUntilVisionTarget
    		double cubeX = SmartDashboard.getNumber("centerX", Robot.camera.getCenterX());
    		double rMotionVal = 0;
    		double xMotionVal = direction * (cubeX / ((Robot.camera.viewWidth / 2)));
    		double yMotionVal = forwardSpeed;
    		Robot.driveTrain.mecanumRobotCentric(xMotionVal, rMotionVal, yMotionVal);
    	} else {
    		double yMotionVal = joystick.y();
        	double xMotionVal = joystick.x();
        	double rMotionVal = joystick.r();
        	Robot.driveTrain.mecanumRobotCentric(xMotionVal, rMotionVal, yMotionVal);
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override protected boolean isFinished() {
    	//TODO Are we close enough to the target?
        return super.isFinished() || /*this One ->*/ false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
