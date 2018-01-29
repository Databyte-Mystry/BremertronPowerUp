package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Gripper;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GripperControl extends Command {
	private int m_input = 0;
	private static Gripper m_pneumatics;
	private static boolean m_finished = false;
	
    public GripperControl(int input) { // input should be true to close gripper
       requires(Robot.pneumatics);
       m_pneumatics = Robot.pneumatics;
       m_input = input;
       System.out.println(m_input);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	 if (m_input == 1) { // true tells gripper to close
         	m_pneumatics.grip();
         	System.out.println("Grip!");
         	m_finished = true;
         } else if (m_input == 2){
         	m_pneumatics.release();
         	System.out.println("Release!");
         	m_finished = true;
         }
    	 
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
