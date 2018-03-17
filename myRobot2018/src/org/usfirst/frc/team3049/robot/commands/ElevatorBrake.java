package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorBrake extends Command {
	private static Elevator m_elevator;
//	private static Encoder m_encoderE = Elevator.m_encoderElevator;
	private double m_speed;
	
    public ElevatorBrake() {
        requires(Robot.elevator);
        m_elevator = Robot.elevator;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	m_encoderE.setDistancePerPulse(0.25); // distance is in degrees per pulse
//     	m_encoderE.setMaxPeriod(0.1);
    	m_speed = Elevator.m_elevatorMotor.get();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if(!m_encoderE.getStopped()){
//    		System.out.println("Elevator Not Stopped");
//    		m_elevator.lower();
////    		if(m_encoderE.getDirection()){
////    			m_elevator.lower(m_speed);
////    			m_speed =+ 0.05;
////    		}else {
////    			m_elevator.raise(m_speed);
////    			m_speed =+ 0.05;
////    		}
//    	}else{
//    		System.out.println("Elevator Stopped");
//    	}
    	m_elevator.lower();
    	System.out.println("Braking");
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return m_elevator.switchHTop.get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Braking Finished");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("Braking Interrupted");
    }
}
