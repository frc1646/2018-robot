package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.subsystems.PneumaticElevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public final class SetIntakeHeight extends Command {

	PneumaticElevator elevator = Robot.pneumaticElevator;
	private int height;
	
    public SetIntakeHeight(int height) {
    	requires(elevator);
    	this.height = height;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (height == 0) {
    		elevator.lower();
    	} else if (height == 1) {
    		elevator.raise();
    	}
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.stopLift();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
