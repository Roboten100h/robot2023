// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveBaseDriveCommand extends CommandBase {
  private XboxController xboxController;
  private DriveTrain driveTrain;

  /** Creates a new DriveBaseDriveCommand. */
  public DriveBaseDriveCommand(XboxController controller, DriveTrain base) {
    // Use addRequirements() here to declare subsystem dependencies.
    xboxController = controller;
    driveTrain = base; 
    addRequirements(driveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double speedLeft = xboxController.getLeftY();
    double speedRight = xboxController.getRightY();

    driveTrain.driveTank(speedLeft, speedRight);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
