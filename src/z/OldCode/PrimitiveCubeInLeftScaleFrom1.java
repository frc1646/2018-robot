package z.OldCode;

import org.usfirst.frc.team1646.robot.RobotMap;
import org.usfirst.frc.team1646.robot.commands.EjectCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PrimitiveCubeInLeftScaleFrom1 extends CommandGroup {

    public PrimitiveCubeInLeftScaleFrom1() {
    	double forwardTime = 2000; // TODO: get from SD
		double forwardSpeed = 0.8;
		double rotateTime = 1000; // TODO: get from SD
		double rotateSpeed = 0.8; // positive is clockwise
		//Could depend on which side of the field you're on
					
		addSequential(new DriveForwardForTime(forwardTime, forwardSpeed));
		addSequential(new RotateForTime(rotateTime, rotateSpeed));
		//addSequential(new SetIntakeHeightTimeBased(RobotMap.INTAKE_SCALE_HEIGHT));
		addSequential(new EjectCube());	

        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
