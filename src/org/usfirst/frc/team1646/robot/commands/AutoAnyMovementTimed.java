package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoAnyMovementTimed extends Command {

    private double startTime;
	private double endTime;
	private double xPower;
	private double rPower;
	private double yPower;
	private double time;
	private double pvConstant = 100;
	private double powerVar;
	private double startAngle;
	
    public AutoAnyMovementTimed(double x, double r, double y, double time) {
    	requires(Robot.driveTrain);
    	this.xPower = x;
    	this.rPower = r;
    	this.yPower = y;
    	this.time = time;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startAngle = Robot.gyro.getAngle();
    	startTime = Timer.getFPGATimestamp();
    	endTime = startTime + time;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	powerVar = (startAngle - Robot.gyro.getAngle()) / pvConstant;
    	Robot.driveTrain.mecanumRobotCentric(xPower, rPower - powerVar, yPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp() >= endTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.mecanumRobotCentric(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
