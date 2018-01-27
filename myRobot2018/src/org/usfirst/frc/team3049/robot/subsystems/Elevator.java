package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public static AnalogPotentiometer strPot = new AnalogPotentiometer(RobotMap.String_Potentiometer, 94, 0); //
	private static Spark m_elevatorMotor = new Spark(RobotMap.Elevator_Motor);
	
    public void raise(double speed){
    	m_elevatorMotor.set(speed);
    }
    
    public void lower(double speed){
    	m_elevatorMotor.set(-speed);
    }
    
    public void stop(){
    	m_elevatorMotor.stopMotor();
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

