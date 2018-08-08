package z.OldCode;

import org.usfirst.frc.team1646.robot.commands.EjectCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoEjectCubeForTime extends CommandGroup {

    public AutoEjectCubeForTime() {
    	double ejectTime = 4000;
    	double ejectSpeed = 8.0; 
    	addSequential(new EjectCube());
    	addSequential(new WaitCommand(ejectTime));
    	
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
