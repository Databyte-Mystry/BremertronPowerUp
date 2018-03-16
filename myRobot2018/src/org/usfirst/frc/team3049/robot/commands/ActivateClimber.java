//	package org.usfirst.frc.team3049.robot.commands;
//
//import org.usfirst.frc.team3049.robot.Robot;
//import org.usfirst.frc.team3049.robot.subsystems.Climber;
//
//import edu.wpi.first.wpilibj.command.Command;
//
///**
// *
// */
//public class ActivateClimber extends Command { // only run as a WhileHeld button type, otherwise it will run forever
//	private static boolean m_direction;
//	private static Climber m_climber;
//	private static double m_speed = 0.8; // adjust this to adjust climb speed
//	
//	/**
//	 * Command for Manually controlling the climber
//	 * @param direction Boolean, True = ascend. False = descend.
//	 */
//    public ActivateClimber(boolean direction) {
//        requires(Robot.climber);
//        m_direction = direction;
//        m_climber = Robot.climber;
//    }
//
//    // Called just before this Command runs the first time
//    protected void initialize() {
//    }
//
//    // Called repeatedly when this Command is scheduled to run
//    protected void execute() {
//    	if(m_direction == true){
//    		m_climber.ascend(m_speed);
//    	}else if(m_direction == false){
//    		m_climber.descend(m_speed);
//    	}
//    }
//
//    // Make this return true when this Command no longer needs to run execute()
//    protected boolean isFinished() {
//        return false;
//    }
//
//    // Called once after isFinished returns true
//    protected void end() {
//    	m_climber.stop();
//    }
//
//    // Called when another command which requires one or more of the same
//    // subsystems is scheduled to run
//    protected void interrupted() {
//    	m_climber.stop();
//    }
//}
