package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.Robot;
//import org.usfirst.frc.team1646.testingCommands.UpdateCameraValues;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CameraSubsystem extends PIDSubsystem {
	NetworkTable visionContour;
	double tooLargeX = 10000; // Roger: should be final static
	public final static double viewWidth = 160.0;
	double[] defaults = {tooLargeX};
    // Initialize your subsystem here
    public CameraSubsystem() {
    	super(0, 0, 0); // Roger: a really good practice is to put comments on "generic" args like 0
    	visionContour = NetworkTable.getTable("GRIP/visionContour");
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    public double make0Centered(double x) {
    	return x - (viewWidth / 2);
    	
    }

    public double getCenterX() {
    	double[] center_X_Array = visionContour.getNumberArray("centerX", defaults);
    	double result;
    	if(center_X_Array.length > 0 && center_X_Array[0] != tooLargeX) {
    		result = center_X_Array[0];
    	} else {
    		result = tooLargeX;
    	}
    	SmartDashboard.putNumber("centerX", result);
    	return result;
    }
    
    public double getArea() {
    	double[] area_Array = visionContour.getNumberArray("area", defaults);
    	double result;
    	if(area_Array.length > 0 && area_Array[0] != tooLargeX) {
    		result = area_Array[0];
    	} else {
    		result = tooLargeX;
    	}
    	SmartDashboard.putNumber("area", result);
    	return result;
    }
    
    public boolean isValid(double value) {
    	return value != tooLargeX;
    }
    
 	
    public void initDefaultCommand() {
    	//setDefaultCommand(new UpdateCameraValues());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return 0.0;
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
