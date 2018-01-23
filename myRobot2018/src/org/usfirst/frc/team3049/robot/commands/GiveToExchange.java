package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GiveToExchange extends Command {
	private static Pneumatics m_pneumatics;
	private static boolean m_finished = false;
	
    public GiveToExchange() {
        requires(Robot.pneumatics);
        m_pneumatics  = Robot.pneumatics;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_pneumatics.push(true); // Extends pusher piston
    	m_pneumatics.release(); // Releases gripper pistons
    	Timer.delay(0.75); // Delays for 0.75 seconds
    	m_pneumatics.push(false); // Retracts pusher piston 
    	m_finished = true; // declares that command is finished
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return m_finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
