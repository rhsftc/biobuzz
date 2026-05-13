package org.firstinspires.ftc.teamcode;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;

import org.firstinspires.ftc.robotcore.external.Supplier;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class TelemetryUpdateCommand extends Command {
    private final Telemetry telemetry;
    private final String key;
    private final Supplier<Double> valueSupplier;  // Use a supplier for dynamic values

    public TelemetryUpdateCommand(Subsystem subsystem, Telemetry telemetry, String key, Supplier<Double> valueSupplier) {
        this.telemetry = telemetry;
        this.key = key;
        this.valueSupplier = valueSupplier;
        requires(subsystem);  // Requires the subsystem to run
    }

    @Override
    public void update() {
        telemetry.addData(key, valueSupplier.get());
        telemetry.update();
    }

    @Override
    public boolean isDone() {
        return false;
    }
}