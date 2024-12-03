package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Arm {
    private Gamepad gamepad;
    private DcMotor armMotor;
    private Telemetry telemetry;
    public Arm(HardwareMap hardwareMap, Telemetry telemetry, Gamepad gamepad) {//motor
        this.gamepad = gamepad;
        armMotor = hardwareMap.get(DcMotor.class,"Arm");
    }

    public void periodic(){

    }
}
