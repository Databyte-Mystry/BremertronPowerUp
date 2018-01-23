package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	public Solenoid gripper = new Solenoid(RobotMap.Gripper_Solenoid);
	public Solenoid pusher = new Solenoid(RobotMap.Pusher_Solenoid);
	
    public void grip(){
    	gripper.set(true);
    }

    public void release(){
    	gripper.set(false);
    }
    
    public void push(boolean pushOn){
    	pusher.set(pushOn);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

