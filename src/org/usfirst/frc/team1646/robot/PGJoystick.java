package org.usfirst.frc.team1646.robot;
import edu.wpi.first.wpilibj.Joystick;

/* Precision Guesswork-enhanced abstraction of Joystick customized for the robot's specific
 * use.
 */
public class PGJoystick {
    Joystick joystick;
    
	private double rawX()
	{
		return joystick.getRawAxis(RobotMap.LEFT_X_AXIS_PORT);
	}
	
	private double rawY()
	{
		return joystick.getRawAxis(RobotMap.LEFT_Y_AXIS_PORT);
	}
	
	private double rawR()
	{
		return joystick.getRawAxis(RobotMap.RIGHT_X_AXIS_PORT);
	}
	
	private double rawLT() {
		return joystick.getRawAxis(RobotMap.LEFT_TRIGGER_AXIS_PORT);
	}
	
	private double rawRT() {
		return joystick.getRawAxis(RobotMap.RIGHT_TRIGGER_AXIS_PORT);
	}
    public PGJoystick(Joystick joystick) {
		this.joystick = joystick;
		// Roger: is there really any reason to put these in RobotMap at all?
		//Jasmine: Yes
    	RobotMap.offsetX = rawX();
		RobotMap.offsetY = rawY();
    	RobotMap.offsetR = rawR();
    	
    	RobotMap.offsetLT = rawLT();
    	RobotMap.offsetRT = rawRT();
	}

	public double x()
	{
		return -(rawX() - RobotMap.offsetX);
	}

	public double y()
	{
		return -(rawY() - RobotMap.offsetY);
	}
	
	public double r()
	{
		return -(rawR() - RobotMap.offsetR);
	}

	public double LT() {
		return -(rawLT() - RobotMap.offsetLT);
	}
	
	public double RT() {
		return -(rawRT() - RobotMap.offsetRT);
	}
}
