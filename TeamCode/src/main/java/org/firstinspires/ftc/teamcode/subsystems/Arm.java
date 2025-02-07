package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private Gamepad gamepad;
    private Servo armMotorL;
    boolean debounce = true;
    private Telemetry telemetry;
    public Arm(HardwareMap hardwareMap, Telemetry telemetry, Gamepad gamepad) {//motor
        this.gamepad = gamepad;
        this.telemetry = telemetry;
        armMotorL = hardwareMap.get(Servo.class,"ArmL");

    }

    public void disableperiodic () {
        telemetry.addData("Arml", armMotorL.getPosition());
    }

    public void GUARDA () {
        armMotorL.setPosition(0);
    }

    public void medio () {
        armMotorL.setPosition(0.5);
    }

    public void suelta () {
        armMotorL.setPosition(0.7);
    }

    public void periodic() {
        telemetry.addData("debounce",debounce);

        if (gamepad.dpad_up) {
        } else {
            if (gamepad.b) {
                GUARDA();
            } else if (gamepad.x) {
                medio();
            } else if (gamepad.a) {
                suelta();
            }
        }
    }
}
