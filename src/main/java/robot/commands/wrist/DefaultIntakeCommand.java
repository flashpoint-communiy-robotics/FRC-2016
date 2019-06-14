package robot.commands.wrist;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.commands.TSafeCommand;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.command.WaitCommand;
import robot.Robot;

/**
 *
 */
public class DefaultIntakeCommand extends TSafeCommand {

	private static final String COMMAND_NAME = 
			DefaultIntakeCommand.class.getSimpleName();

	public DefaultIntakeCommand() {

		super(TConst.NO_COMMAND_TIMEOUT, Robot.oi);

		// Use requires() here to declare subsystem dependencies
        requires(Robot.wristSubsystem);
        
	}

	@Override
	protected String getCommandName() { return COMMAND_NAME; }

	@Override
	protected String getParmDesc() { 
		return super.getParmDesc(); 
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		// Print the command parameters if this is the current
		// called command (it was not sub-classed)
		if (getCommandName().equals(COMMAND_NAME)) {
			logMessage(getParmDesc() + " starting");
		}
	}
            int intakePos = 1;
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
        
        

    	if (Robot.oi.ballIntake()) {
            Robot.wristSubsystem.fwdIntake();
        
        }else if (Robot.oi.ballOuttake()){
            Robot.wristSubsystem.bkdIntake();

		}else if (Robot.oi.ballShoot()) {
            Robot.wristSubsystem.spinBall();
            Timer.delay(1.3);
            Robot.wristSubsystem.feedBall();
            
		}else {
            Robot.wristSubsystem.stopIntake();
        }
        
        if(Robot.oi.clawUp()) {
            if (intakePos!=1){
            Robot.wristSubsystem.clawUp();
            Timer.delay(.8);
            Robot.wristSubsystem.clawStop();
            intakePos = 1;
            }

		}else if (Robot.oi.clawDown()) {
            if (intakePos!=2){
            Robot.wristSubsystem.clawDown();
            Timer.delay(.8);
            Robot.wristSubsystem.clawStop();
            intakePos = 2;
            }

        }else if (Robot.oi.clawMid()) {
            if (intakePos!=3){
            Robot.wristSubsystem.clawDown();
            Timer.delay(.4);
            Robot.wristSubsystem.clawStop();
            intakePos = 3;
            }

        }else{
            Robot.wristSubsystem.clawStop();
        }
		
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

}