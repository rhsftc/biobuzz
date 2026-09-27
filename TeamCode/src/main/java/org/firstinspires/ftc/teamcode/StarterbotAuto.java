package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/*
    * This file includes an autonomous file for the goBILDA® StarterBot for the 2026-2027 FIRST® Tech Challenge.
    * It leverages a differential/Skid-Steer system for robot mobility, one motor driving an intake roller,
    * two servos which pull elements out of corners, and a high-speed launcher motor.
    * It is a simple example of how to use the StarterBot hardware in an autonomous program.
    * It drives forward for half a second, then stops. This is a very basic example which can score
    * LEAVE, PARK and ranking points in the autonomous period of a match.
    * It also includes a simple way to toggle whether the autonomous program will run or not,
    * by pressing the 'A' button on gamepad1.
    /TODO: Add more functionality to the autonomous program, such as starting locations and
    * launching pollen.
 */
@Autonomous(name = "Starterbot Auto", group = "Auto", preselectTeleOp = "StarterBot Teleop")
public class StarterbotAuto extends OpMode {

    RobotHardware robot = new RobotHardware(this);
    private boolean runAuto = true;
    private ElapsedTime timer = new ElapsedTime();

    @Override
    public void init() {
        robot.init();
        telemetry.addData("Status", "Initialized");
        telemetry.addLine("Press 'A' to toggle run opMode.");
        telemetry.update();
    }

    @Override
    public void init_loop() {
        runAuto = !gamepad1.a;
        telemetry.addData("Run Auto", runAuto);
    }

    @Override
    public void loop() {
        if (runAuto) {
            robot.arcadeDrive(.5, 0);
            timer.reset();
            // Drive for half a second
            while (timer.seconds() < .5) {
            }
            robot.arcadeDrive(0, 0);
        }
    }
}
