package org.usfirst.frc.team3049.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.commands.DriveTest;
import org.usfirst.frc.team3049.robot.commands.ElevatorStop;
//import org.usfirst.frc.team3049.robot.commands.ActivateClimber;
import org.usfirst.frc.team3049.robot.commands.GiveToExchange;
import org.usfirst.frc.team3049.robot.commands.GripperControl;
import org.usfirst.frc.team3049.robot.commands.LowerElevator;
import org.usfirst.frc.team3049.robot.commands.ManualElevatorControl;
import org.usfirst.frc.team3049.robot.commands.Print;
import org.usfirst.frc.team3049.robot.commands.SetElevatorHeight;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick joy = new Joystick(1); // Drive Joystick
	
	//Drive Stick Button Mapping
	JoystickButton button1 = new JoystickButton(joy, 1);
	JoystickButton button2 = new JoystickButton(joy, 2);
	JoystickButton button3 = new JoystickButton(joy, 3);
	JoystickButton button4 = new JoystickButton(joy, 4);
	JoystickButton button5 = new JoystickButton(joy, 5);
	JoystickButton button6 = new JoystickButton(joy, 6);
	JoystickButton button7 = new JoystickButton(joy, 7);
	JoystickButton button8 = new JoystickButton(joy, 8);
	JoystickButton button9 = new JoystickButton(joy, 9);
	JoystickButton button10 = new JoystickButton(joy, 10);
	JoystickButton button11 = new JoystickButton(joy, 11);
	public static int axisX = 0;
	public static int axisY = 1;
	public static int axisZ = 2;
	
public static Joystick aux = new Joystick(0); // Auxilary Joystick
	
	//Auxilary Stick Button Mapping
	JoystickButton buttonAux1 = new JoystickButton(aux, 1);
	JoystickButton buttonAux2 = new JoystickButton(aux, 2);
	JoystickButton buttonAux3 = new JoystickButton(aux, 3);
	JoystickButton buttonAux4 = new JoystickButton(aux, 4);
	JoystickButton buttonAux5 = new JoystickButton(aux, 5);
	JoystickButton buttonAux6 = new JoystickButton(aux, 6);
	JoystickButton buttonAux7 = new JoystickButton(aux, 7);
	JoystickButton buttonAux8 = new JoystickButton(aux, 8);
	JoystickButton buttonAux9 = new JoystickButton(aux, 9);
	JoystickButton buttonAux10 = new JoystickButton(aux, 10);
	JoystickButton buttonAux11 = new JoystickButton(aux, 11);
	public static int axisAuxX = 0;
	public static int axisAuxY = 1;
	public static int axisAuxZ = 2;
	
	
	// Xbox Controller Button Mapping
