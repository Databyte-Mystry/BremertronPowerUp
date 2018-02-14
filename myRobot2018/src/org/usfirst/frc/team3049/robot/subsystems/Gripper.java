package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	public Solenoid gripper = new Solenoid(RobotMap.Gripper_Solenoid);//default should be release
//	public Solenoid pusher = new Solenoid(RobotMap.Pusher_Solenoid );//default should be retracted
	public DoubleSolenoid pusher = new DoubleSolenoid(RobotMap.Pusher_Solenoid, 3);//default should be retracted
	public void grip(){
    	gripper.set(true);
    }

    public void release(){ 
    	gripper.set(false);
    }
    
    public void push(boolean pushOn){ 
    	if (pushOn){
    		pusher.set(Value.kForward);
    	}else if (!pushOn){
    		pusher.set(Value.kReverse);
    	} else {
    		pusher.set(Value.kOff);
    	}
    	
//    	pusher.set(pushOn);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

