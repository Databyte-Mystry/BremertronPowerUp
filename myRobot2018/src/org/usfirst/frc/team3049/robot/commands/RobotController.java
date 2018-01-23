package org.usfirst.frc.team3049.robot.commands;

import org.usfirst.frc.team3049.robot.Robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;

/**
 *
 */
public class RobotController extends Command {

    public RobotController() {
        requires(Robot.driveTrain);
    }
   

	// Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	((Drivetrain) Robot.driveTrain).jdrive(Robot.oi.getJoystick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	((Drivetrain) Robot.driveTrain).drive(0, 0);
    }
}
