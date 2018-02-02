package org.usfirst.frc.team3049.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team3049.robot.Robot;
import org.usfirst.frc.team3049.robot.commands.ActivateClimber;
import org.usfirst.frc.team3049.robot.commands.AutoTestCase;
import org.usfirst.frc.team3049.robot.commands.DriveStraight;
import org.usfirst.frc.team3049.robot.commands.GiveToExchange;
import org.usfirst.frc.team3049.robot.commands.GripperControl;
import org.usfirst.frc.team3049.robot.commands.ManualElevatorControl;
import org.usfirst.frc.team3049.robot.commands.Print;
import org.usfirst.frc.team3049.robot.commands.SetElevatorHeight;
import org.usfirst.frc.team3049.robot.commands.TurnRight;
import org.usfirst.frc.team3049.robot.commands.TurnLeft;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static Joystick joy = new Joystick(0); // Xbox Gamepad
	
	// Xbox Controller Button Mapping
	JoystickButton buttonA = new JoystickButton(joy, 1); // runs AutoTestCase
	JoystickButton buttonB = new JoystickButton(joy, 2); // runs TurnRight
	JoystickButton buttonX = new JoystickButton(joy, 3); // runs TurnLeft
	JoystickButton buttonY = new JoystickButton(joy, 4); // runs DriveStraight
	JoystickButton buttonLSh = new JoystickButton(joy, 5); // piston 
	JoystickButton buttonRSh = new JoystickButton(joy, 6); // 
	JoystickButton buttonBack = new JoystickButton(joy, 7); //
	JoystickButton buttonStart = new JoystickButton(joy, 8);
	public static int axisLX = 0; // 
	public static int axisLY = 1; // Drive, fwd/back
	public static int axisLT = 2; // 
	public static int axisRT = 3; // 
	public static int axisRX = 4; // Drive, turning
	public static int axisRY = 5;
	
	
	public static Joystick custom = new Joystick(1); // Custom Control Rig
	
	// Custom Rig Button Mapping
	
	JoystickButton buttonGrip = new JoystickButton(custom, 2);//
	JoystickButton buttonRelease = new JoystickButton(custom, 4);//
	JoystickButton buttonExchange = new JoystickButton(custom, 3);//
	JoystickButton buttonScaleH = new JoystickButton(custom, 17);//
	JoystickButton buttonSwitchH = new JoystickButton(custom, 19);//
	JoystickButton buttonPortalH = new JoystickButton(custom, 18);//
	JoystickButton buttonExchangeH = new JoystickButton(custom, 16);//
	JoystickButton buttonGroundH = new JoystickButton(custom, 15);//
	JoystickButton buttonClimbH = new JoystickButton(custom, 8);//
	JoystickButton buttonClimbMotorFwd = new JoystickButton(custom, 10);//
	JoystickButton buttonClimbMotorRev = new JoystickButton(custom, 12);//
	JoystickButton buttonLiftUp = new JoystickButton(custom, 14);//
	JoystickButton buttonLiftDown = new JoystickButton(custom, 11);//
	
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
		//Xbox Button Command Assignment
		//buttonX.whenPressed(new Print("Thank God The Controller Works"));
		buttonB.whenPressed(new TurnRight(3.0, 0.5));
		buttonX.whenPressed(new GripperControl(1));
		buttonY.whenPressed(new GripperControl(2));
		
		//Custom Rig Button Command Assignment
		buttonGrip.whenPressed(new GripperControl(1)); // true declares that the Gripper will close
		buttonRelease.whenPressed(new GripperControl(2)); // false declares that Gripper will open
		buttonExchange.whenPressed(new GiveToExchange()); //No input but Must already be on level with Exchange
		buttonScaleH.whenPressed(new SetElevatorHeight(4)); // 4 declares that elevator will go to Scale height
		buttonSwitchH.whenPressed(new SetElevatorHeight(3));// 3 declares that elevator will go to Switch height
		buttonPortalH.whenPressed(new SetElevatorHeight(2));// 2 declares that elevator will go to Portal height
		buttonExchangeH.whenPressed(new SetElevatorHeight(1));// 1 declares that elevator will go to Exchange height
		buttonGroundH.whenPressed(new SetElevatorHeight(0));// 0 declares that elevator will go to Ground height
		buttonClimbH.whenPressed(new SetElevatorHeight(5));// 5 declares that elevator will go to Climb height
		buttonClimbMotorFwd.whileHeld(new ActivateClimber(true)); // true declares that the Robot will climb up
		buttonClimbMotorRev.whileHeld(new ActivateClimber(false)); //false declares that the Robot will climb down
		buttonLiftUp.whileHeld(new ManualElevatorControl(true)); // true declares that the elevator will raise
		buttonLiftDown.whileHeld(new ManualElevatorControl(false)); // false declares that the elevator will lower
		//buttonGrip.whileHeld(new Print("Thank God The New Controller Works"));
	}

	public Joystick getJoystick() {
		return joy;
	}
	
	
}
