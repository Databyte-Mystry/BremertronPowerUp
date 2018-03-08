package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.subsystems.Elevator;
import org.usfirst.frc.team3049.robot.subsystems.Gripper;
import org.usfirst.frc.team3049.robot.commands.ElevatorBrake;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SetElevatorHeight extends Command {
	private DigitalInput m_target;
	private int m_setting = 0;
	private boolean m_finished;
	private static double m_speedUp = 0.3;//Change this number to change the rate of raising for set heights
	private static Elevator m_elevator;
	
	/**
	 * Command that sets the elevator to a certain Position
	 * <h2>Height Settings:</h2>
	 * 
	 * <ul>
	 * 	<li>0 = Ground</li>
	 *  <li>1 = Top</li>
	 *  <li>2 = Carry</li>
	 * </ul>
	 * @param setting Used to set value to desired height
	 */
    public SetElevatorHeight(int setting) { // 0 for Ground, 2 for Carry, 1 for Top
    	requires(Robot.elevator);
    	m_elevator = Robot.elevator;
    	m_finished = false;
    	m_setting = setting;
    	if (m_setting == 0){
    		m_target = m_elevator.switchHGround;
    	}else if (m_setting == 1){
    		m_target = m_elevator.switchHTop;
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    	SmartDashboard.putBoolean("m_finished", m_finished);
    	System.out.println("m_setting " + m_setting);
    	if(m_setting == 0){
    		m_elevator.raise(m_speedUp);
    	}else if(m_setting == 1){
    		m_elevator.lower();
    	}else if(m_setting == 2){
    		Elevator.m_elevatorMotors.set(0.02);
    		m_finished = true;
    	}else{
    		System.out.println("Set Elevator Height : Invalid Setting");
    	}
    	
    	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(m_target != null){
        	m_finished = m_target.get();
        }
    	return m_finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Starting Finish");
    	new ElevatorBrake();
//    	m_elevator.stop();
    	System.out.println("Finished Ending");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	new ElevatorBrake(); 
//    	m_elevator.stop();
    	System.out.println("Interrupted");
    }
}
