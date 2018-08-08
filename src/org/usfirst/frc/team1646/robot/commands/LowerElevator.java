package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LowerElevator extends Command {

	public boolean isLimitSwitchPressed;
	
    public LowerElevator() {
    	requires(Robot.elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	//Robot.elevatorSubsystem.lowerElevator(-1 * speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.elevator.limitSwitch.getValue() <= 10) {
    		isLimitSwitchPressed = true;
    	} else {
    		isLimitSwitchPressed = false;
    		Robot.elevator.manual_lowerElevator();
    	}
    	
    	//SmartDashboard.getNumber("Encoder Count", Robot.elevator.elevatorEncoder.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isLimitSwitchPressed;
    }
        		

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stopElevator();
    	//Robot.elevatorSubsystem.stopElevator();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
