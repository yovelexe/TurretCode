package frc.robot.Subsystems;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Controller;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import java.lang.Math;


public class Limelight{

    //variables 
    public static WPI_TalonSRX Turret = new WPI_TalonSRX(1);

    static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    static NetworkTableEntry ty = table.getEntry("ty");
   
    //heights
    final static public double targerheightinches = 107;
    final static public double cameraheightinches = 20;
    
    //degrees
    final static public double limelightMountingAngle = 45;
    final static public double targetOffsetAngle_Vertical = ty.getDouble(0.0);

    //convert degrees to radians
    final static public double angleToGoalDegrees = limelightMountingAngle + targetOffsetAngle_Vertical;
    final static public double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);


    
    static public double angleFromHorizontalAxis = 35;
    static public double degToRad = Math.PI / 180, radToDeg = 180 / Math.PI;

    //PID config
    static double kP = 0;
    static double kI = 0;
    static double kD = 0;
    static PIDController TurretPID = new PIDController(kP, kI, kD);

    //Methods:

    //checks if the limelight regonize any targets
    static public double isValidTarget()
    {
      return (NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0.0));
    }

    //get the tx from target
    static public double getTx()
    {
        return (NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0));
    }

    //get the ty from target
    static public double getTy() 
    {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0);
    }

    //operations:

    //calculate distance from target
    public static void getDstFromTarget()
    {
    double distanceFromLimelightToGoalInches = (targerheightinches - cameraheightinches)/Math.tan(angleToGoalRadians);
    //convert the inches to cm
    double distanceFromTargetCm = distanceFromLimelightToGoalInches * 2.54;
    System.out.print(distanceFromTargetCm);
    }

    //aim the turret at the target 
    public static void turretController()
    {
      if(Controller.isPressed(Controller.X_Button))
      {
        Turret.set(TurretPID.calculate(Limelight.getTx(), 0));
        
      }

      if(Limelight.getTx() >= -3 || Limelight.getTx() <= 3)
      {
        Turret.stopMotor();
      }
      
      
    }
  }

