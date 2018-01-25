package org.usfirst.frc.team3049.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

/**
 *
 */
public class Arduino extends Subsystem {
	private static SerialPort serial = new SerialPort(9600, Port.kOnboard);
	private String m_buffer;
	private int m_distance;
	public int getDistance() {
		m_buffer = serial.readString();
		SmartDashboard.putString("Arduino", m_buffer);
		return m_distance;
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

