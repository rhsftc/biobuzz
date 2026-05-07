package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.NextSubSystems.Claw;

import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.NextFTCOpMode;

@Autonomous(name = "Next Auto", group = "Next")
public class NextAuto extends NextFTCOpMode {
    public NextAuto() {
        addComponents(
                new SubsystemComponent(Claw.INSTANCE, Claw.INSTANCE)
        );
    }
}