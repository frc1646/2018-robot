package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.PGJoystick;
import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ControlElevator extends Command {

	PGJoystick operatorController = Robot.operatorController;
	public boolean up = false;
	public boolean down = false;
	
    public ControlElevator() {
    	requires(Robot.elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double upVal = operatorController.LT();
    	double downVal = operatorController.RT();
    	
    	if (upVal > 0) {
    		up = true;
    	}
    	if (downVal > 0) {
    		down = true;
    	}
    	//double yCoord = Robot.oi.controller.getY();
    	//double xCoord = Robot.oi.controller.getX();    	
    
    	//controller and robot responds differently for rVal.
    	
    	/*if(up || down) {
    	Robot.elevator.raiseElevator(upVal);
    		Robot.elevator.lowerElevator(downVal);
    		if (up && down) {
    			Robot.elevator.stopElevator();
    		}
    	}*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
    	//Robot.elevator.stopElevator();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
