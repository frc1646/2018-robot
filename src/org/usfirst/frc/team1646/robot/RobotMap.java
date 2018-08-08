package org.usfirst.frc.team1646.robot;

import edu.wpi.first.wpilibj.DriverStation;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	
	
	/* OI */
	public static int DRIVER_CONTROLLER_PORT = 0;
	public static int OPERATER_CONTROLLER_PORT = 1;

	
	//xVal
	public static int LEFT_X_AXIS_PORT = 0;
	//rVal
	public static int RIGHT_X_AXIS_PORT = 4;
	//yVal
	public static int LEFT_Y_AXIS_PORT = 1;

	public static int LEFT_TRIGGER_AXIS_PORT = 2;
	public static int RIGHT_TRIGGER_AXIS_PORT = 3;
	//left
	public static int DRIVER_X_BUTTON_PORT = 3;
	public static int OPERATOR_X_BUTTON_PORT = 1;
	//right
	public static int DRIVER_B_BUTTON_PORT = 2;
	public static int OPERATOR_B_BUTTON_PORT = 3;
	//top		
	public static int DRIVER_Y_BUTTON_PORT = 4;
	public static int OPERATOR_Y_BUTTON_PORT = 4;
	//bottom
	public static int DRIVER_A_BUTTON_PORT = 1;
	public static int OPERATOR_A_BUTTON_PORT = 2;
	 
	
	public static int DRIVER_LEFT_BUTTON_PORT = 5;
	public static int DRIVER_RIGHT_BUTTON_PORT = 6;
	
	public static int OPERATOR_LEFT_BUTTON_PORT = 5;
	public static int OPERATOR_RIGHT_BUTTON_PORT = 6;
	
	public static final int START_BUTTON_PORT = 8;
	
	/* Autonomous Values */
	//Following are for DriveTrain 
	public static double forwardTimeAutoLine = 3000;
	public static double forwardSpeedAutoLine = 0.9;
	
	public static double forwardTimeScale = 2000;
	public static double forwardSpeedScale = 0.8;
	public static double rotateTimeScale = 1000;
	public static double rotateSpeedScale = 0.8;
		/*	double forwardTime = 2000; // TODO: get from SD
	double forwardSpeed = 0.8;
	double rotateTime = 1000; // TODO: get from SD
	double rotateSpeed = 0.8; // positive is clockwise
	*/
	/* Driver Station */
	
	
	/* DRIVE TRAIN */
	
	public static int MOTOR_PORT_FRONT_LEFT = 1;
	public static int MOTOR_PORT_REAR_LEFT = 0;
	public static int MOTOR_PORT_FRONT_RIGHT = 3;
	public static int MOTOR_PORT_REAR_RIGHT = 2;
	
	//Digital Inputs [DIO]
	public static int ENCODER_PORT_FRONT_LEFT_A = -1;
	public static int ENCODER_PORT_FRONT_LEFT_B = -1;
	
	public static int ENCODER_PORT_REAR_LEFT_A = -1;
	public static int ENCODER_PORT_REAR_LEFT_B = -1;
	
	public static int ENCODER_PORT_FRONT_RIGHT_A = -1;
	public static int ENCODER_PORT_FRONT_RIGHT_B = -1;
	
	public static int ENCODER_PORT_REAR_RIGHT_A = -1;
	public static int ENCODER_PORT_REAR_RIGHT_B = -1;
	
	//FIXME: Port Number for the gyro undetermined [DIO]
	public static int GYRO_PORT;
	
	//Joystick offsets
	public static double offsetY = 0;
	public static double offsetX = 0;
	public static double offsetR = 0;
	
	public static double offsetLT = 0;
	public static double offsetRT = 0;
	
	/* ELEVATOR */
	//TODO add motors for elevator
	//TODO add a winch Encoder
	
	//public static int ELEVATOR_LIFT_MOTOR_PORT = -1;
	
	public static int ELEVATOR_LIFT_DOUBLE_SOLENOID_PORT_A = 3;
	public static int ELEVATOR_LIFT_DOUBLE_SOLENOID_PORT_B = 4;
	//FIXME: Elevator Port [PWM]
	public static int MOTOR_PORT_ELEVATOR_LIFT = 4;
	public static int LIMIT_SWITCH_PORT = 0;
		//FIXME: DI number needs to be assigned correctly
	public static int ELEVATOR_ENCODER_PORT_CHANNEL_A = 9;
	public static int ELEVATOR_ENCODER_PORT_CHANNEL_B = 8;
	//public static int ELEVATOR_ANALOG_POTENTIOMETER_PORT = 0;
	
	public static double maxElevatorHeight = 100;//Incorrect, Change!!!!
	public static double minElevatorHeight = 0;//Might need Changed
	public static double switchElevatorHeight = 50;//Also needs changed!!!
	
	public static double kP = 0.0;
	public static double kI = 0.0;
	public static double kD = 0.0;
	
	/* INTAKE */
	//TODO add motors for intake
	
	//FIXME: motor number need assigned with correct number [PWM]
	public static int MOTOR_PORT_INTAKE_LEFT = 5;
	public static int MOTOR_PORT_INTAKE_RIGHT = 6;//0
	
	//To convert a positive power for a given 'intake' direction, multiply by these factors
	public static int MOTOR_INTAKE_CUBE_IN_POLARITY = 1;
	public static int MOTOR_INTAKE_CUBE_OUT_POLARITY = -MOTOR_INTAKE_CUBE_IN_POLARITY;
	public static int INTAKE_GROUND_HEIGHT = 0;
	public static int INTAKE_SWITCH_HEIGHT = 1;
	public static int INTAKE_SCALE_HEIGHT = 2;
	
	//TODO add solenoid for pneumatics
	public static int SOLENOID_PORT_INTAKE_A = 5;
	public static int SOLENOID_PORT_INTAKE_B = 6;
	
	//Digital Inputs [DIO]
	public static int INTAKE_SENSOR_PORT = -1;
	
	
	
	public static boolean spinOut = false;
	public static boolean spinIn = true;
	
	
	
	/* RAMP */
	//TODO add motors for ramp
	
}
