package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Pneumatics;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GripperControl extends Command {
	private static boolean m_input;
	private static Pneumatics m_pneumatics;
	private static boolean m_finished = false;
	
    public GripperControl(boolean input) { // input should be true to close gripper
       requires(Robot.pneumatics);
       m_pneumatics = Robot.pneumatics;
       m_input = input;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 if (m_input == true) { // true tells gripper to close
         	m_pneumatics.grip();
         } else if (m_input == false){
         	m_pneumatics.release();
         } else {
        	 System.out.println("Error : GripperControl.java :Input Valid Boolean");
         }
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
