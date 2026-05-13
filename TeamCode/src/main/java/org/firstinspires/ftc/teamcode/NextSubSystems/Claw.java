package org.firstinspires.ftc.teamcode.NextSubSystems;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.CRServoEx;
import dev.nextftc.hardware.impl.ServoEx;
import dev.nextftc.hardware.positionable.SetPosition;
import dev.nextftc.hardware.powerable.SetPower;

public class Claw implements Subsystem {
    public static final Claw INSTANCE = new Claw();
    private final CRServoEx servo = new CRServoEx("servo");

    private Claw() {
    }

    public Command open = new SetPower(servo, 1.0).requires(this);
    public Command close = new SetPower(servo, 0.0).requires(this);

}
