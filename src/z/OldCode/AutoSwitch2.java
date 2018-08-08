package z.OldCode;

import org.usfirst.frc.team1646.robot.commands.EjectCube;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoSwitch2 extends CommandGroup {

	public String FMS = DriverStation.getInstance().getGameSpecificMessage();
	
    public AutoSwitch2(double forwardSpeed, double strafeSpeed) {
    	addSequential(new GoForward(forwardSpeed));
    	addSequential(new WaitCommand(1));
    	if(FMS.charAt(0) == 'L') {
    		addSequential(new StrafeLeft(strafeSpeed));
    		addSequential(new WaitCommand(1));
    		addSequential(new GoForward(forwardSpeed));
    		addSequential(new WaitCommand(1));
    		addSequential(new EjectCube());
    	}
    	else if(FMS.charAt(1) == 'R') {
    		addSequential(new StrafeRight(strafeSpeed));
    		addSequential(new WaitCommand(1));
    		addSequential(new GoForward(forwardSpeed));
    		addSequential(new WaitCommand(1));
    		addSequential(new EjectCube());
    		
    	}
        
}
}
