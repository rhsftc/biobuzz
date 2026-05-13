package org.firstinspires.ftc.teamcode.NextSubSystems;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.ServoEx;
import dev.nextftc.hardware.positionable.SetPosition;

public class Claw implements Subsystem {
    public static final Claw INSTANCE = new Claw();
    private final ServoEx servo = new ServoEx("servo");

    private Claw() {
    }

    public Command open = new SetPosition(servo, 0.05).requires(this);
    public Command close = new SetPosition(servo, 0.0).requires(this);

}
