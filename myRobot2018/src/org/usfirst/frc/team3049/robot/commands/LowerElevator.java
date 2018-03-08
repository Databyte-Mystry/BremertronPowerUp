package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerElevator extends Command {
	private static Elevator m_elevator;
	private boolean m_finished = false;
    public LowerElevator() {
       requires(Robot.elevator);
       m_elevator = Robot.elevator;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_elevator.lower();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       if(Elevator.m_elevatorMotors.get() <= 0 || !m_elevator.switchHGround.get()){
    	   System.out.println("");
    	   return true;
       }else{
    	   return false;
       }
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Ended");
    	m_elevator.stop();
    	
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	m_elevator.stop();
    }
}
