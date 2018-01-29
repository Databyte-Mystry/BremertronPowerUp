package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.RobotMap;
import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderDriveStraight extends Command {
	private static Drivetrain m_drivetrain;
	private static Encoder m_encoderL = new Encoder(RobotMap.EncoderL_ChanA, RobotMap.EncoderL_ChanB);
	private static Encoder m_encoderR = new Encoder(RobotMap.EncoderR_ChanA, RobotMap.EncoderR_ChanB);
	private static double m_distance;
	private static int wheelSize = 6; // Wheel Diameter
	private static double m_speed = 0.3;// Speed of 
	
    public EncoderDriveStraight(double distance) {
    	requires(Robot.driveTrain);
    	m_drivetrain = Robot.driveTrain;
    	m_distance = distance;
    	m_encoderL.reset(); // resets both encoders to 0
    	m_encoderR.reset();
    	m_encoderL.setDistancePerPulse((3.14*wheelSize)/360); //sets how far the robot has traveled each time a pulse is recieved
    	m_encoderR.setDistancePerPulse((3.14*wheelSize)/360);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_drivetrain.drive(m_speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (m_encoderL.getDistance() == m_distance && m_encoderR.getDistance() == m_distance){
        	return true;
        }else{
        	return false;
        }	
    }

    // Called once after isFinished returns true
    protected void end() {
    	m_drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	m_drivetrain.stop();
    }
}
