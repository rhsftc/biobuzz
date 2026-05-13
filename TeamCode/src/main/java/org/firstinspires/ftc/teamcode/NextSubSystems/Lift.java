package org.firstinspires.ftc.teamcode.NextSubSystems;

import org.firstinspires.ftc.teamcode.TelemetryUpdateCommand;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.ftc.ActiveOpMode;
import dev.nextftc.hardware.controllable.RunToPosition;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.positionable.SetPosition;
import dev.nextftc.hardware.powerable.SetPower;

public class Lift implements Subsystem {
    public static final Lift INSTANCE = new Lift();

    private Lift() {
    }

    private MotorEx motor = new MotorEx("motor");

    private ControlSystem controlSystem = ControlSystem.builder()
            .posPid(0.005, 0, 0)
            .elevatorFF(0)
            .build();

    public Command toLow = new RunToPosition(controlSystem, 0).requires(this);
    public Command toMiddle = new RunToPosition(controlSystem, 500).requires(this);
    public Command toHigh = new RunToPosition(controlSystem, 1200).requires(this);
//    public Command debugLiftPosition = new TelemetryUpdateCommand(this, ActiveOpMode.telemetry(), "Lift Position", () -> motor.getCurrentPosition());
    @Override
    public void periodic() {
        motor.setPower(controlSystem.calculate(motor.getState()));
    }
}