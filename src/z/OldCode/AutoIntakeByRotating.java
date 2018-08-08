package z.OldCode;

import org.usfirst.frc.team1646.robot.PGJoystick;
import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */

//
public final class AutoIntakeByRotating extends DoSomethingWithTimeout {

	private PGJoystick driverController = Robot.driverController;
	private double forwardSpeed = 0.8;
	private final static double TIMEOUT = 10000;
	double direction;
	
    public AutoIntakeByRotating(double direction) {
    	super( TIMEOUT );
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	requires(Robot.intake);
    	this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO Make same changes as made to StrafeUntilVisionTarget
    	/*
    	if (SmartDashboard.getBoolean("validCenterX", false)) {
    		double cubeX = SmartDashboard.getNumber("centerX", Robot.camera.getCenterX());
    		double rMotionVal = direction * (cubeX / ((Robot.camera.viewWidth / 2)));
    		double xMotionVal = 0;
    		double yMotionVal = forwardSpeed;
    		Robot.driveTrain.mecanumRobotCentric(xMotionVal, rMotionVal, yMotionVal);
    	} else {
    		Robot.driveTrain.mecanumRobotCentric(driverController.x(), driverController.r(), driverController.y());
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//TODO Are we close enough to the target?
        return super.isFinished() || /*this One->*/false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
