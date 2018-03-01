package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public static DigitalInput switchHGround = new DigitalInput(RobotMap.Magnetic_Switch_Ground);
	public static DigitalInput switchHCarry = new DigitalInput(RobotMap.Magnetic_Switch_Carry); //
//	public static DigitalInput switchHPortal = new DigitalInput(RobotMap.Magnetic_Switch_Portal); //
//	public static DigitalInput switchHSwitch = new DigitalInput(RobotMap.Magnetic_Switch_Switch); //
	public static DigitalInput switchHScale = new DigitalInput(RobotMap.Magnetic_Switch_Scale); //
	public static DigitalInput switchHClimb = new DigitalInput(RobotMap.Magnetic_Switch_Climb); //
	
	public static Encoder m_encoderElevator = new Encoder(RobotMap.EncoderE_ChanA, RobotMap.EncoderE_ChanB, true, CounterBase.EncodingType.k4X);
	
	public Solenoid liftBrake = new Solenoid(RobotMap.Brake_Solenoid);//default should be braked
	
	private static Talon m_elevatorMotor1 = new Talon(RobotMap.Elevator_Motor1);
	private static Spark m_elevatorMotor2 = new Spark(RobotMap.Elevator_Motor2);
	private static SpeedControllerGroup m_elevatorMotors = new SpeedControllerGroup(m_elevatorMotor1,m_elevatorMotor2);
	
    public void raise(double speed){
    	liftBrake.set(true);
    	m_elevatorMotors.set(speed);
    }
    
    public void lower(double speed){
    	liftBrake.set(true);
    	m_elevatorMotors.set(-speed);
    }
    
//    public void brake(boolean state){ 
//    	m_encoderElevator.setDistancePerPulse(0.25); // distance is in degrees per pulse
//    	m_encoderElevator.setMaxPeriod(maxPeriod);
//    	if(!m_encoderElevator.getStopped()){
//    		
//    	}else {
//    		
//    	}
//    	
//    }
    
    public void stop(){
    	m_elevatorMotors.stopMotor();
    	Timer.delay(0.1);
    	liftBrake.set(false);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

