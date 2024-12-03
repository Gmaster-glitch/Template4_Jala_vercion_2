package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class SubsystemExample {

    //crea las variables
    private DcMotor motorL;
    private DcMotor motorR;
    private Gamepad gamepad;

    public SubsystemExample(HardwareMap hardwareMap, Gamepad gamepad) {
        this.gamepad = gamepad;
        //asigna el motor izquierdo
        motorL = hardwareMap.get(DcMotor.class,"leftMotor");
        //asigna el motor derecho
        motorR = hardwareMap.get(DcMotor.class,"rightMotor");
        //invierte el motor derecho
        motorR.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void periodic() {
        if (gamepad.a) { //corre si presionas el boton a (X en el control de play)
            //asigna las potencias a los motores para avanzar
            motorL.setPower(0.5);
            motorR.setPower(0.5);
        }
        else if (gamepad.b) { //corre si no se está presionando a pero se presiona b
            //asigna las potencias a los motores para retroceder
            motorL.setPower(-0.5);
            motorR.setPower(-0.5);
        } else { //corre si no estás presionando a ni b
            motorL.setPower(0);
            motorR.setPower(0);
        }
    }

    public void enableBreak() {
        motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void disableBreak() {
        motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

}
