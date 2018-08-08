package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {

	//IFFY ABOUT THE DEVICE NUMBER THAT GOES IN FOR NEW WPI_TALONSRX(INT DEVICENUMBER)
	//public WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(1);
    public VictorSP elevatorMotor = new VictorSP(RobotMap.MOTOR_PORT_ELEVATOR_LIFT);
    //public Encoder elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_CHANNEL_A,RobotMap.ELEVATOR_ENCODER_PORT_CHANNEL_B);
	// Put methods for controlling this subsystem;
    // here. Call these from Commands.

	public void controlElevator(double speed) {
		elevatorMotor.set(speed);
	}
	
	public void raiseElevator(double speed) {
		elevatorMotor.set(speed);
	}
	
	public void lowerElevator(double speed) {
		elevatorMotor.set(speed);
	}
	
	public void stopElevator() {
		elevatorMotor.set(0);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

