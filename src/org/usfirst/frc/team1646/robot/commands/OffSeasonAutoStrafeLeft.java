package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OffSeasonAutoStrafeLeft extends Command {

	private double power;
	private double time;
	private double startTime;
	private double endTime;
	
	//Do not assign negative to power to move left. The sign is already taken care of on the initialize() method
    public OffSeasonAutoStrafeLeft(double power, double time) {
    	requires(Robot.driveTrain);
    	this.power = power;
    	this.time = time;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = Timer.getFPGATimestamp();
    	endTime = startTime + time;
    	Robot.driveTrain.mecanumRobotCentric(-power, 0, 0);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
