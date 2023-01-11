// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
// import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DriveTrain extends SubsystemBase
 {
  private final CANSparkMax motorLeftFront = new CANSparkMax(Constants.CAN.motorLeftFrontPort, MotorType.kBrushed);
  private final CANSparkMax motorLeftRear = new CANSparkMax(Constants.CAN.motorLeftRearPort, MotorType.kBrushed);
  private final CANSparkMax motorRightFront = new CANSparkMax(Constants.CAN.motorRightFrontPort, MotorType.kBrushed);
  private final CANSparkMax motorRightRear = new CANSparkMax(Constants.CAN.motorRightRearPort, MotorType.kBrushed);

  private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(motorLeftFront, motorLeftRear);
  private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(motorRightFront, motorRightRear);

  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);


  private boolean slowMode = false;

  /** Creates a new DriveBase. */
  public DriveTrain() 
  {
    super();

    m_rightMotors.setInverted(true);
  }

  public void toggleSlowMode(){
    slowMode = !slowMode;
    System.out.printf("Slow mode toggled, current state: %b", slowMode);
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

  public void driveArcade(double move, double rotate)
  {
    m_drive.arcadeDrive(move, rotate, true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
