package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OffSeasonAutoAngleAdjust extends Command {

	private double power;
	private double angle;
	private double startAngle;
	private double endAngle;
	private double powerVar;
	private int turnDirection;
	
    public OffSeasonAutoAngleAdjust(double power, double angle) {
    	
    	requires(Robot.driveTrain);
    	this.power = power;
    	this.angle = angle;
        
    	if (angle < 0) {
    		turnDirection = -1;
    	} else if (angle > 0) {
    		turnDirection = 1;
    	}
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    	startAngle = Robot.gyro.getAngle();
    	endAngle = startAngle + angle;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	powerVar = (endAngle - Robot.gyro.getAngle())/angle;
    	
    	Robot.driveTrain.mecanumRobotCentric(0, -power * ((0.5 * (powerVar) + 0.5)), 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println("start: " + startAngle + "end: " + endAngle + Robot.gyro.getAngle());
        return (turnDirection * Robot.gyro.getAngle()) >= (turnDirection * endAngle);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.mecanumRobotCentric(0,0,0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.mecanumRobotCentric(0,0,0);
    }
}
