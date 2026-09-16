package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous(name = "Starterbot Auto", group = "Auto", preselectTeleOp = "StarterBot Teleop")
public class StarterbotAuto extends OpMode {

    RobotHardware robot = new RobotHardware(this);
    private boolean runAuto = true;

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
            robot.arcadeDrive(0, 0);
        }
    }
}
