package org.usfirst.frc.team3049.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Print extends Command {
	private static String m_line;
	private static boolean m_finished = false;
	
	/**
	 * Command that prints a line
	 * @param line String being printed
	 */
    public Print(String line) {
       m_line = line;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(m_line);
    	m_finished = true;
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
