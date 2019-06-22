package robot.subsystems;

import com.torontocodingcollective.speedcontroller.TCanSpeedController;
import com.torontocodingcollective.subsystem.TSubsystem;

import robot.RobotMap;
import robot.commands.climb.DefaultClimbCommand;

/**
 * Subsystem for arm mechanism.
 * 64 encoder counts per revolution, approx. 10 counts / degree
 * 60 revolutions = 1 full 360 degree arm turn, 1 revolution = 6 degrees
 */

public class ClimberSubsystem extends TSubsystem {

    TCanSpeedController ClimberOne = new TCanSpeedController(
    		RobotMap.CLIMBER_SPEED_CONTROLLER_TYPE,RobotMap.CLIMBER_SPEED_CONTROLLER_ADDRESS, RobotMap.CLIMBER_MOTOR_ISINVERTED);
    TCanSpeedController ClimberTwo = new TCanSpeedController(
    		RobotMap.CLIMBER_FOLLOWER_SPEED_CONTROLLER_TYPE,RobotMap.CLIMBER_FOLLOWER_SPEED_CONTROLLER_ADDRESS, RobotMap.CLIMBER_MOTOR_ISINVERTED);
    
    @Override
    public void init() {
    };

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultClimbCommand());
    }	
    
    public void climberIn() {
    	ClimberOne.set(1);
        ClimberTwo.set(1);
    }

    public void climberOut() {
    	ClimberOne.set(-1);
        ClimberTwo.set(-1);
    }
    
    public void stopClimbMachine() {
    	ClimberOne.set(0);
        ClimberTwo.set(0);
    }

    // Periodically update the dashboard and any PIDs or sensors
    @Override
    public void updatePeriodic() {

    	// Monitor for limits
    	// This is done in case a command starts the motor and 
    	// does not update the motor speed at the end of the command
    	
    	}
    
    }


