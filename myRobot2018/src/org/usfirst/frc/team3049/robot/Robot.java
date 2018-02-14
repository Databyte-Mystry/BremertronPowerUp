package org.usfirst.frc.team3049.robot;
 
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;

import org.usfirst.frc.team3049.robot.subsystems.LidarSubsystem;
import org.usfirst.frc.team3049.robot.commands.GripperControl;
import org.usfirst.frc.team3049.robot.commands.GyroTurnLeft;
import org.usfirst.frc.team3049.robot.commands.LeftPos1;
import org.usfirst.frc.team3049.robot.commands.LeftPos2;
import org.usfirst.frc.team3049.robot.commands.LeftPos3;
import org.usfirst.frc.team3049.robot.commands.RightPos1;
import org.usfirst.frc.team3049.robot.commands.RightPos2;
import org.usfirst.frc.team3049.robot.commands.RightPos3;
//import org.usfirst.frc.team3049.robot.commands.AutoTestCase;
import org.usfirst.frc.team3049.robot.commands.GyroTurnRight;
import org.usfirst.frc.team3049.robot.subsystems.Climber;
import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3049.robot.subsystems.Elevator;
import org.usfirst.frc.team3049.robot.subsystems.Gripper;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static Drivetrain driveTrain;
	public static OI oi;
	public static ADXRS450_Gyro gyro;
	public static Elevator elevator;
	public static Gripper pneumatics;
	public static Climber climber;
	public static LidarSubsystem lidar;
	
	Command autonomousCommand;
	Command gripperCommand;
	boolean gripState = false;
	SendableChooser<Command> chooser = new SendableChooser<>();
	private static int position;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		driveTrain = new Drivetrain();
		gyro = new ADXRS450_Gyro();
		elevator = new Elevator();
		pneumatics = new Gripper();
		climber = new Climber();
		lidar = new LidarSubsystem();
		oi = new OI();
		position = 1;
//		position =  DriverStation.getLocation(); 
//		autonomousCommand = new AutoTestCase();
		gyro.calibrate();
		CameraServer.getInstance().startAutomaticCapture();
		driveTrain.stop();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {         
		gyro.reset();
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			//Put left auto code here
			if(position == 1){
				autonomousCommand = new LeftPos1();
				System.out.println("LeftPos1");
			}else if(position == 2){
				autonomousCommand = new LeftPos2();
				System.out.println("LeftPos2");
			}else{
				autonomousCommand = new LeftPos3();
				System.out.println("LeftPos3");
			}
		} else {
			//Put right auto code here
			if(position == 1){
				autonomousCommand = new RightPos1();
				System.out.println("RightPos1");
			}else if(position == 2){
				autonomousCommand = new RightPos2();
				System.out.println("RightPos2");
			}else{
				autonomousCommand = new RightPos3();
				System.out.println("RightPos3");
			}
		}
//		autonomousCommand = new GyroTurnLeft(90);
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null){
			autonomousCommand.cancel();
		}
		driveTrain.stop();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
//		GetDistance distance = new GetDistance();
//		distance.start();
//		gripperCommand = new GripperControl(false);
		Scheduler.getInstance().run();
		log();
//		Timer.delay(1);
//		System.out.println("Delayed");
		//new GripperControl(true);
		//Timer.delay(1);
	/*
		while (isOperatorControl() && isEnabled()) {
			Scheduler.getInstance().run();
			double x = oi.joy.getRawAxis(0);
			double y = oi.joy.getRawAxis(1);
			double r = oi.joy.getRawAxis(4);
			
			//set deadzones
			x = deadzone(x);
			y = deadzone(y);
			r = deadzone(r);
			
			driveTrain.mecanumDrive_Cartesian(x, y, r, 0);
			Timer.delay(0.02);
			log();
		}
		
		
		//for (int i = 0; i < oi.joy.getAxisCount(); i++) {
			//System.out.println("Axis " + i + " = " + oi.joy.getRawAxis(i));
		//}
		 */
	}
	
	/**
	 *  Controls everything in the SmartDashboard
	 */
	private void log(){
		SmartDashboard.putNumber("Position", position);//????
		SmartDashboard.putNumber("Gyro Angle:", gyro.getAngle());// Displays Gyro Angle
		SmartDashboard.putNumber("Lift", (Elevator.strPot.get() / 94) * 100);// Progress Bar for Lift
		SmartDashboard.putString("Lift Height", String.format("%.4g%n", Elevator.strPot.get()) + " In.");// Displays Height for Lift in Inches
//		SmartDashboard.putNumber("Distance", lidar.getDistance());// Displays distance in inches.
	}


	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
