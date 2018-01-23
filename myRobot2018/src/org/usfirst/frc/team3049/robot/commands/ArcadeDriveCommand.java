package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDriveCommand extends Command {

	private Drivetrain m_drivetrain;
	private Joystick m_joystick; 
	
    public ArcadeDriveCommand(Drivetrain drivetrain, Joystick joystick) {
        m_drivetrain = drivetrain;
        m_joystick = joystick;
        requires(m_drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("arcadedrivecommand initalized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_drivetrain.jdrive(m_joystick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	m_drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
