// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;

public class TelescopicElevator extends SubsystemBase {

  private final Talon telescopicElevatorWinch = new Talon(Constants.PWM.telescopicElevator);


  /** Creates a new TelescopicElevator. */
  public TelescopicElevator() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Extend() {
    telescopicElevatorWinch.set(Constants.TelescopicElevator.speed);
  }

  public void Retract() {
    telescopicElevatorWinch.set(-Constants.TelescopicElevator.speed);
  }

  public void Stop() {
    telescopicElevatorWinch.set(0);
  }

  public void WinchAtSpeed(double speed) {
    telescopicElevatorWinch.set(speed);
  }
}
