package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.libs.MiniPID;

public class ArmPIDSubsystem {
    private double pidOutput;
    private MiniPID pid;
    private Telemetry telemetry;
    private Servo armL;
    private Servo armR;
    public int setPoint = 0;
    private Gamepad gamepad;

    public ArmPIDSubsystem(Telemetry telemetry, HardwareMap hardwareMap, Gamepad gamepad) {//inicializa el subsistema
        pid = new MiniPID(0.1,0,0); //inicializa el pid
        pid.setSetpoint(setPoint);//valor deseado
        pid.setOutputLimits(-0.7, 0.7);//límites del pid(límites del motor)
        this.telemetry = telemetry;
        this.armL = hardwareMap.get(Servo.class, "ArmL");
        this.armR = hardwareMap.get(Servo.class, "ArmR");
        this.gamepad = gamepad;
        armR.setDirection(Servo.Direction.REVERSE);
    }

    public void periodic() {
        if(gamepad.a) {
            setPoint = 180;
        } else if(gamepad.b) {
            setPoint = 0;
        }


        pid.setSetpoint(setPoint);//valor deseado
        pidOutput = pid.getOutput(armL.getPosition());//valor actual
        armL.setPosition(pidOutput);
        telemetry.addData("PID Output", pidOutput);
        telemetry.addData("ArmR", armR.getPosition());
        telemetry.addData("ArmL", armL.getPosition());


    }
    public void disableperiodic () {
        telemetry.addData("ArmR", armR.getPosition());
        telemetry.addData("ArmL", armL.getPosition());
    }
}
