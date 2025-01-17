package robot.commands.climb;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.commands.TSafeCommand;

import robot.Robot;

/**
 *
 */
public class DefaultClimbCommand extends TSafeCommand {

	private static final String COMMAND_NAME = 
			DefaultClimbCommand.class.getSimpleName();

	public DefaultClimbCommand() {

		super(TConst.NO_COMMAND_TIMEOUT, Robot.oi);

		// Use requires() here to declare subsystem dependencies
        requires(Robot.climbSubsystem);
        
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
        
        
		/**
    	if (Robot.oi.climbUp()) {
            Robot.climbSubsystem.climberIn();
        
        }else if (Robot.oi.climbDown()){
            Robot.climbSubsystem.climberOut();

		}else {
            Robot.climbSubsystem.stopClimbMachine();
        }
	*/	
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

}