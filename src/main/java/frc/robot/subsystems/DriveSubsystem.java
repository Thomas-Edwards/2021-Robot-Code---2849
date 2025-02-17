// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  public final Spark FrontRightDrive = new Spark(Constants.FRONT_RIGHT_DRIVE_PORT);
  public final Spark FrontLeftDrive = new Spark(Constants.FRONT_LEFT_DRIVE_PORT);
  public final Spark BackRightDrive = new Spark(Constants.BACK_RIGHT_DRIVE_PORT);
  public final Spark BackLeftDrive = new Spark(Constants.BACK_LEFT_DRIVE_PORT);

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
