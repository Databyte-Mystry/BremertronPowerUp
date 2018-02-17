package org.usfirst.frc.team3049.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoExchange extends CommandGroup {

    public AutoExchange() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new DriveStraight(3.0, 0.5));
    	addSequential(new TurnLeft(3.0, 0.7));
    	addSequential(new DriveStraight(3.0, 0.5));
    	addSequential(new TurnLeft(3.0, 0.7));
    	addSequential(new DriveStraight(3.0, 0.5));
    	addSequential(new GiveToExchange());
    	addSequential(new DriveStraight(-3.0, 0.5));
    	addSequential(new TurnRight(3.0, 0.7));
    	addSequential(new DriveStraight(3.0, 0.5));
    	addSequential(new TurnRight(3.0, 0.7));
    	addSequential(new DriveStraight(3.0, 0.5));

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
