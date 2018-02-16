package org.usfirst.frc.team3049.robot.subsystems;

import org.usfirst.frc.team3049.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	private static Spark m_climber = new Spark(RobotMap.Climber_Motor);
	
	public void ascend(double speed){
		m_climber.set(-speed);
	}
	
	public void descend(double speed){
		m_climber.set(speed);
	}
	
	public void stop(){
		m_climber.stopMotor();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

