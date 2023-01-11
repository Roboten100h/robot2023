// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;


public class Elevator extends SubsystemBase {

  private final Talon elevatorWinch = new Talon(Constants.PWM.winchElevator);

  /** Creates a new Elevator. */
  public Elevator() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Raise() {
    elevatorWinch.set(Constants.Elevator.speed);
  }

  public void Lower() {
    elevatorWinch.set(-Constants.Elevator.speed);
  }

  public void Stop() {
    elevatorWinch.set(0);
  }
}
