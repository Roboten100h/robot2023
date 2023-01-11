// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import frc.robot.Constants;


public class Intake extends SubsystemBase {

  public Talon leftWwheels = new Talon(Constants.PWM.intakeLeft); 
  public Talon rightWheels = new Talon(Constants.PWM.intakeRight); 

  private final MotorControllerGroup intakeWheels = new MotorControllerGroup(leftWwheels, rightWheels);

  public Talon winch = new Talon(Constants.PWM.winchIntake);

  /** Creates a new Intake. */
  public Intake() {
    rightWheels.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void RaiseIntake() {
    winch.set(Constants.Intake.winchRaiseSpeed);
  }
  public void LowerIntake() {
    winch.set(Constants.Intake.winchLowerSpeed);
  }
  public void StopIntakeWinch() {
    winch.set(0);
  }

  public void Feed() {
    intakeWheels.set(Constants.Intake.feedSpeed);
    // leftWwheels.set(Constants.Intake.feedSpeed);
    // rightWheels.set(Constants.Intake.feedSpeed);
  }
  public void Eject() {
    intakeWheels.set(Constants.Intake.ejectSpeed);
    // leftWwheels.set(Constants.Intake.ejectSpeed);
    // rightWheels.set(Constants.Intake.ejectSpeed);
  }
  public void StopIntakeWheels() {
    intakeWheels.set(0);
  }
}
