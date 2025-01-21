package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Gancho {
    private Gamepad gamepad;
    private Telemetry telemetry;
    private CRServo ganchoizquierdo;
    private CRServo ganchoderecho;
    public  Gancho (HardwareMap hardwareMap, Gamepad gamepad, Telemetry telemetry) {
        this.gamepad = gamepad;
        this.telemetry = telemetry;
        this.ganchoderecho = hardwareMap.get(CRServo.class, "derecho");
        this.ganchoizquierdo = hardwareMap.get(CRServo.class, "izquirdo");
    }

    public void periodic () {
            ganchoizquierdo.setPower(-gamepad.right_stick_y);
            ganchoderecho.setPower(gamepad.right_stick_y);

    }
}
