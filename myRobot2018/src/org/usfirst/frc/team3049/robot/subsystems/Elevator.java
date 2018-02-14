package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public static AnalogPotentiometer strPot = new AnalogPotentiometer(RobotMap.String_Potentiometer, 94, 0); //
	public Solenoid liftBrake = new Solenoid(RobotMap.Brake_Solenoid);//default should be braked
	
	private static Spark m_elevatorMotor = new Spark(RobotMap.Elevator_Motor);
	
    public void raise(double speed){
    	liftBrake.set(false);
    	m_elevatorMotor.set(speed);
    }
    
    public void lower(double speed){
    	liftBrake.set(false);
    	m_elevatorMotor.set(-speed);
    }
    
//    public void brake(boolean state){ 
//    	liftBrake.set(!state);
//    	
//    }
    
    public void stop(){
    	m_elevatorMotor.stopMotor();
    	Timer.delay(0.1);
    	liftBrake.set(true);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

