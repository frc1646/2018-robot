package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;
import org.usfirst.frc.team1646.robot.commands.OffSeasonSetElevatorPosition;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorPID extends PIDSubsystem {

	public VictorSP elevatorMotor = new VictorSP(RobotMap.MOTOR_PORT_ELEVATOR_LIFT);
	public Encoder elevatorEncoder;
	public AnalogInput limitSwitch;
	private double raiseElevatorSpeed = 0.8;
	private double lowerElevatorSpeed = 0.8;
	
	public static double kP = SmartDashboard.getNumber("kP", 0.0);
	public static double kI = SmartDashboard.getNumber("kI", 0.0);
	public static double kD = SmartDashboard.getNumber("kD", 0.0);
	
    // Initialize your subsystem here
	
	double fakePIDInput = 0;
	double velocity = 0;
	
    public ElevatorPID() {
    	
    	super(kP,kI,kD);
    	
    	SmartDashboard.putNumber("kpTest", kP);
    	//elevatorPotentiometer = new AnalogPotentiometer(RobotMap.ELEVATOR_ANALOG_POTENTIOMETER_PORT);
    	elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_CHANNEL_A, RobotMap.ELEVATOR_ENCODER_PORT_CHANNEL_B, false, Encoder.EncodingType.k4X);
    	limitSwitch = new AnalogInput(RobotMap.LIMIT_SWITCH_PORT);
    	enable();//*------*
    	//elevatorPotentiometer = new AnalogPotentiometer(RobotMap.ELEVATOR_ANALOG_POTENTIOMETER_PORT, RobotMap.ELEVATOR_ANALOG_POTENTIOMETER_PORT);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    
    
    
    public void manual_raiseElevator() {
    	elevatorMotor.set(raiseElevatorSpeed * -1);
    	
    	
    	//SmartDashboard.getNumber("PID_POSITION", elevatorEncoder.get());
    	//SmartDashboard.putNumber("PID_POSITION", elevatorEncoder.get());
    }
    
    public void manual_lowerElevator() {
    	elevatorMotor.set(lowerElevatorSpeed);
    	//SmartDashboard.getNumber("PID_POSITION", elevatorEncoder.get());    	
    	//SmartDashboard.putNumber("PID_POSITION", elevatorEncoder.get());
    }
    
    
    public void stopElevator() {
    	elevatorMotor.set(0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected double returnPIDInput() {
    	
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
    	
    	SmartDashboard.putNumber("kpTest2", kP);
    	SmartDashboard.putNumber("PID_POSITION", elevatorEncoder.get());
    	SmartDashboard.putNumber("Set_Point", this.getSetpoint());
    	//System.out.println("                        Current Setpoint:" + this.getSetpoint());
    	SmartDashboard.putNumber("Limit Switch", limitSwitch.getValue());
    	
        return elevatorEncoder.get();
    	
    }

    protected void usePIDOutput(double output) {
   //    elevatorMotor.set(output);
    	SmartDashboard.putNumber("PID Motor Power", output);
    	
    	
        // e.g. yourMotor.set(output);
    }
    
    public void changeSetPoint(double newSetPoint) {
    	if(newSetPoint < RobotMap.maxElevatorHeight && newSetPoint > RobotMap.minElevatorHeight) {
    		setSetpoint(newSetPoint);
    		System.out.println("New Setpoint:" + newSetPoint);
    		//System.out.println(elevatorEncoder.get());
    	} else {System.out.println("Setpoint is outside of allowable range");
    	}
    }
    
    public double getTheSetPoint() {
    	return this.getSetpoint();
    }
    
}
