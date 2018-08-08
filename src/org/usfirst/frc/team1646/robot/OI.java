package org.usfirst.frc.team1646.robot;


//import org.usfirst.frc.team1646.robot.commands.AutoIntakeByRotating;
//import org.usfirst.frc.team1646.robot.commands.AutoIntakeByStrafing;
import org.usfirst.frc.team1646.robot.commands.CloseIntake;
import org.usfirst.frc.team1646.robot.commands.EjectCube;
import org.usfirst.frc.team1646.robot.commands.IntakeCube;
import org.usfirst.frc.team1646.robot.commands.LowerElevator;
import org.usfirst.frc.team1646.robot.commands.OffSeasonChangeElevatorPosition;
import org.usfirst.frc.team1646.robot.commands.OpenIntake;
import org.usfirst.frc.team1646.robot.commands.RaiseElevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import z.OldCode.AutoSwitch;
import z.OldCode.DriveForwardForTime;
import z.OldCode.PrimitiveCubeInLeftScaleFrom1;
import z.OldCode.SetIntakeHeight;
import z.OldCode.StrafeForTime;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER_PORT);
	public Joystick operatorController = new Joystick(RobotMap.OPERATER_CONTROLLER_PORT);
	
	public Button xButton = new JoystickButton(driverController, RobotMap.DRIVER_X_BUTTON_PORT);
	public Button yButton = new JoystickButton(driverController, RobotMap.DRIVER_Y_BUTTON_PORT);
	public Button aButton = new JoystickButton(driverController, RobotMap.DRIVER_A_BUTTON_PORT);
	public Button bButton = new JoystickButton(driverController, RobotMap.DRIVER_B_BUTTON_PORT);
	
	public Button xOpButton = new JoystickButton(operatorController, RobotMap.OPERATOR_X_BUTTON_PORT);
	public Button yOpButton = new JoystickButton(operatorController, RobotMap.OPERATOR_Y_BUTTON_PORT);
	public Button aOpButton = new JoystickButton(operatorController, RobotMap.OPERATOR_A_BUTTON_PORT);
	public Button bOpButton = new JoystickButton(operatorController, RobotMap.OPERATOR_B_BUTTON_PORT);
	
	public Button driverLeftButton= new JoystickButton(driverController, RobotMap.DRIVER_LEFT_BUTTON_PORT);
	public Button driverRightButton= new JoystickButton(driverController, RobotMap.DRIVER_RIGHT_BUTTON_PORT);
	
	public Button leftButton = new JoystickButton(driverController, RobotMap.DRIVER_LEFT_BUTTON_PORT);
	public Button rightButton = new JoystickButton(driverController, RobotMap.DRIVER_RIGHT_BUTTON_PORT);
	
	public Button operatorLeftButton = new JoystickButton(operatorController, RobotMap.OPERATOR_LEFT_BUTTON_PORT);
	public Button operatorRightButton = new JoystickButton(operatorController, RobotMap.OPERATOR_RIGHT_BUTTON_PORT);
	
	public Button startButton = new JoystickButton(driverController, RobotMap.START_BUTTON_PORT);
	
	public final static int LEFT = -1;
	public final static int RIGHT = 1;
	
	public OI() {
		
	}
	
	public void initCommands()
	{
		//xButton.whenPressed(new CloseIntake()/*new StrafeForTime(5000, LEFT, 0.5)*/);
		//bButton.whileHeld(new AutoIntakeByRotating(LEFT));
		//yButton.whileHeld(new AutoIntakeByStrafing(LEFT));
		//aButton.whenPressed(new OpenIntake()/*new DriveForwardForTime(5000, 0.5)*/);
	
		
		bOpButton.whenPressed(new OpenIntake());
	
		xOpButton.whenPressed(new CloseIntake());
		//xButton.whenPressed(new CloseIntake());
		//yOpButton.whileHeld(new RaiseElevator());
		
		yOpButton.whileHeld(new RaiseElevator());
		aOpButton.whileHeld(new LowerElevator());
		//aOpButton.whileHeld(new DownElevator(0.8));
		bOpButton.whenPressed(new OpenIntake());
		//bButton.whenPressed(new OpenIntake());
		
		//yButton.whileHeld(new OffSeasonChangeElevatorPosition(1.0));
		//aButton.whileHeld(new OffSeasonChangeElevatorPosition(-1.0));
		
		//driverLeftButton.whileHeld(new IntakeCube());
		//driverRightButton.whileHeld(new EjectCube());
		operatorLeftButton.whileHeld(new EjectCube());
		operatorRightButton.whileHeld(new IntakeCube());
		
		//leftButton.whileHeld(new IntakeCube());
		//rightButton.whileHeld(new EjectCube());
		
		
		
		//startButton.whenPressed(new PrimitiveCubeInLeftScaleFrom1());
		//leftTriggerButton.whileHeld(new AutoIntakeByRotating(LEFT));
		//rightTriggerButton.whileHeld(new AutoIntakeByRotating(RIGHT));	
	}	
	
	
	/*public void setControllerAxis() {
		controller.setXChannel(0);
		controller.setYChannel(1);
	}*/
	
}
