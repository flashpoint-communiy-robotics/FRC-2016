package robot;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.speedcontroller.TCanSpeedController.TCanSpeedControllerType;
import com.torontocodingcollective.speedcontroller.TPwmSpeedController.TPwmSpeedControllerType;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * <p>
 * This map is intended to define the wiring only. Robot constants should be put
 * in {@link RobotConst}
 */
public class RobotMap {

    // ******************************************
    // Speed Controllers and encoders
    // CAN addresses
    // ******************************************

    public static final int                     CLIMBER_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType CLIMBER_SPEED_CONTROLLER_TYPE;
    public static final int                     CLIMBER_FOLLOWER_SPEED_CONTROLLER_ADDRESS;
    public static final TCanSpeedControllerType CLIMBER_FOLLOWER_SPEED_CONTROLLER_TYPE;
    public static final boolean                 CLIMBER_MOTOR_ISINVERTED;

    // ******************************************
    // PWM addresses
    // ******************************************
    public static final int                     LEFT_DRIVE_PWM_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType LEFT_DRIVE_PWM_SPEED_CONTROLLER_TYPE;
    public static final int                     LEFT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType LEFT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_TYPE;
    public static final boolean                 LEFT_DRIVE_PWM_MOTOR_ISINVERTED;

    public static final int                     RIGHT_DRIVE_PWM_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType RIGHT_DRIVE_PWM_SPEED_CONTROLLER_TYPE;
    public static final int                     RIGHT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType RIGHT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_TYPE;
    public static final boolean                 RIGHT_DRIVE_PWM_MOTOR_ISINVERTED;

    public static final int                     WRIST_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType WRIST_SPEED_CONTROLLER_TYPE;
    public static final boolean                 WRIST_MOTOR_ISINVERTED;

    public static final int                     INNER_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType INNER_SPEED_CONTROLLER_TYPE;
    public static final int                     INNER_FOLLOWER_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType INNER_FOLLOWER_SPEED_CONTROLLER_TYPE;
    public static final boolean                 INNER_MOTOR_ISINVERTED;

    public static final int                    OUTER_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType OUTER_SPEED_CONTROLLER_TYPE;
    public static final int                     OUTER_FOLLOWER_SPEED_CONTROLLER_ADDRESS;
    public static final TPwmSpeedControllerType OUTER_FOLLOWER_SPEED_CONTROLLER_TYPE;
    public static final boolean                 OUTER_MOTOR_ISINVERTED;

    public static final boolean                 BITCH_MOTOR_ISINVERTED;

    // ******************************************
    // Gyro Ports
    // ******************************************

    // ******************************************
    // Pneumatics Ports
    // ******************************************
    public static final int                     SHIFTER_PNEUMATIC_PORT = 0;

    // Initializers if this code will be deployed to more than one
    // robot with different mappings
    static {

        switch (RobotConst.robot) {

        case RobotConst.TEST_ROBOT:
        default:
            // CAN Constants
            // Talon and Victor connected through the CAN Bu

            CLIMBER_SPEED_CONTROLLER_ADDRESS           = 4;
            CLIMBER_SPEED_CONTROLLER_TYPE              = TCanSpeedControllerType.TALON_SRX;
            CLIMBER_FOLLOWER_SPEED_CONTROLLER_ADDRESS  = 5;
            CLIMBER_FOLLOWER_SPEED_CONTROLLER_TYPE     = TCanSpeedControllerType.TALON_SRX;
            CLIMBER_MOTOR_ISINVERTED                   = TConst.NOT_INVERTED;

            // PWM Constants
            // Talon and Victors connected through Pwm
            LEFT_DRIVE_PWM_SPEED_CONTROLLER_ADDRESS           = 3;
            LEFT_DRIVE_PWM_SPEED_CONTROLLER_TYPE              = TPwmSpeedControllerType.VICTOR_SP;
            LEFT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_ADDRESS  = 4;
            LEFT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_TYPE     = TPwmSpeedControllerType.VICTOR_SP;
            LEFT_DRIVE_PWM_MOTOR_ISINVERTED                   = TConst.NOT_INVERTED;

            RIGHT_DRIVE_PWM_SPEED_CONTROLLER_ADDRESS          = 0;
            RIGHT_DRIVE_PWM_SPEED_CONTROLLER_TYPE             = TPwmSpeedControllerType.VICTOR_SP;
            RIGHT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_ADDRESS = 2;
            RIGHT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_TYPE    = TPwmSpeedControllerType.VICTOR_SP;
            RIGHT_DRIVE_PWM_MOTOR_ISINVERTED                  = TConst.INVERTED;

            WRIST_SPEED_CONTROLLER_ADDRESS  = 5;
            WRIST_SPEED_CONTROLLER_TYPE     = TPwmSpeedControllerType.VICTOR_SP;
            WRIST_MOTOR_ISINVERTED          = TConst.NOT_INVERTED;

            INNER_SPEED_CONTROLLER_ADDRESS          = 8;
            INNER_SPEED_CONTROLLER_TYPE             = TPwmSpeedControllerType.VICTOR_SP;
            INNER_FOLLOWER_SPEED_CONTROLLER_ADDRESS = 9;
            INNER_FOLLOWER_SPEED_CONTROLLER_TYPE    = TPwmSpeedControllerType.VICTOR_SP;
            INNER_MOTOR_ISINVERTED                  = TConst.INVERTED;

            OUTER_SPEED_CONTROLLER_ADDRESS          = 6;
            OUTER_SPEED_CONTROLLER_TYPE             = TPwmSpeedControllerType.VICTOR_SP;
            OUTER_FOLLOWER_SPEED_CONTROLLER_ADDRESS          = 7;
            OUTER_FOLLOWER_SPEED_CONTROLLER_TYPE             = TPwmSpeedControllerType.VICTOR_SP;
            OUTER_MOTOR_ISINVERTED                  = TConst.INVERTED;

            BITCH_MOTOR_ISINVERTED                  = TConst.NOT_INVERTED;
        }
    }
}
