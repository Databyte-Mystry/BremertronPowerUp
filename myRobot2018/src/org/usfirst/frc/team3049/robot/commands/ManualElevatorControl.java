package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Elevator;
import org.usfirst.frc.team3049.robot.subsystems.Gripper;
import org.usfirst.frc.team3049.robot.commands.ElevatorBrake;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ManualElevatorControl extends Command { // only run as a WhileHeld button type, otherwise it will run forever
	private static Elevator m_elevator;
	private static double m_speedUp = 0.4; //Adjust this to change rate of movement
	private static double m_speedDown = 0.01;
	private boolean m_direction;
	private static Encoder m_encoderE;
	
	/**
	 * Command that Manually Controls the elevator
	 * @param direction Boolean, If true elevator goes up. If false elevator goes down
	 */
    public ManualElevatorControl(boolean direction) {
       requires(Robot.elevator);
       m_elevator = Robot.elevator;
       m_encoderE = Elevator.m_encoderElevator;
       m_direction = direction;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (m_direction == true){
    		m_elevator.raise(m_speedUp);
    	}else if (m_direction == false){
    		m_elevator.lower(m_speedDown);
    	}
    	SmartDashboard.putNumber("Elevator Encoder", m_encoderE.get());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	new ElevatorBrake();
//    	m_elevator.lowerToBottom();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	new ElevatorBrake();
//    	m_elevator.lowerToBottom();
    }
}
