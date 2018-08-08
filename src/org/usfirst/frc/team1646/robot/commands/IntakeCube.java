package org.usfirst.frc.team1646.robot.commands;

import org.usfirst.frc.team1646.robot.Robot;
import org.usfirst.frc.team1646.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *	Take in the cube until it is in or time runs out
 */
public final class IntakeCube extends Command {

	private final static double MOTOR_INTAKE_POWER = 0.95;
	private IntakeSubsystem intake = Robot.intake;
	//private double solenoidStartTime;

	//private double stoppingDelay = 0.5;
	public IntakeCube() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(intake);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//intake.open();
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		intake.takeInCube(MOTOR_INTAKE_POWER);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		intake.stopIntake();
		//intake.close();
		
		
		//new WaitCommand(stoppingDelay).start();
		//intake.stopIntake();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		intake.stopIntake();
		//intake.stopIntake();
	}
}
