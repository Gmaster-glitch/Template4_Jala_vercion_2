package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

public class MecanumDriveSubsystem {
    private Gamepad gamepad;
    private DcMotor FL;
    //asigna el motor derecho superior
    private DcMotor FR;
    //asigna el motor izquierdo inferior
    private DcMotor BL;
    //asigna el motor derecho inferior
    private DcMotor BR;
    boolean debounce = true;
    private GyroscopeSubsystem navx;


    public MecanumDriveSubsystem(HardwareMap hardwareMap, Gamepad gamepad) {
        this.gamepad = gamepad;

        //asigna el motor izquierdo superior
        FL = hardwareMap.get(DcMotor.class,"FL");
        //asigna el motor derecho superior
        FR = hardwareMap.get(DcMotor.class,"FR");
        //asigna el motor izquierdo inferior
        BL = hardwareMap.get(DcMotor.class,"BL");
        //asigna el motor derecho inferior
        BR = hardwareMap.get(DcMotor.class,"BR");

        navx = GyroscopeSubsystem.getInstance(hardwareMap);
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
    }




    public void periodic(){

        if (gamepad.y) { //corre si presionas el boton a (X en el control de play)
            //asigna las potencias a los motores para avanzar
            moveUp();
        }
        else if (gamepad.a) { //corre si no se está presionando a pero se presiona b
            //asigna las potencias a los motores para retroceder
            moveDown();

        }else if (gamepad.x) { //corre si no se está presionando a pero se presiona b
            //asigna las potencias a los motores para retroceder
            moveLeft();

        } else if (gamepad.b) { //corre si no se está presionando a pero se presiona b
            //asigna las potencias a los motores para retroceder
            moveRight();

        } else { //corre si no estás presionando a ni b
            stop();
        }


    }

    public void moveUp(){
        setMotors(0.5,0.5,0.5,0.5);
    }
    public void moveDown(){
        setMotors(-0.5,-0.5,-0.5,-0.5);
    }
    public void moveLeft(){
        setMotors(-0.5,0.5,0.5,-0.5);
    }
    public void moveRight(){
        setMotors(0.5,-0.5,-0.5,0.5);
    }

    public void stop(){
        setMotors(0,0,0,0);
    }

    public void setMotors(double powerFrontLeft, double powerFrontRight, double powerBackLeft, double powerBackRight){
        FL.setPower(powerFrontLeft);
        FR.setPower(powerFrontRight);
        BL.setPower(powerBackLeft);
        BR.setPower(powerBackRight);
    }








}




















/*
    public void goToDetection(AprilTagDetection detection){
        while (detection.rawPose.x > 5){
            moveRight();
        }
        stop();
    }
 */