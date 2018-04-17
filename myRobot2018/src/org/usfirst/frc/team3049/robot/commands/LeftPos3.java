package org.usfirst.frc.team3049.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3049.robot.subsystems.Drivetrain;
import org.usfirst.frc.team3049.robot.Robot;
/**
 *
 */
public class LeftPos3 extends CommandGroup {

	/**
	 * Auto Command going for the Left switch in start Position 3 (Right side)
	 */
    public LeftPos3() {
    	
    	addSequential(new ElevatorStop());
    	addSequential(new GyroDriveStraight(140, 0.5));
    	
//    	addSequential(new GripperControl(1));
//    	addSequential(new GyroDriveStraight(220.25, 0.5)); //placeholder Distance Needed: 220.25"
//    	addSequential(new GyroTurnLeft(90));
//    	addSequential(new GyroDriveStraight(107.81, 0.5)); //placeholder Distance Needed: 107.81"
//    	addSequential(new GyroTurnLeft(90));
//    	addSequential(new SetElevatorHeight(1));
//    	addSequential(new GyroDriveStraight(6, 0.5)); //placeholder Distance Needed: 6"    	
//    	addSequential(new GripperControl(3));

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
