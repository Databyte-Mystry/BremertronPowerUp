package org.usfirst.frc.team3049.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3049.robot.Robot;

/**
 *
 */
public class LeftPos1 extends CommandGroup {

	/**
	 * Auto Command going for the Left switch in start Position 1 (Left side)
	 */
    public LeftPos1() {
    	
    	addSequential(new GripperControl(1));
    	addSequential(new SetElevatorHeight(1));
    	addSequential(new GyroDriveStraight(3.0, 0.5)); //placeholder
    	addSequential(new GyroTurnRight(90));
    	addSequential(new GyroDriveStraight(1.0, 0.5)); //placeholder
    	addSequential(new GripperControl(3));

//    	addSequential(new GyroTurnRight(90));
//    	addSequential(new GyroTurnLeft(90));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
