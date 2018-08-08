package z.OldCode;

import org.usfirst.frc.team1646.robot.commands.DeployIntake;
import org.usfirst.frc.team1646.robot.commands.EjectCube;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoExchangeCrossLine extends CommandGroup {
	//Disclaimer: This commandGroup assumes that team's robot will be positioned at an angle to the most outer exchange boundaries.
	//Idea is as follows: deploy the intake--upright to horizontal (parallel to surface)

    public AutoExchangeCrossLine() {
    	addSequential(new DeployIntake());
    	addSequential(new EjectCube());
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()9
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
