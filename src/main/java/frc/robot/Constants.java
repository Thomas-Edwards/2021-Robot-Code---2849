// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final int BACK_LEFT_DRIVE_PORT = 4;
  public static final int BACK_RIGHT_DRIVE_PORT = 5;
  public static final int FRONT_LEFT_DRIVE_PORT = 2;
  public static final int FRONT_RIGHT_DRIVE_PORT = 3;

  public static final int SHOOTER_PORT = 2; 
  public static final int CLIMB_PORT = 3; // TODO: real port num
  public static final int INTAKE_PORT = 8; // TODO: real port num
  public static final int BELT_PORT = 2849; // TODO: real port num
  public static final int LINE_BREAK = 11; // TODO: real port num


  public static final I2C.Port I2C_PORT = I2C.Port.kMXP;

  public static final XboxController XBOX_CONTROLLER = new XboxController(0);

  public static final Logger LOGGER = new Logger();
  public static final Logger.Level INFO = Logger.Level.INFO;
  public static final Logger.Level WARN = Logger.Level.WARN;
  public static final Logger.Level CRIT = Logger.Level.CRIT;
}
