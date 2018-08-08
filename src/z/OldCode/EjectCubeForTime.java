package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EjectCubeForTime extends MoveIntakeForTime {

    public EjectCubeForTime(double time, double speed) {
    	super(time, speed);
    	requires(Robot.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	super.initialize();
    	Robot.intake.ejectCube(speed);
    }
}
