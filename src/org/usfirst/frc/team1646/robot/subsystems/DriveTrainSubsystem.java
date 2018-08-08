package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.RobotMap;
import org.usfirst.frc.team1646.robot.commands.DriveWithJoy;
//import org.usfirst.frc.team1646.testingCommands.AutoIntake;
//import org.usfirst.frc.team1646.testingCommands.CalibrateVictorSP;
//import org.usfirst.frc.team1646.testingCommands.MotorButton;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {
	
	public static VictorSP frontLeft;
	public static VictorSP rearLeft;
	public static VictorSP frontRight;
	public static VictorSP rearRight;
	
	//public static Servo intakeServo1;
	//public static Servo intakeServo2;
	
	public static Encoder frontLeftEncoder;
	public static Encoder rearLeftEncoder;
	public static Encoder frontRightEncoder;
	public static Encoder rearRightEncoder;
	
	static final double scaleSpeed = 0.8;
	static final double distancePerPulse = 0.0;
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoy());
        //setDefaultCommand(new AutoIntake());
		//Set the default command for a subsystem here.
        //setDefaultCommand(new MotorButton());
		//setDefaultCommand(new CalibrateVictorSP());
    }
	
	public DriveTrainSubsystem() {
		frontLeft = new VictorSP(RobotMap.MOTOR_PORT_FRONT_LEFT);
		frontRight = new VictorSP(RobotMap.MOTOR_PORT_FRONT_RIGHT);
		rearLeft = new VictorSP(RobotMap.MOTOR_PORT_REAR_LEFT);
		rearRight = new VictorSP(RobotMap.MOTOR_PORT_REAR_RIGHT);		
		
		//intakeServo1 = new Servo(0);
		//intakeServo2 = new Servo(1);
		//frontLeftEncoder = new Encoder(RobotMap.ENCODER_PORT_FRONT_LEFT_A, RobotMap.ENCODER_PORT_FRONT_LEFT_B, false, Encoder.EncodingType.k4X);
		//rearLeftEncoder = new Encoder(RobotMap.ENCODER_PORT_REAR_LEFT_A, RobotMap.ENCODER_PORT_REAR_LEFT_B, false, Encoder.EncodingType.k4X);
		//frontRightEncoder = new Encoder(RobotMap.ENCODER_PORT_FRONT_RIGHT_A, RobotMap.ENCODER_PORT_FRONT_RIGHT_B, false, Encoder.EncodingType.k4X);
		//rearRightEncoder = new Encoder(RobotMap.ENCODER_PORT_REAR_RIGHT_A, RobotMap.ENCODER_PORT_REAR_RIGHT_B, false, Encoder.EncodingType.k4X);
		SmartDashboard.putString("Status 1", "Drivetrain.driveTrain");

		
		frontLeft.setInverted(false);
		frontRight.setInverted(true);
		rearLeft.setInverted(false);
		rearRight.setInverted(true);
		
		//FIXME: "Cannot instantiate the type Gyro" 
		
		//prepMechanumWheels();
	}
	/*
	public void turnServos() {
		intakeServo1.set(1.0);
		intakeServo2.set(1.0);
	}
	
*/    
	public void prepMechanumWheels() {
		//rDrive.setMaxOutput(maxOutput);
		//rDrive.setExpiration(timeout);
		//rDrive.setSensitivity(sensitivity);
		
		//OPTIONAL: rDrive.setInvertedMotor(motor, true);
	}
	
	
	public void prepEncoderDriveTrain() {
		frontLeftEncoder.setDistancePerPulse(distancePerPulse);
		rearLeftEncoder.setDistancePerPulse(distancePerPulse);
		frontRightEncoder.setDistancePerPulse(distancePerPulse);
		rearRightEncoder.setDistancePerPulse(distancePerPulse);
	}
	
	public void getEncodersDistance() {
		frontLeftEncoder.getDistance();
		rearLeftEncoder.getDistance();
		frontRightEncoder.getDistance();
		rearLeftEncoder.getDistance();
	
		SmartDashboard.putNumber("FL EncoderVal", frontLeftEncoder.getDistance());
		SmartDashboard.putNumber("RL EncoderVal", rearLeftEncoder.getDistance());
		SmartDashboard.putNumber("FR EncoderVal", frontRightEncoder.getDistance());
		SmartDashboard.putNumber("RR EncoderVal", rearRightEncoder.getDistance());
	}
	
	public void resetEncoders() {
		frontLeftEncoder.reset();
		rearLeftEncoder.reset();
		frontRightEncoder.reset();
		rearRightEncoder.reset();
	}
	
	public void mechanumDrive(Joystick joystick1, Joystick joystick2) {
		 
	}
	
	//One joystick controls Y and X motion
	public void ONE_arcadeDrive(Joystick ONE_Stick) {
		//rDrive.arcadeDrive(ONE_Stick);
		
	}
	//FIXME: x + r + y can be more or less than -1 and 1
	public void mecanumRobotCentric(double x , double r, double y) {
		double flp = y - x - r;
		double frp = y + x + r;
		double rlp = y + x - r;
		double rrp = y - x + r;
	
		setSmoothMotorPower(flp, frp, rlp, rrp);
	}
	
	
	public void setSmoothMotorPower(double flp, double frp, double rlp, double rrp) {
		//Smoothing the movement of the robot
		double smoothFLP = smoothPower(flp, getFLRawMotorPower());
		double smoothFRP = smoothPower(frp, getFRRawMotorPower());
		double smoothRLP = smoothPower(rlp, getRLRawMotorPower());
		double smoothRRP = smoothPower(rrp, getRRRawMotorPower());
	
		
		if (false) {
			SmartDashboard.putNumber("targetFLP", flp);
			SmartDashboard.putNumber("smoothFLP", smoothFLP);
			SmartDashboard.putNumber("targetFRP", frp);
			SmartDashboard.putNumber("currentFLP", frontLeft.get());
			SmartDashboard.putNumber("currentFRP", frontRight.get());
		}
		//SmartDashboard.putNumber("smoothRLP", rlp);
		//SmartDashboard.putNumber("smoothRRP", rrp);
		
		setRawMotorPower(smoothFLP, smoothFRP, smoothRLP, smoothRRP);
	}
	
	public double smoothPower(double target, double current) {
		// Takes in current motor power and sets it to a new current using smoothing 
		// variable
		final double smoothingVarAcc = 0.25;
		final double smoothingVarDec = 0.50; // slow down faster than we speed up
		double smoothingVar = (target > current) ? smoothingVarAcc : smoothingVarDec;
		double tolerance = 0.01;
		
		
			if(Math.abs(target - current) < tolerance) {
				return target;
		
			}else {
				return current + ((target - current) * smoothingVar);
			}
		//return target;
	}
	
	public void setRawMotorPower(double flp, double frp, double rlp, double rrp) {
		//Motors are inverted upon initiation
		
		frontLeft.set(flp * scaleSpeed);
		frontRight.set(frp * scaleSpeed);
		rearLeft.set(rlp * scaleSpeed);
		rearRight.set(rrp * scaleSpeed);
		System.out.println(frontLeft.get());
		SmartDashboard.putNumber("FrontLeft", frontLeft.get());
		SmartDashboard.putNumber("FrontRight", frontRight.get());
		SmartDashboard.putNumber("RearLeft", rearLeft.get());
		SmartDashboard.putNumber("RearRight", rearRight.get());
		putGyroValue();
		
	}
	
	public double getFLRawMotorPower() {
		return frontLeft.get() / scaleSpeed;
	}
	
	public double getFRRawMotorPower() {
		return -1.0 *frontRight.get() / scaleSpeed;
	}
	
	public double getRLRawMotorPower() {
		return  rearLeft.get() / scaleSpeed;
	}
	
	public double getRRRawMotorPower() {
		return -1.0 *rearRight.get() / scaleSpeed;
	}
	
	public void putGyroValue() {
		SmartDashboard.putNumber("Gyro Angle", Robot.gyro.getAngle());
	}
	
	//1st Parameter controls forward/backward motion
	//2nd Parameter controls rotating motion -/+
	public void TWO_arcadeDrive(Joystick Y_Stick, Joystick X_Stick) {
		//rDrive.arcadeDrive(Y_Stick.getY(), X_Stick.getX());
	}
	
    
}
