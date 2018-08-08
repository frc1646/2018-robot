package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class OffSeasonDriveForwardForTime extends Command {

	public double power;
	public double time;
	public double startTime;
	public double endTime;
	public double startAngle;
	public double powerVar;
	public double pvConstant = 100;
	
    public OffSeasonDriveForwardForTime(double power, double time) {
    	this.power = power;
    	this.time = time;
    	requires(Robot.driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	SmartDashboard.putNumber("pvConstant", pvConstant);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startAngle = Robot.gyro.getAngle();
    	startTime = Timer.getFPGATimestamp();
    	endTime = startTime + time;
    	
    	//Robot.driveTrain.mecanumRobotCentric(0, 0, power);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	powerVar = (startAngle - Robot.gyro.getAngle()) / pvConstant;
    	Robot.driveTrain.mecanumRobotCentric(0, 0 - powerVar, power);
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
    	Robot.driveTrain.mecanumRobotCentric(0, 0, 0);
    }
}
