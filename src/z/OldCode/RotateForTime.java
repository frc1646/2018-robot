package z.OldCode;

/**
 * Rotate at 'speed' for time 'time'.
 */
public final class RotateForTime extends MoveForTime {	
    public RotateForTime(double time, double speed) {
        super( time, speed );
    }

    // Called just before thisCommand runs the first time
    protected void initialize() {
    	super.initialize();
    	driveTrain.mecanumRobotCentric(/*x=*/0.0, speed, /*y=*/0.0);   	
    }
}
