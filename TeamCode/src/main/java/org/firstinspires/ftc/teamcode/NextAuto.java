package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.NextSubSystems.Claw;
import org.firstinspires.ftc.teamcode.NextSubSystems.Lift;

import java.util.List;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.CommandManager;
import dev.nextftc.core.commands.delays.Delay;
import dev.nextftc.core.commands.groups.ParallelGroup;
import dev.nextftc.core.commands.groups.SequentialGroup;
import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.ActiveOpMode;
import dev.nextftc.ftc.NextFTCOpMode;

@Autonomous(name = "Next Auto", group = "Next")
public class NextAuto extends NextFTCOpMode {
    public NextAuto() {
        addComponents(
                new SubsystemComponent(Lift.INSTANCE, Claw.INSTANCE),
                CommandManager.INSTANCE
        );
    }

    private Command telemetryCommand() {
        return new TelemetryUpdateCommand(Lift.INSTANCE, telemetry, "Lift Position", () -> Lift.INSTANCE.motor.getCurrentPosition());
    }

    private Command autonomousRoutine() {
        return new SequentialGroup(
                Lift.INSTANCE.toHigh,
//                telemetryCommand(),
                new ParallelGroup(
                        Lift.INSTANCE.toMiddle,
                        Claw.INSTANCE.open
                ),
//                telemetryCommand(),
                new Delay(0.5),
                new ParallelGroup(
                        Claw.INSTANCE.close,
                        Lift.INSTANCE.toLow
                )
//                telemetryCommand()
        );
    }

    @Override
    public void onStartButtonPressed() {
        autonomousRoutine().setName("Autonomous Routine");
        telemetry.addData("Scheduling: ", autonomousRoutine());
        autonomousRoutine().schedule();
        telemetry.update();
    }
}