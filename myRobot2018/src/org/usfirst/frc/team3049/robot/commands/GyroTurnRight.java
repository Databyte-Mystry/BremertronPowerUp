package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.ADXRS450_Gyro; //

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurnRight extends Command {
	private static int m_angle;
	private static Drivetrain m_drivetrain = Robot.driveTrain;
	
    public GyroTurnRight(int angle) {//angle increases clockwise. Gyro can go negative
        requires(Robot.driveTrain);
        m_angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_drivetrain.drive(0, 0.5);
    	System.out.println("Gyro Angle: " + Robot.gyro.getAngle());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(Robot.gyro.getAngle() >= m_angle){ //When current angle is equal to or greater than input angle the command stops running
        	return true;
        }
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
