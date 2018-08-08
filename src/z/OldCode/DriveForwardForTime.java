package z.OldCode;

/**
 * Drive robot-forward at 'speed' for time 'time'.
 */
public final class DriveForwardForTime extends MoveForTime {	
    public DriveForwardForTime(double time, double speed) {
        super( time, speed );
    }
    
    
    // Called just before thisCommand runs the first time
    protected void initialize() {
    	super.initialize();
    	
    	driveTrain.mecanumRobotCentric(0.0, 0.0, speed);
    	
    }
}
