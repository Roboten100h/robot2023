// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.Autos;
import frc.robot.commands.DriveBaseDriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.TelescopicElevator;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Gripper;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain driveTrain = new DriveTrain();
  private final Elevator elevator = new Elevator();
  private final TelescopicElevator telescopicElevator = new TelescopicElevator();
  private final Gripper gripper = new Gripper();
  private final Intake intake = new Intake();

  // // Replace with CommandPS4Controller or CommandJoystick if needed
  // private final CommandXboxController m_driverController =
  //     new CommandXboxController(OperatorConstants.kDriverControllerPort);

  private final XboxController m_pilotController =  new XboxController(0);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    // driveTrain.setDefaultCommand(new DriveBaseDriveCommand(m_joystick, driveTrain));

    driveTrain.setDefaultCommand(new RunCommand(() -> {
      double move = m_pilotController.getLeftY();
      double turn = m_pilotController.getRightX();

      driveTrain.driveArcade(move, turn);
    }, driveTrain));

    telescopicElevator.setDefaultCommand(new RunCommand(() -> {
      double value = -m_pilotController.getLeftTriggerAxis() + m_pilotController.getRightTriggerAxis();

      telescopicElevator.WinchAtSpeed(value);
    }, telescopicElevator)
    );
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    final JoystickButton a = new JoystickButton(m_pilotController, XboxController.Button.kA.value);
    final JoystickButton b = new JoystickButton(m_pilotController, XboxController.Button.kB.value);
    final JoystickButton x = new JoystickButton(m_pilotController, XboxController.Button.kX.value);
    final JoystickButton y = new JoystickButton(m_pilotController, XboxController.Button.kY.value);
    
    final JoystickButton startButton = new JoystickButton(m_pilotController, XboxController.Button.kStart.value);
    final JoystickButton selectButton = new JoystickButton(m_pilotController, XboxController.Button.kBack.value);

    final JoystickButton leftBumper = new JoystickButton(m_pilotController, XboxController.Button.kLeftBumper.value);
    final JoystickButton rightBumper = new JoystickButton(m_pilotController, XboxController.Button.kRightBumper.value);

    // // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
    //     .onTrue(new ExampleCommand(m_exampleSubsystem));
    

    rightBumper.whileHeld(new StartEndCommand(
      () -> elevator.Raise(),
      () -> elevator.Stop(),
      elevator));
    
    leftBumper.whileHeld(new StartEndCommand(
      () -> elevator.Lower(),
      () -> elevator.Stop(),
      telescopicElevator));

    selectButton.whileHeld(new StartEndCommand(
        () -> intake.Feed(),
        () -> intake.StopIntakeWheels(),
        intake));
  
    startButton.whileHeld(new StartEndCommand(
      () -> intake.Eject(),
      () -> intake.StopIntakeWheels(),
      intake));

    y.whileHeld(new StartEndCommand(
      () -> intake.RaiseIntake(),
      () -> intake.StopIntakeWinch(),
      intake));

    x.whileHeld(new StartEndCommand(
      () -> intake.LowerIntake(),
      () -> intake.StopIntakeWinch(),
      intake));

    a.toggleWhenPressed(new StartEndCommand(
      () -> gripper.Grip(),
      () -> gripper.Release(),
      gripper));
    

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
