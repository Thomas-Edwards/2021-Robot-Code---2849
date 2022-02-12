package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.lang.Math;

public class AutoAlignCommand extends CommandBase{
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
    private final DriveSubsystem driveSubsystem;
    private boolean alignFinished = false;
    public double maxShooting;
    public double minShooting;

    /**
     * 
     * @param subsystem
     */

    public AutoAlignCommand(DriveSubsystem subsystem){
        driveSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(subsystem);
    }


    @Override
    public void initialize() {
        System.out.println("initialized");
        alignFinished = false;
    }


    public void detectTarget() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry ty = table.getEntry("ty");
        NetworkTableEntry ta = table.getEntry("ta");
        NetworkTableEntry ts = table.getEntry("ts");

        double x = tx.getDouble(0.0);
        double y = ty.getDouble(0.0);
        double area = ta.getDouble(0.0);
        double skew = ts.getDouble(0.0);

        System.out.println(x + " " + y + " " + area);
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);
        SmartDashboard.putNumber("LimelightSkew", skew);
        //min shooting range, 5 ft, max 30 ft
    }

    public void setRightPower(final double power) {
        driveSubsystem.BACK_RIGHT_DRIVE.set(power);
        driveSubsystem.FRONT_RIGHT_DRIVE.set(power);
        System.out.println("right speed: " + power);
      }

      public void setLeftPower(final double power) {
        driveSubsystem.BACK_LEFT_DRIVE.set(-power);
        driveSubsystem.FRONT_LEFT_DRIVE.set(-power);
        System.out.println("left speed: " + power);
      }
    
    public double getX() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        NetworkTableEntry tv = table.getEntry("tv");
        double x;

        double isThereLimelight = tv.getDouble(0.0);
        if(isThereLimelight == 0){
            x= Double.MIN_VALUE;
        }else{
            x =  tx.getDouble(Double.MIN_VALUE);
        }
        System.out.println(isThereLimelight);
        System.out.println(x);
        SmartDashboard.putNumber("LimelightX", x);
        return x;
    }
    
     public double getAngle() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry ts = table.getEntry("ts");
 
        double Angle = ts.getDouble(0.0);
        SmartDashboard.putNumber("LimelightX", Angle);
 
        return Angle;
     }
    
    
  

    @Override
    public void execute() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        NetworkTableEntry tx = table.getEntry("tx");
        System.out.println("is executing");
        double max = 3;
        double min = -3;
        //detect target
        System.out.println(getX());
        double x = getX();
        System.out.println(x);
        //if center, end
        
        System.out.println("x is "+ x);
        if(x == Double.MIN_VALUE){
            System.out.println("Couldn't detect limelight");
            return;
        }
        else if(x <= max && x >= min){
            //setLeftPower(0);
            //setRightPower(0);
            System.out.println("We are alined");
            alignFinished = true;
        }
        else if(x > max){
            setLeftPower(0);
            setRightPower(.25);
            System.out.println("4");
        }else if(x < min){
            setRightPower(0);
            setLeftPower(.25);
            System.out.println("5");
        }
        //end
    }

    @Override
    public boolean isFinished() {
        
        return alignFinished;
    }
   @Override
    public void end(boolean interrupted){
        System.out.println("end");
        setLeftPower(0);
        setRightPower(0);
    }
    
}
