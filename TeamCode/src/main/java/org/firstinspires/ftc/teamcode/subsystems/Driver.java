package org.firstinspires.ftc.teamcode.subsystems;



import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Driver {
    private Gamepad gamepad;
    private DcMotor FL;
    private DcMotor FR;
    private DcMotor BL;
    private DcMotor BR;
    private Telemetry telemetry;
    double y = -gamepad.left_stick_y;
    double x = -gamepad.left_stick_x;

    public Driver(HardwareMap hardwareMap, Gamepad gamepad, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.gamepad = gamepad;

        //asigna el motor izquierdo superior
        FL = hardwareMap.get(DcMotor.class, "FL");
        //asigna el motor derecho superior
        FR = hardwareMap.get(DcMotor.class, "FR");
        //asigna el motor izquierdo inferior
        BL = hardwareMap.get(DcMotor.class, "BL");
        //asigna el motor derecho inferior
        BR = hardwareMap.get(DcMotor.class, "BR");

        FL.setDirection(DcMotorSimple.Direction.REVERSE);

        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }

    public void Periodic () {
        
    }
}
