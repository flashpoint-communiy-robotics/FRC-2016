package robot.subsystems;

import com.torontocodingcollective.speedcontroller.TPwmSpeedController;
import com.torontocodingcollective.speedcontroller.TCanSpeedController;
import com.torontocodingcollective.subsystem.TSubsystem;

import robot.RobotMap;
import robot.commands.wrist.DefaultIntakeCommand;

/**
 * Subsystem for arm mechanism.
 * 64 encoder counts per revolution, approx. 10 counts / degree
 * 60 revolutions = 1 full 360 degree arm turn, 1 revolution = 6 degrees
 */

public class WristSubsystem extends TSubsystem {

    TPwmSpeedController innerIntakeMotor = new TPwmSpeedController(
    		RobotMap.INNER_SPEED_CONTROLLER_TYPE,RobotMap.INNER_SPEED_CONTROLLER_ADDRESS, RobotMap.INNER_MOTOR_ISINVERTED);
    TPwmSpeedController outerIntakeMotor = new TPwmSpeedController(
    		RobotMap.OUTER_SPEED_CONTROLLER_TYPE,RobotMap.OUTER_SPEED_CONTROLLER_ADDRESS, RobotMap.OUTER_MOTOR_ISINVERTED);
    TPwmSpeedController outerSideIntakeMotor = new TPwmSpeedController(
            RobotMap.OUTER_FOLLOWER_SPEED_CONTROLLER_TYPE,RobotMap.OUTER_FOLLOWER_SPEED_CONTROLLER_ADDRESS, RobotMap.OUTER_MOTOR_ISINVERTED);
    TPwmSpeedController innerSideIntakeMotor = new TPwmSpeedController(
            RobotMap.INNER_FOLLOWER_SPEED_CONTROLLER_TYPE,RobotMap.INNER_FOLLOWER_SPEED_CONTROLLER_ADDRESS, RobotMap.INNER_MOTOR_ISINVERTED);
        

	TCanSpeedController wristMotor = new TCanSpeedController(
    		RobotMap.WRIST_SPEED_CONTROLLER_TYPE,RobotMap.WRIST_SPEED_CONTROLLER_ADDRESS, RobotMap.WRIST_MOTOR_ISINVERTED);

    
    @Override
    public void init() {
    };

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DefaultIntakeCommand());
    }	
    
    public void fwdIntake() {
    	innerIntakeMotor.set(1);
        outerIntakeMotor.set(1);
        innerSideIntakeMotor.set(1);
        outerSideIntakeMotor.set(-1);
    }

    public void bkdIntake() {
    	innerIntakeMotor.set(-1);
        outerIntakeMotor.set(-1);
        innerSideIntakeMotor.set(-1);
        outerSideIntakeMotor.set(1);
    }
    
    public void stopIntake() {
    	innerIntakeMotor.set(0);
        outerIntakeMotor.set(0);
        innerSideIntakeMotor.set(0);
        outerSideIntakeMotor.set(0);
    }
    
    public void feedBall() {
        innerIntakeMotor.set(-1);
        innerSideIntakeMotor.set(-1);
    }

    public void spinBall() {
        outerIntakeMotor.set(-1);
        outerSideIntakeMotor.set(1);
    }

    public void spitBall() {
        outerIntakeMotor.set(-0.7);
        innerIntakeMotor.set(-0.7);
        outerSideIntakeMotor.set(0.7);
        innerSideIntakeMotor.set(-0.7);
    }

	public void clawUp(){
		wristMotor.set(1);
    }
    
    public void clawDown(){
		wristMotor.set(-1);
    }
    
    public void clawStop(){
		wristMotor.set(0);
	}


    // Periodically update the dashboard and any PIDs or sensors
    @Override
    public void updatePeriodic() {

    	// Monitor for limits
    	// This is done in case a command starts the motor and 
    	// does not update the motor speed at the end of the command
    	
    	}
    
    }


