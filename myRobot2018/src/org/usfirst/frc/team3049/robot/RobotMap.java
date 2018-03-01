package org.usfirst.frc.team3049.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	
	//Drive Train Motor Assignments      Port assignments CAN NOT overlap with the Other Motors Section
	public static int FRONT_LEFT_MOTOR = 0; // 
	public static int REAR_LEFT_MOTOR = 1; // 
	public static int REAR_RIGHT_MOTOR = 4; //
	public static int FRONT_RIGHT_MOTOR = 5; //
	
	// Other Motors Assignments          Port assignments CAN NOT overlap with the Drive train Motors Section
	public static int Climber_Motor = 2;
	public static int Elevator_Motor1 = 3;
	public static int Elevator_Motor2 = 6;
	
	// Pneumatic Solenoids     Port Assignments can overlap with Motor Port assignments
	public static int Pusher_Solenoid = 0;
	public static int Brake_Solenoid = 1;
	public static int Gripper_SolenoidA = 7;
	public static int Gripper_SolenoidB = 4;

	//Analog Inputs
	public static int String_Potentiometer = 0;
	
	//Digital Inputs
	public static int EncoderL_ChanA = 0;
	public static int EncoderL_ChanB = 1;
	public static int EncoderR_ChanA = 2;
	public static int EncoderR_ChanB = 3;
	public static int EncoderE_ChanA = 4;
	public static int EncoderE_ChanB = 5;
	public static int Magnetic_Switch_Ground = 6;
	public static int Magnetic_Switch_Carry = 7;
//	public static int Magnetic_Switch_Portal = 8;
//	public static int Magnetic_Switch_Switch = 9;
	public static int Magnetic_Switch_Scale = 8;
	public static int Magnetic_Switch_Climb = 9;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
