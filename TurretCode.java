/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.networktables.NetworkTableEntry;

import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.Subsystems.Limelight;

public class Robot extends TimedRobot {

  private int count = 1;
  private long currentTime = 0;

  private WPI_TalonSRX m8 = new WPI_TalonSRX(8);

  @Override
  public void robotInit() {
  }

  @Override
  public void robotPeriodic() {
    // m8.set(ControlMode.PercentOutput, -0.25);
    // Shooter.shooter.set(ControlMode.PercentOutput, 0.5);
    // System.out.println(Shooter.shooter.getSelectedSensorVelocity());
  }

  @Override

  public void autonomousInit() {
    
  }
  
  @Override
  public void autonomousPeriodic() {
    StatesSelector.getRobotState();
    
  }

  @Override
  public void teleopInit() {
   
  }

  @Override
  public void teleopPeriodic() {
    StatesSelector.getRobotState();
    
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
    

  }
}
