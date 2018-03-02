package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroDriveStraight extends Command {
	private static double m_speed = 0.5;
	private static double m_time;
	private double m_turnSpeed = 0.1; // Placeholder number, base turnspeed needs to be determined by testing 
	private static ADXRS450_Gyro m_gyro;
	private static Drivetrain m_drivetrain;
	
    public GyroDriveStraight(double time) {
       requires(Robot.driveTrain);
       m_drivetrain = Robot.driveTrain;
       m_time = time;
       m_gyro = Robot.gyro;
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_gyro.reset();
    	setTimeout(m_time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(m_gyro.getAngle() > 0.05){
    		m_turnSpeed =+ -0.01;
    	}else if (m_gyro.getAngle() < -0.05){
    		m_turnSpeed =+ 0.01;
    	}
    	m_drivetrain.drive(m_speed, m_turnSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
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
