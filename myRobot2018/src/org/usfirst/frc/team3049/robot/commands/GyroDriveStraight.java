package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GyroDriveStraight extends Command {
	private static double m_speed;
	private double m_time;
	private double m_turnSpeed = -0.5; // Placeholder number, base turnspeed needs to be determined by testing
	final double Kp = 0.03;
	private static ADXRS450_Gyro m_gyro;
	private static Drivetrain m_drivetrain;
	
    public GyroDriveStraight(double distance, double speed) {
       requires(Robot.driveTrain);
       m_drivetrain = Robot.driveTrain;
       m_time = (distance-4.24)/31.8;
       m_speed = speed;
       m_gyro = Robot.gyro;
       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_gyro.reset();
    	setTimeout(m_time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if(m_gyro.getAngle() > 15){ // is turning right
//    		m_turnSpeed =+ -0.05;
////    		m_drivetrain.drive(0, -0.35);
//    	}else if (m_gyro.getAngle() < -15){ // is turning left
//    		m_turnSpeed =+ 0.05;
////    		m_drivetrain.drive(0, 0.35);
////    	}else {
//    		m_drivetrain.drive(m_speed, m_turnSpeed);
//    	}
    	double m_angle = m_gyro.getAngle();
    	m_drivetrain.drive(m_speed, -m_angle * Kp);
    	Timer.delay(0.01);
    	SmartDashboard.putNumber("Gyro Angle:", m_gyro.getAngle());
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
