package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public static DigitalInput switchHGround = new DigitalInput(RobotMap.Limit_Switch_Ground);
	public static DigitalInput switchHCarry = new DigitalInput(RobotMap.Magnetic_Switch_Carry); //
	public static DigitalInput switchHPortal = new DigitalInput(RobotMap.Magnetic_Switch_Portal); //
	public static DigitalInput switchHSwitch = new DigitalInput(RobotMap.Magnetic_Switch_Switch); //
	public static DigitalInput switchHScale = new DigitalInput(RobotMap.Magnetic_Switch_Scale); //
	public static DigitalInput switchHClimb = new DigitalInput(RobotMap.Magnetic_Switch_Climb); //
	public Solenoid liftBrake = new Solenoid(RobotMap.Brake_Solenoid);//default should be braked
	
	private static Spark m_elevatorMotor = new Spark(RobotMap.Elevator_Motor);
	
    public void raise(double speed){
    	liftBrake.set(true);
    	m_elevatorMotor.set(speed);
    }
    
    public void lower(double speed){
    	liftBrake.set(true);
    	m_elevatorMotor.set(-speed);
    }
    
//    public void brake(boolean state){ 
//    	liftBrake.set(!state);
//    	
//    }
    
    public void stop(){
    	m_elevatorMotor.stopMotor();
    	Timer.delay(0.1);
    	liftBrake.set(false);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

