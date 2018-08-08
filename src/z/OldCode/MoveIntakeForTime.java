package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team1646.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveIntakeForTime extends DoSomethingForTime {
	protected IntakeSubsystem intake = Robot.intake;
	protected double speed;
	
    public MoveIntakeForTime(double time, double speed) {
        super( time );
        requires( intake );
        this.speed = speed;
    }

    // Called when time is up
    @Override
    protected void end() {
    	//Stop
    	intake.stopIntake();
    	super.end();
    }
}
