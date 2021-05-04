// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  PWMVictorSPX m1 = new PWMVictorSPX(0);
  PWMVictorSPX m2 = new PWMVictorSPX(1);
  Joystick controller = new Joystick(0);

  boolean locked = false;
  double speed = .5;
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    if(!locked){
      m2.set(controller.getRawAxis(1) * -speed);
      m1.set(controller.getRawAxis(3) * speed);
    } else {
      m2.set(0.0);
      m1.set(0.0);
    }
    //if A is pressd locked = false;
    if(controller.getRawButtonPressed(2)){
      locked = false; 
    }
    //if B is pressed locked = true;
    if(controller.getRawButtonPressed(3)){
      locked = true;
    }
    //if Y is pressed speed = cringle (aka slow lmao)
    if(controller.getRawButtonPressed(4)){
      speed = .5;
    }
    //if X is pressed speed = FAAAAAAAAAAAAST
    if(controller.getRawButtonPressed(1)){
      speed = .8;
    }
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
