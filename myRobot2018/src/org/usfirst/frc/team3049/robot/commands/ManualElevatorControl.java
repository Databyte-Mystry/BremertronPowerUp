package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Elevator;
import org.usfirst.frc.team3049.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualElevatorControl extends Command { // only run as a WhileHeld button type, otherwise it will run forever
	private static Elevator m_elevator;
	private static Pneumatics m_pneumatics;
	private static double m_speed = 0.3; //Adjust this to change rate of movement
	private boolean m_direction;
	
    public ManualElevatorControl(boolean direction) {
       requires(Robot.elevator);
       m_elevator = Robot.elevator;
       m_pneumatics = Robot.pneumatics;
       m_direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_pneumatics.brake(false);
    	if (m_direction == true){
    		m_elevator.raise(m_speed);
    	}else if (m_direction == false){
    		m_elevator.lower(m_speed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	m_elevator.stop();
    	m_pneumatics.brake(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	m_elevator.stop();
    }
}
