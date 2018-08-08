package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.subsystems.DriveTrainSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Abstract class to move the robot in some way at 'speed' for time 'time'.
 * Stops when time is up.
 * The exact meaning of 'speed' is determined by subclasses.
 * Speed is "steadied" for reliability in auton
 */
public class MoveForTime extends DoSomethingForTime {
	protected DriveTrainSubsystem driveTrain = Robot.driveTrain;
	protected double speed;
	
    public MoveForTime(double time, double speed) {
        super( time );
        requires( driveTrain );
        this.speed = speed;
    }

    // Called when time is up
    @Override
    protected void end() {
    	//Stop
    	driveTrain.mecanumRobotCentric(0.0, 0.0, 0.0);
    	super.end();
    }
}
