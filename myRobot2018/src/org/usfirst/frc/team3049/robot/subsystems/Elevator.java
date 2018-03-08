package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.OI;
import org.usfirst.frc.team3049.robot.RobotMap;
import org.usfirst.frc.team3049.robot.commands.ManualElevatorControl;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
	public DigitalInput switchHGround;
	public DigitalInput switchHTop; 
	
	public static Encoder m_encoderElevator = new Encoder(RobotMap.EncoderE_ChanA, RobotMap.EncoderE_ChanB, true, CounterBase.EncodingType.k4X);
	
	public Solenoid liftBrake = new Solenoid(RobotMap.Brake_Solenoid);//default should be braked
	
	private static Talon m_elevatorMotor1 = new Talon(RobotMap.Elevator_Motor1);
	private static Spark m_elevatorMotor2 = new Spark(RobotMap.Elevator_Motor2);
	public static SpeedControllerGroup m_elevatorMotors = new SpeedControllerGroup(m_elevatorMotor1,m_elevatorMotor2);
	
	public Elevator (){
		try{
		switchHGround = new DigitalInput(RobotMap.Limit_Switch_Ground);
		switchHTop = new DigitalInput(RobotMap.Limit_Switch_Top);
		}catch(Exception e){
			System.out.println("Elevator Constructor Failed");
		}
	}
    public void raise(double speed){
//    	liftBrake.set(true);
    	m_elevatorMotors.set(speed);
    }
    
    public void lower(){
//    	liftBrake.set(true);
    		m_elevatorMotors.set(m_elevatorMotors.get() - 0.05);
    		Timer.delay(0.5);
    	
    }
    public void lowerToBottom(){
    	while(m_elevatorMotors.get() > 0 ){
    		m_elevatorMotors.set(m_elevatorMotors.get() - 0.05);
    		Timer.delay(0.5);
    	}
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
//    	Timer.delay(0.1);
//    	liftBrake.set(false);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ManualElevatorControl(OI.aux.getRawAxis(OI.axisAuxY)));
    }
}

