package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Pruebademotores {
    public Gamepad gamepad;
    private DcMotor FL;
    //asigna el motor derecho superior
    private DcMotor FR;
    //asigna el motor izquierdo inferior
    private DcMotor BL;
    //asigna el motor derecho inferior
    private DcMotor BR;
    private Telemetry telemetry;

    public Pruebademotores(HardwareMap hardwareMap, Gamepad gamepad, Telemetry telemetry) {
        this.gamepad = gamepad;
        this.telemetry = telemetry;

        //asigna el motor izquierdo superior
        FL = hardwareMap.get(DcMotor.class,"FL");
        //asigna el motor derecho superior
        FR = hardwareMap.get(DcMotor.class,"FR");
        //asigna el motor izquierdo inferior
        BL = hardwareMap.get(DcMotor.class,"BL");
        //asigna el motor derecho inferior
        BR = hardwareMap.get(DcMotor.class,"BR");

        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        //BL.setDirection(DcMotorSimple.Direction.REVERSE);
        //BR.setDirection(DcMotorSimple.Direction.REVERSE);


    }


    public void disableperiodic () {
        telemetry.addData("FL", FL.getDirection());
        telemetry.addData("FR", FR.getDirection());
        telemetry.addData("BL", BL.getDirection());
        telemetry.addData("BR", BR.getDirection());
    }


    public void periodic () {
        if (gamepad.a && gamepad.back) {
            FL.setPower(0.5);
        } else if(gamepad.b && gamepad.back) {
            FR.setPower(0.5);
        } else if (gamepad.x && gamepad.back) {
            BL.setPower(0.5);
        } else if (gamepad.y && gamepad.back) {
            BR.setPower(0.5);
        } else {
            FR.setPower(0);
            FL.setPower(0);
            BR.setPower(0);
            BL.setPower(0);
        }
    }
}
