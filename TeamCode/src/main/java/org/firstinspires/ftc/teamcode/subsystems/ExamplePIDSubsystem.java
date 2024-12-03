package org.firstinspires.ftc.teamcode.subsystems;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.libs.MiniPID;

public class ExamplePIDSubsystem {
    private double pidOutput;
    private MiniPID pid;
    private Telemetry telemetry;

    public ExamplePIDSubsystem(Telemetry telemetry, double p, double i, double d) {//no lo utilizaremos hoy
        pid = new MiniPID(p, i, d);
        pid.setSetpoint(90);//valor deseado
        pid.setOutputLimits(-0.7, 0.7);//limites del pid
        this.telemetry = telemetry;

    }

    public void periodic() {
        pidOutput = pid.getOutput(10);//valor actual
        telemetry.addData("PID Output", pidOutput);
    }

    public double getOutput() {
        return pidOutput;
    }


}
