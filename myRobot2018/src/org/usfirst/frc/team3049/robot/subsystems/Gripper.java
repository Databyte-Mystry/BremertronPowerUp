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
	public Solenoid pusher = new Solenoid(RobotMap.Pusher_Solenoid);//default should be retracted
	public DoubleSolenoid gripper = new DoubleSolenoid(RobotMap.Gripper_SolenoidA, RobotMap.Gripper_SolenoidB);//default should be release
	public void grip(){
		gripper.set(Value.kForward);
    }

    public void release(){ 
    	gripper.set(Value.kReverse);
    }
    
    public void push(boolean pushOn){ 	
    	pusher.set(pushOn);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

