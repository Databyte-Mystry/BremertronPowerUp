package org.usfirst.frc.team3049.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.NamedSendable;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team3049.robot.Robot;

import org.usfirst.frc.team3049.robot.commands.AutoTestCase;
import org.usfirst.frc.team3049.robot.commands.DriveStraight;
import org.usfirst.frc.team3049.robot.commands.ExampleSolenoid;
import org.usfirst.frc.team3049.robot.commands.GripperControl;
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
	public static int axisLY = 1; // Drive, fwd/back asdf
	public static int axisLT = 2; // 
	public static int axisRT = 3; // 
	public static int axisRX = 4; // Drive, turning
	public static int axisRY = 5;
	
	
	public static Joystick custom = new Joystick(1); // Custom Control Rig
	
	// Custom Rig Button Mapping
	
	JoystickButton gripButton = new JoystickButton(custom, 0);//
	JoystickButton releaseButton = new JoystickButton(custom, 1);//
	JoystickButton exchangeButton = new JoystickButton(custom, 2);//
	JoystickButton scaleHButton = new JoystickButton(custom, 3);//
	JoystickButton switchHButton = new JoystickButton(custom, 4);//
	JoystickButton portalHButton = new JoystickButton(custom, 5);//
	JoystickButton exchangeHButton = new JoystickButton(custom, 6);//
	JoystickButton groundHButton = new JoystickButton(custom, 7);//
	JoystickButton climbHButton = new JoystickButton(custom, 8);//
	JoystickButton climbMotorFwdButton = new JoystickButton(custom, 9);//
	JoystickButton climbMotorRevButton = new JoystickButton(custom, 10);//
	JoystickButton liftUpButton = new JoystickButton(custom, 11);//
	JoystickButton liftDownButton = new JoystickButton(custom, 12);//
	
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
		buttonA.whenPressed(new AutoTestCase());
		buttonB.whenPressed(new TurnRight(3.0, 0.5));
		buttonX.whenPressed(new TurnLeft(3.0, 0.5));
		buttonY.whenPressed(new DriveStraight(3.0, 0.5));
		buttonLSh.whenPressed(new ExampleSolenoid());
		
		//Custom Rig Button Command Assignment
		gripButton.whenPressed(new GripperControl(true)); // true declares that the Gripper will close
		
		
	}

	public Joystick getJoystick() {
		return joy;
	}
	
	
}
