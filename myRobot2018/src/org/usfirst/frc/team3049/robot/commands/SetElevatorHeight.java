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
	private static double m_speedDown = 0.1;//Change this number to change the rate of lowering for set heights

	private static Elevator m_elevator;
	
	/**
	 * Command that sets the elevator to a certain Position
	 * <h2>Height Settings:</h2>
	 * 
	 * <ul>
	 * 	<li>0 = Ground</li>
	 *  <li>1 = Exchange</li>
	 *  <li>2 = Portal</li>
	 *  <li>3 = Switch</li>
	 *  <li>4 = Scale</li>
	 *  <li>5 = Climb</li>
	 * </ul>
	 * @param setting Used to set value to desired height
	 */
    public SetElevatorHeight(int setting) { // 0 for Ground, 1 for Carry, 2 for Portal, 3 for Switch, 4 for Scale, 5 for Climb
    	requires(Robot.elevator);
    	m_elevator = Robot.elevator;
    	m_finished = false;
    	m_setting = setting;
    	if (m_setting == 0){//m_distance numbers are PLACEHOLDERS remember to set them to actual values
    		m_target = m_elevator.switchHGround;
    	}else if (m_setting == 1){
    		m_target = m_elevator.switchHCarry;
    	}else if (m_setting == 2){
//    		m_target = Elevator.switchHPortal;
    	}else if (m_setting == 3){
//    		m_target = Elevator.switchHSwitch;
    	}else if (m_setting == 4){
    		m_target = m_elevator.switchHScale;
    	}else if (m_setting == 5){
    		m_target = m_elevator.switchHClimb;
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    	SmartDashboard.putBoolean("m_finished", m_finished);
    	System.out.println("m_setting " + m_setting);
    	switch(m_setting){
    	case 0: //Ground
    		m_elevator.lower(m_speedDown);
    	;
    	
    	case 1: //Carry
    		if(!m_elevator.switchHGround.get()){
    			m_elevator.raise(m_speedUp);
    		}/*else if(Elevator.switchHSwitch.get()){*/
//    			m_elevator.lower(m_speedDown);
    		/*}*/else if(!m_elevator.switchHScale.get()){
    			m_elevator.lower(m_speedDown);
    		}else if(!m_elevator.switchHClimb.get()){
    			m_elevator.lower(m_speedDown);
    		}
    	;
    	
//    	case 2: //Portal
//    		if(Elevator.switchHCarry.get()){
//    			m_elevator.raise(m_speedUp);
//    		}else /*if(Elevator.switchHSwitch.get()){
//    			m_elevator.lower(m_speedDown);
//    		}else */if(Elevator.switchHScale.get()){
//    			m_elevator.lower(m_speedDown);
//    		}else if(Elevator.switchHClimb.get()){
//    			m_elevator.lower(m_speedDown);
//    		}
//    	;
//    	
//    	case 3: //Switch
//    		if(Elevator.switchHCarry.get()){
//    			m_elevator.raise(m_speedUp);
//    		}else /*if(Elevator.switchHPortal.get()){
//    			m_elevator.raise(m_speedUp);
//    		}else */if(Elevator.switchHScale.get()){
//    			m_elevator.lower(m_speedDown);
//    		}else if(Elevator.switchHClimb.get()){
//    			m_elevator.lower(m_speedDown);
//    		}
//    	;
    	
    	case 4: //Scale
    		m_elevator.raise(m_speedUp);
    	;
    	
    	case 5: //Climb
    		if(!m_elevator.switchHCarry.get()){
    			m_elevator.raise(m_speedUp);
    		}else /*if(Elevator.switchHPortal.get()){
    			m_elevator.raise(m_speedUp);
    		}else if(Elevator.switchHSwitch.get()){
    			m_elevator.raise(m_speedUp);
    		}else*/ if(!m_elevator.switchHScale.get()){
    			m_elevator.lower(m_speedDown);
    		}
    	;
    	
    	default: //Debug
    		System.out.println("SetElevatorHeight : Undefined Case");
    	;
    	}
    	SmartDashboard.putBoolean("Ground Switch", m_elevator.switchHGround.get());
    	SmartDashboard.putBoolean("Carry Switch", m_elevator.switchHCarry.get());
    	SmartDashboard.putBoolean("Scale Switch", m_elevator.switchHScale.get());
    	SmartDashboard.putBoolean("Climb Switch", m_elevator.switchHClimb.get());
    	SmartDashboard.putBoolean("Target Switch", m_target.get());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        m_finished = !m_target.get();
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
    	new ElevatorBrake(); 
//    	m_elevator.stop();
    	System.out.println("Interrupted");
    }
}
