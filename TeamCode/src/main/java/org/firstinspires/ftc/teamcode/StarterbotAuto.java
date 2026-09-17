package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

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
            // Wait for half a second
            while (timer.seconds() < .5) {
            }
            robot.arcadeDrive(0, 0);
        }
    }
}
