package z.OldCode;

/**
 * Strafe (move side-to-side) left (direction=-1) or right (direction=1) at 'speed' for 'time'.
 */
public class StrafeForTime extends MoveForTime {
	int direction;
	
    public StrafeForTime(double time, int direction, double speed) {
        super( time, speed );
    	this.direction = direction;    	
    }

    // Called just before this Command runs the first time
    @Override protected void initialize() {
    	super.initialize();
    	double xVal = direction * speed;
    	driveTrain.mecanumRobotCentric(xVal, 0.0, 0.0);
    }
}

