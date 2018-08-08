package org.usfirst.frc.team1646.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class test1 extends CommandGroup {

    public test1() {
    	String fieldSetup = SmartDashboard.getString ("fieldSetUp", "error");
    	double direction = -1; 
    	addSequential(new OffSeasonDriveForwardForTime(0.25, 0.5));
    	addSequential(new WaitCommand(1.5));
    	addSequential(new OffSeasonAutoAngleAdjust(0.5, -90), 3);
    	addSequential(new WaitCommand(1.5));
    	addSequential(new OffSeasonDriveForwardForTime(0.25, 0.5));
    	addSequential(new WaitCommand(1.5));
    	addSequential(new OffSeasonAutoAngleAdjust(0.5, 90), 3);
    	addSequential(new WaitCommand(1.5));
    	addSequential(new OffSeasonDriveForwardForTime(0.25, 0.5));
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
