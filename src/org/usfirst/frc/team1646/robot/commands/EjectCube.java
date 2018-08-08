package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *	Spits out the cube for a fixed amount of time
 */
public final class EjectCube extends Command {

	IntakeSubsystem intake = Robot.intake;
	private final static double MOTOR_INTAKE_POWER = 0.95;

	public EjectCube() {
		requires(intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//intake.ejectCube(MOTOR_INTAKE_POWER);
	}

	protected void execute() {
		intake.ejectCube(MOTOR_INTAKE_POWER);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Called once after isFinished returns true
	protected void end() {
		intake.stopIntake();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		intake.stopIntake();
	}

	
}
