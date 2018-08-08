package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StrafeRight extends Command {
	
	private double speed = 0;

    public StrafeRight(double speed) {
    	this.speed = speed;
    	requires(Robot.driveTrain);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.mecanumRobotCentric(speed, 0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//end();
    }
}
