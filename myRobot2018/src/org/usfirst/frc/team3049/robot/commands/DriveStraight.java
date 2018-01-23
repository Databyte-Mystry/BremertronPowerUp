package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3049.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	private static Drivetrain m_drivetrain;
	private static double m_time;
	private static double m_speed;
    
	public DriveStraight(double time, double speed) {
		super();
		requires(Robot.driveTrain);
		m_drivetrain = Robot.driveTrain;
		m_time = time;
		m_speed = speed;
		
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_drivetrain.drive(-m_speed, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	timeSinceInitialized();
    	setTimeout(m_time);
    	if(isTimedOut()){
    		return true;
    	};
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
