// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public interface Constants 
{
  interface PWM
  {
    int winchIntake = 0;
    int intakeLeft = 1;
    int intakeRight = 2;
    int winchElevator = 3;
    int telescopicElevator = 4;
  }

  interface CAN
  {
    int motorLeftFrontPort = 1;
    int motorLeftRearPort = 2;
    int motorRightFrontPort = 3;
    int motorRightRearPort = 4;
  }
 
  interface Elevator
  {
    double speed = 0.7;
  }

  interface TelescopicElevator
  {
    double speed = 0.4;
  }

  interface Intake
  {
    double winchRaiseSpeed = 1;
    double winchLowerSpeed = -1;
    double feedSpeed = 0.7;
    double ejectSpeed= 0.7;
  }

}
