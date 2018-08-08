package org.usfirst.frc.team1646.robot.subsystems;

import org.usfirst.frc.team1646.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PneumaticElevator extends Subsystem {

	private DoubleSolenoid lift = new DoubleSolenoid(RobotMap.ELEVATOR_LIFT_DOUBLE_SOLENOID_PORT_A, RobotMap.ELEVATOR_LIFT_DOUBLE_SOLENOID_PORT_B);
    private static final boolean UP = false;
    private static final boolean DOWN = !UP;
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void raise() {
		lift.set(DoubleSolenoid.Value.kReverse);
	}
	public void lower() {
		lift.set(DoubleSolenoid.Value.kForward);
	}
	public void stopLift() {
		lift.set(DoubleSolenoid.Value.kOff);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

