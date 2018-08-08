package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.PGJoystick;
import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.RobotMap;
import org.usfirst.frc.team1646.robot.subsystems.DriveTrainSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public final class DriveWithJoy extends Command {
	
    DriveTrainSubsystem driveTrain = Robot.driveTrain;
    PGJoystick driverController = Robot.driverController;
    
    public DriveWithJoy() {
    	requires(driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    @Override protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override protected void execute() {
    	//double gyroAngle = Robot.gyro.getAngle();
    	//SmartDashboard.putNumber("Gyro Angle", gyroAngle);
    	
    	double yVal = driverController.y();
    	double xVal = driverController.x();
    	double rVal = driverController.r();
    	
    	SmartDashboard.putNumber("yVal", yVal);
    	SmartDashboard.putNumber("xVal", xVal);
    	//double yCoord = Robot.oi.controller.getY();
    	//double xCoord = Robot.oi.controller.getX();    	
    
    	//controller and robot responds differently for rVal.
        driveTrain.mecanumRobotCentric(xVal, rVal, yVal);
    	
    	    	
    }
    // Make this return true when this Command no longer needs to run execute()
    @Override protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override protected void interrupted() {
    	end();
    }
}
