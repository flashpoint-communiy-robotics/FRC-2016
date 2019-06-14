package robot.subsystems;

import com.torontocodingcollective.speedcontroller.TPwmSpeedController;
import com.torontocodingcollective.subsystem.TDriveSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.RobotMap;
import robot.commands.drive.DefaultDriveCommand;

/**
 * Chassis Subsystem
 * <p>
 * This class is describes all of the components in a differential (left/right)
 * drive subsystem.
 */
public class PwmDriveSubsystem extends TDriveSubsystem {

    private boolean              turboEnabled = false;

    public PwmDriveSubsystem() {

        super(
                // Left Speed Controller
                new TPwmSpeedController(
                        RobotMap.LEFT_DRIVE_PWM_SPEED_CONTROLLER_TYPE,
                        RobotMap.LEFT_DRIVE_PWM_SPEED_CONTROLLER_ADDRESS,
                        RobotMap.LEFT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_TYPE,
                        RobotMap.LEFT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_ADDRESS, 
                        RobotMap.LEFT_DRIVE_PWM_MOTOR_ISINVERTED),

                // Right Speed Controller
                new TPwmSpeedController(
                        RobotMap.RIGHT_DRIVE_PWM_SPEED_CONTROLLER_TYPE,
                        RobotMap.RIGHT_DRIVE_PWM_SPEED_CONTROLLER_ADDRESS,
                        RobotMap.RIGHT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_TYPE,
                        RobotMap.RIGHT_DRIVE_PWM_FOLLOWER_SPEED_CONTROLLER_ADDRESS,
                        RobotMap.RIGHT_DRIVE_PWM_MOTOR_ISINVERTED)
                        );
    }

    @Override
    public void init() {
    }

    // Initialize the default command for the Chassis subsystem.
    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DefaultDriveCommand());
    }

    // ********************************************************************************************************************
    // Turbo routines
    // ********************************************************************************************************************
    public void enableTurbo() {
    }

    public void disableTurbo() {
    }

    public boolean isTurboEnabled() {
        return turboEnabled;
    }

    @Override
    public void updatePeriodic() {
        super.updatePeriodic();

        SmartDashboard.putBoolean("Turbo Enabled", isTurboEnabled());
    }

}
