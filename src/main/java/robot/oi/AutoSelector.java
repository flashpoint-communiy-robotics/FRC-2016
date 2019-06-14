package robot.oi;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoSelector {

    public static SendableChooser<String> robotStartPosition;

    public static final String            ROBOT_LEFT   = "Robot Left";
    public static final String            ROBOT_CENTER = "Robot Center";
    public static final String            ROBOT_RIGHT  = "Robot Right";

    public static SendableChooser<String> pattern;

    public static final String            PATTERN_STRAIGHT  = "Straight";
    public static final String            PATTERN_STR_NP    = "Straight No PID";
    public static final String            PATTERN_BOX       = "Box";

    static {

        // Robot Position Options
        robotStartPosition = new SendableChooser<String>();
    

        SmartDashboard.putData("Robot Start", robotStartPosition);

        // Robot Pattern Options
        pattern = new SendableChooser<String>();
        
        SmartDashboard.putData("Auto Pattern", pattern);
    }

    /**
     * Get the auto pattern.
     * 
     * @return "Straight" or "Box"
     */
    public static String getPattern() {

        return pattern.getSelected();
    }
    
    /**
     * Get the robot starting position on the field.
     * 
     * @return 'L' for left, 'R' for right or 'C' for center
     */
    public static String getRobotStartPosition() {

        return robotStartPosition.getSelected();
    }

    public static void init() {}
}
