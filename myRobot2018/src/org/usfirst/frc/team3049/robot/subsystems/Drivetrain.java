package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.OI;
import org.usfirst.frc.team3049.robot.RobotMap;
import org.usfirst.frc.team3049.robot.commands.ArcadeDriveCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 */
public class Drivetrain extends Subsystem {
	public DifferentialDrive m_robotDrive;
	//No Touchy 
	private Talon m_frontLeft = new Talon(RobotMap.FRONT_LEFT_MOTOR);
	private Talon m_rearLeft = new Talon(RobotMap.REAR_LEFT_MOTOR);
	private SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft,m_rearLeft);
		
	private Talon m_frontRight = new Talon(RobotMap.FRONT_RIGHT_MOTOR);
	private Talon m_rearRight = new Talon(RobotMap.REAR_RIGHT_MOTOR);
	private SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight,m_rearRight);
	
	private double dz = 0.1; //change this to adjust the deadzone on the joysticks
	
	public Drivetrain(){
		super();
	
		m_robotDrive = new DifferentialDrive(m_left,m_right);	
		}
	
	public void drive(double x, double r) { // x is fwd/rev. r is rotation. both should, inclusive, be within 0 and 1
//		x = deadzone(x);
//		r = deadzone(r);
//		System.out.println("Speed:" + x); //prints expected fwds/rev speed of robot to console
		m_robotDrive.arcadeDrive(x, r);
	}
	
	/**
	 * 
	 * @param i input for joystick
	 * @return
	 */
	public double deadzone(double i) { 
		if (Math.abs(i) < dz)       // this sets how far the joystick has to move before it starts moving the motors
		{
			i = 0.0;
		}
		else if (i < 0){			// these two statements let us have  a full range on the motors with the deadzone
			i = -(Math.abs(i)-dz)/(1-dz);
		}
			else {
			i = (i-dz)/(1-dz);
		}
		
		return i;
	}
	
	public void jdrive(Joystick joy) { // the method used to drive with a joystick
		
		double x = deadzone(-joy.getRawAxis(OI.axisLY)); //
		double r = deadzone(joy.getRawAxis(OI.axisRX));
		//System.out.println(""+joy.getRawAxis(0)+""+joy.getRawAxis(1)+""+joy.getRawAxis(2)+""+joy.getRawAxis(3)+joy.getRawAxis(4));
//		System.out.println(" OI.axisLY:"+joy.getRawAxis(OI.axisLY)+" OI.axisRX:"+joy.getRawAxis(OI.axisRX));
		drive(x,r);
//		drive(joy.getRawAxis(OI.axisLY), joy.getRawAxis(OI.axisRX));
	}
	
	public void stop() // To keep motor safety happy
	{
		m_robotDrive.stopMotor();
	}
	
	public void initDefaultCommand()
	{
		setDefaultCommand(new ArcadeDriveCommand(this, OI.joy));
	}
}
