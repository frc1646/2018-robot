package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OffSeasonAutoIntake extends Command {
	public double power = 0.5;
	public double time;
	public double startTime;
	public double endTime;

    public OffSeasonAutoIntake(double time) {
    	this.time = time;
    	requires(Robot.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = Timer.getFPGATimestamp();
    	endTime = startTime + time;
    	
    
    	
    	Robot.intake.setIntakeSpeed(power, RobotMap.spinIn, /*Wheelbias=*/ 0.0);
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
    	Robot.intake.setIntakeSpeed(0, RobotMap.spinIn, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.setIntakeSpeed(0, RobotMap.spinIn, 0.0);
    }
}
