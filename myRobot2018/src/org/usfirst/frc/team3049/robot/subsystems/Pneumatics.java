package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {
	public Solenoid gripper = new Solenoid(RobotMap.Gripper_Solenoid);//default should be release
	public Solenoid pusher = new Solenoid(RobotMap.Pusher_Solenoid);//default should be retracted
	public Solenoid liftBrake = new Solenoid(RobotMap.Brake_Solenoid);//default should be braked
	
    public void grip(){
    	gripper.set(true);
    }

    public void release(){ 
    	gripper.set(false);
    }
    
    public void push(boolean pushOn){ 
    	pusher.set(pushOn);
    }
    public void brake(boolean state){ 
    	liftBrake.set(!state);
    	
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

