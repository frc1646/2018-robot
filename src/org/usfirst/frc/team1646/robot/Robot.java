
package org.usfirst.frc.team1646.robot;

import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team1646.robot.commands.AutoAnyMovementTimed;
import org.usfirst.frc.team1646.robot.commands.EjectCube;
import org.usfirst.frc.team1646.robot.commands.EjectCubeTimed;
import org.usfirst.frc.team1646.robot.commands.OffSeasonAutoAngleAdjust;
import org.usfirst.frc.team1646.robot.commands.OffSeasonAutoEject;
import org.usfirst.frc.team1646.robot.commands.OffSeasonAutoIntake;
import org.usfirst.frc.team1646.robot.commands.OffSeasonAutoRotateLeft;
import org.usfirst.frc.team1646.robot.commands.OffSeasonAutoStrafeLeft;
import org.usfirst.frc.team1646.robot.commands.OffSeasonDriveForwardForTime;
import org.usfirst.frc.team1646.robot.commands.RaiseElevatorTimed;
import org.usfirst.frc.team1646.robot.commands.SimplePlacement;
import org.usfirst.frc.team1646.robot.commands.test;
import org.usfirst.frc.team1646.robot.commands.test1;
import org.usfirst.frc.team1646.robot.subsystems.CameraSubsystem;
import org.usfirst.frc.team1646.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team1646.robot.subsystems.ElevatorPID;
//import org.usfirst.frc.team1646.robot.subsystems.ElevatorPIDSubsystem;
//import org.usfirst.frc.team1646.robot.subsystems.GripPipeline;
import org.usfirst.frc.team1646.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team1646.robot.subsystems.PneumaticElevator;
import org.usfirst.frc.team1646.robot.subsystems.ElevatorSubsystem;
//import org.usfirst.frc.team1646.testingCommands.AutoIntake;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;
import z.OldCode.AutoDriveForwardForTime;
import z.OldCode.AutoEjectCubeForTime;
import z.OldCode.DriveForwardForTime;
import z.OldCode.EjectCubeForTime;
import z.OldCode.GoForward;
import z.OldCode.RotateForTime;
import z.OldCode.SetIntakeHeight;
import edu.wpi.first.wpilibj.CameraServer;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi = new OI();
	
	public static PGJoystick driverController = new PGJoystick(oi.driverController);
	public static PGJoystick operatorController = new PGJoystick(oi.operatorController);
	
	public static DriveTrainSubsystem driveTrain = new DriveTrainSubsystem();
	public static IntakeSubsystem intake = new IntakeSubsystem();
	public static PneumaticElevator pneumaticElevator = new PneumaticElevator();
	//public static ElevatorPIDSubsystem elevatorPIDSubsystem;
	//public static CameraSubsystem camera = new CameraSubsystem();
	//Old elevator subsystem without PID
	//public static ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
	//New elevator subsystem with PID
	public static ElevatorPID elevator;

	//private static final PowerDistributionPanel pdp = new PowerDistributionPanel();
	private static final double maxBatteryVoltage = 13.2; // at full charge, no load
	// We only use steadyPower during autonomous, which is the beginning of a match, so we can
	// assume that we started with a near-full battery (let's hope!).  The robot can probably
	// function from a lower voltage than this, but we would give up some speed (in auton) by
	// allowing for that.
	private static final double minBatteryVoltage = 11; // worst-case usable, under load

	
	public static int ourSwitchPosition;
	public static final String SD_ROBOT_POSITION_LABEL = "Robot Position";
	public static final String SD_FW_TIME_1_LABEL = "Forward Time 1";
	public static final String SD_FW_SPEED_1_LABEL = "Forward Speed 1";
	public static final String SD_STRAFE_TIME_SHORT_LABEL = "Strafe Time Short";
	public static final String SD_STRAFE_TIME_LONG_LABEL = "Strafe Time Long";
	public static final String SD_FW_TIME_2_LABEL = "Forward Time 2";
	public static final String SD_FW_SPEED_2_LABEL = "Forward Speed 2";
	public static final String SD_STRAFE_SPEED_LABEL = "Strafe Speed";
	
    public enum AutonStrategy {
    	DriveForward,
    	LL,
    	RR,
    	ML,
    	MR
    }
    public static AutonStrategy autonStrategy;
	Command autonomousCommand;
    SendableChooser<AutonStrategy> chooser = new SendableChooser<>();
	
	//CameraServer cameraServer = CameraServer.getInstance();
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	//public static Encoder elevatorEncoder = new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_CHANNEL_A, RobotMap.ELEVATOR_ENCODER_PORT_CHANNEL_B, false, );
	/* Vision Stuff */
	/*	NetworkTable cubeContour;
	VisionThread visionThread;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		/*if (cameraServer != null) {
			cameraServer.startAutomaticCapture();
		}*/
		SmartDashboard.putNumber("kP", RobotMap.kP);
		SmartDashboard.putNumber("kI", RobotMap.kI);
		SmartDashboard.putNumber("kD", RobotMap.kD);
		elevator = new ElevatorPID();
		SmartDashboard.putNumber("Encoder Count", Robot.elevator.elevatorEncoder.get());
		
		gyro.calibrate();


		oi.initCommands();

		
		SmartDashboard.putNumber(SD_ROBOT_POSITION_LABEL, -1);
		SmartDashboard.putNumber(SD_FW_TIME_1_LABEL, 1000);
		SmartDashboard.putNumber(SD_FW_SPEED_1_LABEL, 0.5);
		SmartDashboard.putNumber(SD_FW_TIME_2_LABEL, 2000);
		SmartDashboard.putNumber(SD_FW_SPEED_2_LABEL, 0.5);
		SmartDashboard.putNumber(SD_STRAFE_TIME_SHORT_LABEL, 500);
		SmartDashboard.putNumber(SD_STRAFE_TIME_LONG_LABEL, 1500);
		SmartDashboard.putNumber(SD_STRAFE_SPEED_LABEL, 0.5);

		//SmartDashboard.putString("Auton Strategy", " ");
		
		chooser.setName("Auton Strategy");
		
		
		chooser.addObject("DriveForward", AutonStrategy.DriveForward);
		chooser.addObject("LeftPosLeftSwitch", AutonStrategy.LL);
		chooser.addObject("RightPosRightSwitch", AutonStrategy.RR);
		chooser.addObject("MiddlePosLeftSwitch", AutonStrategy.ML);
		chooser.addObject("MiddlePosRightSwitch", AutonStrategy.MR);
		
		SmartDashboard.putData("Auton Strategy", chooser);
		SmartDashboard.updateValues();
		/*UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();

		visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
			if (!pipeline.findContoursOutput().isEmpty()) {
			}
		});
		cubeContour = NetworkTable.getTable("GRIP/cubeContour");
		//double cameraResHoriz = 720;
    	double[] defaults = new double[0]; 
    	double[] center_x_array = cubeContour.getNumberArray("centerX", defaults);

    	if (cubeContour.isConnected()) {
    		System.out.println("IsConnected");
    	}
    //	double centerX = center_x_array[0] - cameraResHoriz/2;

    	while(true) {
    	System.out.println("X_length = " + center_x_array.length);
    	int i;
    	for(i = 0; i < center_x_array.length; ++i) {
    		System.out.println(i + ": "+ center_x_array[i]);
    		}
    	}
		 */		
		//elevatorPIDSubsystem = new ElevatorPIDSubsystem();
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", chooser);
		//SmartDashboard.putString("Status", "Bottom of robot init");
		//oi.setControllerAxis();
		//driveTrain.mecanumRobotCentric(.20, 0, 0);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		String fieldSetUp = DriverStation.getInstance().getGameSpecificMessage();
		SmartDashboard.putString("fieldSetUp", fieldSetUp);
		
		new AutoAnyMovementTimed(0, 0, 0.5, 2.5).start();
		//new SimplePlacement().start();
		//new EjectCubeTimed(0.8, 1.0).start();
		
		//Robot: Left Switch: Left
		/*if (fieldSetUp.charAt(0) == 'L') {
			new SimplePlacement().start();
		} else if (fieldSetUp.charAt(0) == 'R') {
			new AutoAnyMovementTimed(0, 0, 0.5, 2.0).start();
		}*/
		/*
		//Robot: Right, Switch: Right
		if (fieldSetUp.charAt(0) == 'R') {
			new SimplePlacement().start();
		} else {
			new AutoAnyMovementTimed(0, 0, 0.5, 1.0);
		}
		
		//Robot: Middle, Switch: Left
		if (fieldSetUp.charAt(0) == 'L') {
			new AutoAnyMovementTimed(-0.5, 0, 0.5, 1.0);
		} else if (fieldSetUp.charAt(0) == 'R') {
			new AutoAnyMovementTimed(-0.5, 0, 0.5, 1.0);
		} else {
			new AutoAnyMovementTimed(0, 0, 0.5, 1.0);
		}
		
		
		if (chooser.getSelected() == AutonStrategy.DriveForward) {
			new AutoAnyMovementTimed(0, 0, 0.5, 1.0).start();
		} else if (chooser.getSelected() == AutonStrategy.LL){
			new SimplePlacement().start();
		} else if (chooser.getSelected() == AutonStrategy.RR) {
			new SimplePlacement().start();
		} else if (chooser.getSelected() == AutonStrategy.ML) {
			new AutoAnyMovementTimed(-0.5, 0, 0.5, 1.0).start();
		} else if (chooser.getSelected() == AutonStrategy.MR) {
			new AutoAnyMovementTimed(0.5, 0, 0.5, 1.0).start();
		} else {
			new AutoAnyMovementTimed(0, 0, 0.5, 1.0).start();
		}
		
		
		*/
		//new SimplePlacement().start();
		
		
		
		
	     
		//new test1().start();
		//new OffSeasonDriveForwardForTime(2.0, 5).start();
		//new test().start();
		//new OffSeasonAutoRotateLeft(3.0, 3).start();
		//System.out.println("Started");
		//new OffSeasonAutoAngleAdjust(1.0, 360).start();
		//System.out.println("IsFinished");
		//new WaitCommand(2);
	//new OffSeasonAutoAngleAdjust(3.0, -90).start();
		/*if (fieldSetUp.charAt(0) == 'R') {
			
			
			//new AutoEjectCubeForTime().start();
			//new AutoDriveForwardForTime().start();
		}
		//new AutoDriveForwardForTime().start();
		*/
		
		
		
		//gyro.reset(); // this defines the current (i.e., initial) orientation as 0

		/*final boolean TEST_NOT_COMPETITION = false;
		if( TEST_NOT_COMPETITION ) {
			String fieldSetUp = DriverStation.getInstance().getGameSpecificMessage();
			SmartDashboard.putString( "fieldSetUp",  fieldSetUp);

			if (fieldSetUp.charAt(0) == 'L') {
				ourSwitchPosition = 0;
			} else if(fieldSetUp.charAt(0) == 'R') {
				ourSwitchPosition = 2;
			} else {
				assert false : "Bad fieldSetUp"; 
			}
			final boolean CHOOSER_WORKS = false;
			if( CHOOSER_WORKS ) {
				Robot.AutonStrategy autonStrategy = chooser.getSelected();
				autonStrategy = Robot.AutonStrategy.Switch;
				switch (autonStrategy) {
				case DriveForward:
					new DriveForwardForTime( 6000, 1.0 ).start();
					break;
				case Switch:
					new AutoSwitch().start();
					break;
				}
			} else {
				new AutoSwitch().start(); // hard-wired
			}
		} else {
			new AutoDriveForwardForTime().start();
		}		*/
		//new AutoSwitch2(/*forwardSpeed=*/0.8, /*strafeSpeed=*/0.8).start();
	}

	
	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	// Return a power value proportional to 'requestedPower' that is independent of the current
	// battery voltage.  This allows autonomous dead reckoning operations to unaffected by
	// battery sag, at the expense of giving up some maximum speed.
	/*public static double steadyPower( double requestedPower ) {
		// 'requestedPower' is [-1...1], but we can only steady part of that range, based on
		// how much battery "head room" we have.
		double scaledPower = requestedPower * minBatteryVoltage / maxBatteryVoltage;
		return scaledPower * maxBatteryVoltage / pdp.getVoltage(); 
	}
*/

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	} 

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