//	JoystickButton buttonA = new JoystickButton(joy, 1); // runs AutoTestCase
//	JoystickButton buttonB = new JoystickButton(joy, 2); // runs TurnRight
//	JoystickButton buttonX = new JoystickButton(joy, 3); // runs TurnLeft
//	JoystickButton buttonY = new JoystickButton(joy, 4); // runs DriveStraight
//	JoystickButton buttonLSh = new JoystickButton(joy, 5); // piston 
//	JoystickButton buttonRSh = new JoystickButton(joy, 6); // 
//	JoystickButton buttonBack = new JoystickButton(joy, 7); //
//	JoystickButton buttonStart = new JoystickButton(joy, 8);
//	public static int axisLX = 0; // 
//	public static int axisLY = 1; // Drive, fwd/back
//	public static int axisLT = 2; // 
//	public static int axisRT = 3; // 
//	public static int axisRX = 4; // Drive, turning
//	public static int axisRY = 5;
	
	
//	public static Joystick custom = new Joystick(1); // Custom Control Rig
//	
//	// Custom Rig Button Mapping
//	
//	JoystickButton buttonGrip = new JoystickButton(custom, 2);//
//	JoystickButton buttonRelease = new JoystickButton(custom, 4);//
//	JoystickButton buttonExchange = new JoystickButton(custom, 3);//
//	JoystickButton buttonScaleH = new JoystickButton(custom, 5);//
//	JoystickButton buttonSwitchH = new JoystickButton(custom, 7);//
//	JoystickButton buttonPortalH = new JoystickButton(custom, 6);//
//	JoystickButton buttonCarryH = new JoystickButton(custom, 15);//
//	JoystickButton buttonGroundH = new JoystickButton(custom, 16);//
//	JoystickButton buttonClimbH = new JoystickButton(custom, 8);//
//	JoystickButton buttonClimbMotorFwd = new JoystickButton(custom, 10);//
//	JoystickButton buttonClimbMotorRev = new JoystickButton(custom, 12);//
//	JoystickButton buttonLiftUp = new JoystickButton(custom, 14);//
//	JoystickButton buttonLiftDown = new JoystickButton(custom, 11);//
	
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public OI() {
//		//Xbox Button Command Assignment
//		//buttonX.whenPressed(new Print("Thank God The Controller Works"));
//		buttonX.whenPressed(new GripperControl(1));
//		buttonY.whenPressed(new GripperControl(2));
////		buttonA.whenPressed(System.out.println( + ));
//		
//		//Custom Rig Button Command Assignment
//		buttonGrip.whenPressed(new GripperControl(1)); // true declares that the Gripper will close
//		buttonRelease.whenPressed(new GripperControl(2)); // false declares that Gripper will open
//		buttonExchange.whenPressed(new GiveToExchange()); //No input but Must already be on level with Exchange
//		buttonScaleH.whenPressed(new SetElevatorHeight(4)); // 4 declares that elevator will go to Scale height
//		buttonSwitchH.whenPressed(new SetElevatorHeight(3));// 3 declares that elevator will go to Switch height
//		buttonPortalH.whenPressed(new SetElevatorHeight(2));// 2 declares that elevator will go to Portal height
//		buttonCarryH.whenPressed(new SetElevatorHeight(1));// 1 declares that elevator will go to Exchange height
//		buttonGroundH.whenPressed(new SetElevatorHeight(0));// 0 declares that elevator will go to Ground height
//		buttonClimbH.whenPressed(new SetElevatorHeight(5));// 5 declares that elevator will go to Climb height
//		buttonClimbMotorFwd.whileHeld(new ActivateClimber(false)); // true declares that the Robot will climb up
//		buttonClimbMotorRev.whenPressed(new LowerElevator()); //false declares that the Robot will climb down
//		buttonLiftUp.whileHeld(new ManualElevatorControl(true)); // true declares that the elevator will raise
//		buttonLiftDown.whileHeld(new ManualElevatorControl(false)); // false declares that the elevator will lower
//		//buttonGrip.whileHeld(new Print("Thank God The New Controller Works"));
		
		//Drive Joystick Command Assignment
		button6.whileHeld(new DriveTest(0.5));
		button8.whileHeld(new DriveTest(-0.5));
		
		//Auxilary Joystick Command Assignment
		buttonAux1.whenPressed(new GripperControl(1)); // 1 for grip
		buttonAux3.whenPressed(new GripperControl(3)); // 3 for activate gripper piston, then release
		buttonAux4.whenPressed(new GripperControl(2)); // 2 for release
		buttonAux5.whenPressed(new GripperControl(2)); // 2 for release
		buttonAux2.whenPressed(new GiveToExchange());
		buttonAux6.whenPressed(new SetElevatorHeight(0));
		buttonAux7.whenPressed(new SetElevatorHeight(0));
		buttonAux8.whenPressed(new SetElevatorHeight(0));
//		buttonAux6.whileHeld(new ManualElevatorControl(-0.6));
//		buttonAux7.whileHeld(new ManualElevatorControl(0.6));
		buttonAux11.toggleWhenPressed(new ElevatorStop());
	}

	public Joystick getJoystick() {
		return joy;
	}
	
	
}
