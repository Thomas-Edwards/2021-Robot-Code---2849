// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.XboxController;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  private static final SimpleDateFormat LOG_FMT = new SimpleDateFormat("HH:mm:ss");

  private static enum Level {
    INFO,
    WARN,
    CRIT,
  }

  public static final int BACK_LEFT_DRIVE_PORT = 4;
  public static final int BACK_RIGHT_DRIVE_PORT = 5;
  public static final int FRONT_LEFT_DRIVE_PORT = 2;
  public static final int FRONT_RIGHT_DRIVE_PORT = 3;

  public static final String TEAM_COLOR = DriverStation.getAlliance().name();

  public static final int SHOOTER_PORT = 2; // TODO: real port num
  public static final int CLIMB_PORT = 3; // TODO: real port num
  public static final int INTAKE_PORT = 8; // TODO: real port num
  public static final int BELT_PORT = 2849; // TODO: real port num
  public static final int LINE_BREAK = 11; // TODO: real port num

  public static final I2C.Port I2C_PORT = I2C.Port.kOnboard;

  public static final XboxController XBOX_CONTROLLER = new XboxController(0);

  public static final Level INFO = Level.INFO;
  public static final Level WARN = Level.WARN;
  public static final Level CRIT = Level.CRIT;

  public static final double PI = 3.14159265358979323846264338327950288419716939937510;
  public static final double RADIUS = 3.0;
  public static final double CIRCUMFERENCE = 2 * PI * RADIUS * 4096; // About 18.8 inches

  public static void log(Object source, String message, Level lvl) {
    System.out.println(
        String.format(
            "[%s] (%s) @ %s -> %s",
            LOG_FMT.format(new Date(System.currentTimeMillis())),
            lvl,
            source.getClass().getName(),
            message));
  }
}
