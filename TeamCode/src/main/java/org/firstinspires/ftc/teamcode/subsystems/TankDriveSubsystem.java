package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.libs.MiniPID;

public class TankDriveSubsystem {

    //crea las variables
    private DcMotor motorL;
    private DcMotor motorR;
    private Gamepad gamepad;

    public TankDriveSubsystem(HardwareMap hardwareMap, Gamepad gamepad) {
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
            moveForward();
        }
        else if (gamepad.b) { //corre si no se está presionando a pero se presiona b
            //asigna las potencias a los motores para retroceder
            moveBackward();
        } else { //corre si no estás presionando a ni b
            stop();
        }
    }

    public void stop(){
        motorL.setPower(0);
        motorR.setPower(0);
    }
    public void moveForward(){
        motorL.setPower(0.5);
        motorR.setPower(0.5);
    }

    public void moveBackward(){
        motorL.setPower(-0.5);
        motorR.setPower(-0.5);
    }

    public void enableBreak() {
        motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }
    public void disableBreak() {
        motorL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void resetEncoders(){
        motorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setMotors(double powerL, double powerR){
        motorL.setPower(powerL);
        motorR.setPower(powerR);
    }


    public void movePosition(int targetPosition){
        resetEncoders();
        while (targetPosition-motorL.getCurrentPosition()>5){
            moveForward();
        }
        stop();
    }
    public void movePositionPID(int targetPosition){
        resetEncoders();
        MiniPID pid = new MiniPID(0.2,0,0);
        pid.setOutputLimits(-0.6,0.6);
        pid.setSetpoint(targetPosition);
        while (Math.abs(targetPosition-motorL.getCurrentPosition())>5){
            double output = pid.getOutput(motorL.getCurrentPosition());
            setMotors(output,output);
        }
        stop();
    }
    public void moveDSensor(DistanceSensor sensor){
        while (sensor.getDistance(DistanceUnit.CM)>10){
            moveForward();
        }
        stop();
    }

}
