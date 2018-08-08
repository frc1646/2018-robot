package z.OldCode;

import org.usfirst.frc.team1646.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoSwitch extends CommandGroup {
    
    public AutoSwitch() {
    	int ourRobotPosition = (int) SmartDashboard.getNumber(Robot.SD_ROBOT_POSITION_LABEL, -1);
		int path = Robot.ourSwitchPosition - ourRobotPosition; //-2..2
		SmartDashboard.putNumber("path Number", path);
    	
    	int forwardTime1 = 3000; //(int) SmartDashboard.getNumber(Robot.SD_FW_TIME_1_LABEL, 1000);
    	double forwardSpeed1 = 0.3; //SmartDashboard.getNumber(Robot.SD_FW_SPEED_1_LABEL, 0.5);
    	
    	double strafeTime = 0;
    	
    	switch ((int) Math.abs(path)) {
    	case 0: 
    		strafeTime = 0;//no strafe needed
    		break;
    	case 1:
    		strafeTime = 500; //SmartDashboard.getNumber(Robot.SD_STRAFE_TIME_SHORT_LABEL, 500);//short strafe
    		break;
    	case 2:
    		strafeTime = 1500; //SmartDashboard.getNumber(Robot.SD_STRAFE_TIME_LONG_LABEL, 1500);//long strafe
    		break;
    	}
    	
    	int strafeDirection = (path >= 0) ? 1 : -1;
    	double strafeSpeed = 0.5; //SmartDashboard.getNumber(Robot.SD_STRAFE_SPEED_LABEL, 0.5);
    	
    	double forwardTime2 = 5000; //SmartDashboard.getNumber(Robot.SD_FW_TIME_2_LABEL, 2000);
    	double forwardSpeed2 = 0.8; //SmartDashboard.getNumber(Robot.SD_FW_SPEED_2_LABEL, 0.5);
    	
    	addSequential(new DriveForwardForTime(forwardTime1, forwardSpeed1));
    	if( strafeTime > 0.001 ) {
    		addSequential(new StrafeForTime(strafeTime, strafeDirection, strafeSpeed));
    	}
    	//addSequential(new DriveForwardForTime(forwardTime2, forwardSpeed2));
    	//addSequential(new EjectCube());
    	
    	
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
