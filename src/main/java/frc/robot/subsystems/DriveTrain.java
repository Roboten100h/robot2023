// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DriveTrain extends SubsystemBase
 {
  private final Talon motorLeftFront = new Talon(Constants.PWM.motorLeftFrontPort);
  private final Talon motorLeftRear = new Talon(Constants.PWM.motorLeftRearPort);
  private final Talon motorRightFront = new Talon(Constants.PWM.motorRightFrontPort);
  private final Talon motorRightRear = new Talon(Constants.PWM.motorRightRearPort);

  private final MotorController m_leftMotor = new MotorControllerGroup(motorLeftFront, motorLeftRear);
  private final MotorController m_rightMotor = new MotorControllerGroup(motorRightFront, motorRightRear);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);


  /** Creates a new DriveBase. */
  public DriveTrain() 
  {
    super();

    m_leftMotor.setInverted(true);
  }

  public void driveTank(double speedLeft, double speedRight)
  {
    m_drive.tankDrive(speedLeft, speedRight);

    /*speedLeft = -speedLeft; // motor are reversed
    if (speedLeft < 0.4 && speedLeft > -0.4)
    {
      speedLeft = 0.0;
    }

    if(speedRight < 0.4 && speedRight > -0.4)
    {
      speedRight = 0.0;
    }
    motorLeftFront.set(speedLeft);
    motorLeftRear.set(speedLeft);

    motorRightFront.set(speedRight);
    motorRightRear.set(speedRight);*/
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
