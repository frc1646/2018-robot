package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;

//import org.usfirst.frc.team1646.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class IntakeSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public VictorSP rightWheelMotor = new VictorSP(RobotMap.MOTOR_PORT_INTAKE_RIGHT);
	public VictorSP leftWheelMotor = new VictorSP(RobotMap.MOTOR_PORT_INTAKE_LEFT);
	private final static boolean haveSolenoid = false;
	//public Solenoid catchCube = new Solenoid(RobotMap.SOLENOID_PORT_INTAKE); 
	public DoubleSolenoid intakeSolenoid = new DoubleSolenoid(RobotMap.SOLENOID_PORT_INTAKE_A, RobotMap.SOLENOID_PORT_INTAKE_B);
	public final static boolean haveSensor = false;
	public DigitalInput intakeSensor = haveSensor ? new DigitalInput(RobotMap.INTAKE_SENSOR_PORT) : null;
	public boolean closingIntake = false;
	
	//How much more power to apply to one side than the other?
	private final double LEFT_TO_RIGHT_BIAS = 0.1;
	
	public IntakeSubsystem() {
		leftWheelMotor.setInverted( false );
		rightWheelMotor.setInverted( true );
	}
	
	public void open() {
      //   catchCube.set(false);
         intakeSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void close() {
		//catchCube.set(true);
		intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void stopIntakeSolenoid() {
		intakeSolenoid.set(DoubleSolenoid.Value.kOff);
	}
	
	public void takeInCube(double speed) {
		//This method intakes the cube
		assert speed > 0;
		setIntakeSpeed(speed, /*in=*/true , LEFT_TO_RIGHT_BIAS);
		/*if( haveSolenoid ) {
		    catchCube.set(true);
		}*/
	}
	
	public void ejectCube(double speed) {
		//This method expels cube
		assert speed > 0;
		setIntakeSpeed(speed, /*in=*/false, /*BIAS=*/0.0);
		/*if( haveSolenoid ) {
		    catchCube.set(false);
		}*/
	}
	
	//Since the intake will be upright when the match starts, this code will change the upright intakePosition to be 
	//parallel with the ground surface
	public void deployIntake() {
		
	}
	
	
	//this might be necessary or no depending on what methods will be used to bring down the intake
	public void stopDeployIntake() {
		
	}
	
	public void setIntakeSpeed(double speed, boolean in, double wheelBias) {
		
		//This method sets the speed of both motors
		//Wheel bias makes one wheel spin faster than the other allowing for better intake
		assert wheelBias/2 < speed;
		rightWheelMotor.set((speed - wheelBias/2) * (in ? RobotMap.MOTOR_INTAKE_CUBE_IN_POLARITY : RobotMap.MOTOR_INTAKE_CUBE_OUT_POLARITY));
		leftWheelMotor.set((speed + wheelBias/2) * (in ? RobotMap.MOTOR_INTAKE_CUBE_IN_POLARITY : RobotMap.MOTOR_INTAKE_CUBE_OUT_POLARITY));
		
	}
	
	public void stopIntake() {
		//This method stops wheels on intake
		setIntakeSpeed(/*speed=*/0.0, /*in=*/true,/*wheelBias=*/ 0.0);
	}
	
	public boolean isCubeIn() {
		//TODO: remove this VVVV
		//FIXME: This doesn't do anything
		return false && intakeSensor.get();
	}
	
    public void initDefaultCommand() {	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

