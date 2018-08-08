package org.usfirst.frc.team1646.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class SimplePlacement extends CommandGroup {

	
	//
    public SimplePlacement() {
    	addSequential(new AutoAnyMovementTimed(/*x=*/0, /*r=*/0, /*y=*/0.5, /*time=*/2.0));
    	addSequential(new RaiseElevatorTimed(0.75, 2.5));
    	addSequential(new EjectCubeTimed(0.8, 1.5));
    	
    	
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order

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
