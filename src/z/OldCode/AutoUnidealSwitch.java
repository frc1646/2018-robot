package z.OldCode;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoUnidealSwitch extends CommandGroup {

	//This commandGroup assumes that you robot is aligned with one of the switch plates,
	//but your alliance's plate is on the other side instead
    public AutoUnidealSwitch() {
    	double strafeTime = 8;
    	int strafeDirection = 1;
    	double strafeSpeed = 0.8;
    	
    	double forwardTime = 3;
    	double forwardSpeed = 0.8;
    	//Also assumes that positive 1 for direction means robot moving -->
    	//Assume default position is always going to be left
    	//addSequential(new StrafeForTime(strafeTime, direction, speed));
    	//addSequential(new DriveForwardTime(forwardTime, forwardSpeed));
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
