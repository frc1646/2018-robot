package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OffSeasonChangeElevatorPosition extends Command {

	public double direction;
	
    public OffSeasonChangeElevatorPosition(double direction) {
       requires(Robot.elevator);
       this.direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.changeSetPoint(Robot.elevator.getTheSetPoint() + direction);
    	//System.out.println("PID_Elevator_Command" + Robot.elevator.getTheSetPoint() +":"+direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
