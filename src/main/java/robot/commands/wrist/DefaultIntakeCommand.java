package robot.commands.wrist;

import com.torontocodingcollective.TConst;
import com.torontocodingcollective.commands.TSafeCommand;

import edu.wpi.first.wpilibj.*;
import robot.Robot;
import robot.subsystems.WristSubsystem;

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

        if(Robot.oi.clawUp()){
            Robot.wristSubsystem.clawUp();
        }else if(Robot.oi.clawDown()){
            Robot.wristSubsystem.clawDown();
        }else{
            Robot.wristSubsystem.clawStop();
        }
        /**
        // Claw Code for Hatch

        // Pos 1 - Claw Stowed
        if(Robot.oi.clawUp()){
            // Stowed Away
            if (intakePos==1){
                Robot.wristSubsystem.clawStop();
            // Straight Up
            }else if(intakePos==2){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.1);
                Robot.wristSubsystem.clawStop();
                intakePos = 1;
            // Out Angle
            }else if(intakePos==3){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.4);
                Robot.wristSubsystem.clawStop();
                intakePos = 1;
            // Full Down
            }else if(intakePos==4){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.8);
                Robot.wristSubsystem.clawStop();
                intakePos = 1;
            }
        
        // Pos 2 - Claw Straight Up
        }else if(Robot.oi.clawStraight()){
            // Stowed Away
            if (intakePos==1){
                Robot.wristSubsystem.clawDown();
                Timer.delay(0.1);
                Robot.wristSubsystem.clawStop();
                intakePos = 2;
            // Straight Up
            }else if(intakePos==2){
                Robot.wristSubsystem.clawStop();
            // Out Angle
            }else if(intakePos==3){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.3);
                Robot.wristSubsystem.clawStop();
                intakePos = 2;
            // Full Down
            }else if(intakePos==4){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.7);
                Robot.wristSubsystem.clawStop();
                intakePos = 2;
            }

        // Pos 3 - Claw Mid
        }else if(Robot.oi.clawMid()){
            // Stowed Away
            if (intakePos==1){
                Robot.wristSubsystem.clawDown();
                Timer.delay(0.4);
                Robot.wristSubsystem.clawStop();
                intakePos = 3;
            // Straight Up
            }else if(intakePos==2){
                Robot.wristSubsystem.clawDown();
                Timer.delay(0.3);
                Robot.wristSubsystem.clawStop();
                intakePos = 3;
            // Out Angle
            }else if(intakePos==3){
                Robot.wristSubsystem.clawStop();
            // Full Down
            }else if(intakePos==4){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.4);
                Robot.wristSubsystem.clawStop();
                intakePos = 3;
            }

        // Pos 4 - Claw Down (Intake Position)
        }else if(Robot.oi.clawUp()){
            // Stowed Away
            if (intakePos==1){
                Robot.wristSubsystem.clawDown();
                Timer.delay(0.8);
                Robot.wristSubsystem.clawStop();
                intakePos = 4;
            // Straight Up
            }else if(intakePos==2){
                Robot.wristSubsystem.clawDown();
                Timer.delay(0.7);
                Robot.wristSubsystem.clawStop();
                intakePos = 4;
            // Out Angle
            }else if(intakePos==3){
                Robot.wristSubsystem.clawDown();
                Timer.delay(0.4);
                Robot.wristSubsystem.clawStop();
                intakePos = 4;
            // Full Down
            }else if(intakePos==4){
                Robot.wristSubsystem.clawStop();
            }

            // No Pos Movement Active
        }else{
            Robot.wristSubsystem.clawStop();
        }
         */
        /**
        // Claw Pos 1
        if(Robot.oi.clawUp()) {
            // Check if Claw is at Mid
            if (intakePos==3){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.4);
                Robot.wristSubsystem.clawStop();
                intakePos = 1;
            // Check if Claw is not at Pos 1
            }else if(intakePos!=1){
                Robot.wristSubsystem.clawUp();
                Timer.delay(.8);
                Robot.wristSubsystem.clawStop(); 
                intakePos=1;    
            }

        // Claw Pos 2
		}else if (Robot.oi.clawDown()) {
            // Check if Claw is at Mid
            if (intakePos==3){
                Robot.wristSubsystem.clawDown();
                Timer.delay(.4);
                Robot.wristSubsystem.clawStop();
                intakePos = 2;

            // Check if Claw is not at Pos 2
            }else if(intakePos!=2){
                Robot.wristSubsystem.clawDown();
                Timer.delay(.8);
                Robot.wristSubsystem.clawStop();
                intakePos = 2; 
            }
        
        // Claw Pos 3
        }else if (Robot.oi.clawMid()) {
            if (intakePos==2){
            Robot.wristSubsystem.clawDown();
            Timer.delay(.4);
            Robot.wristSubsystem.clawStop();
            intakePos = 3;
            }
        
        // Claw Pos 4
        }else if (Robot.oi.ClawStraight()){
            if (intakePos!=4)
        }

        }else{
            Robot.wristSubsystem.clawStop();
        }
		

    */
    }

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

}