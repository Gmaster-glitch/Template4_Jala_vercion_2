package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.libs.MiniPID;

public class ViperslidePIDSubsystem {
    private double pidOutput;
    private MiniPID pid;
    private Telemetry telemetry;
    private DcMotor viperR;
    private DcMotor viperL;
    public double setPoint = 1;
    private Gamepad gamepad;
    double x = 2/3;


    public ViperslidePIDSubsystem(Telemetry telemetry, HardwareMap hardwareMap, Gamepad gamepad) {//inicializa el subsistema
        pid = new MiniPID(0.01,0,0); //inicializa el pid
        pid.setSetpoint(setPoint);//valor deseado
        pid.setOutputLimits(-0.7, 0.7);//límites del pid(límites del motor)
        this.telemetry = telemetry;
        this.viperL = hardwareMap.get(DcMotor.class, "viperL");
        this.viperR = hardwareMap.get(DcMotor.class, "viperR");
        this.gamepad = gamepad;
        viperL.setDirection(DcMotorSimple.Direction.REVERSE);
        viperL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        viperR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        viperR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        viperR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        viperL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        setPoint = 0.5;
    }

    public void disableperiodic () {
        telemetry.addData("viperL",viperL.getCurrentPosition());
        telemetry.addData("viperR",viperR.getCurrentPosition());
        //telemetry.addData()

    }

    public void parriba () {
        setPoint = 2450;
    }

    public void alpiso () {
        setPoint = 2;
    }

    public void baja () {
        setPoint = setPoint - 5.5;
    }

    public void sube () {
        setPoint = setPoint + 5.5;
    }

    public void PURPLEEE () {
        setPoint = setPoint +0;
    }

    public void periodic() {

        if (-gamepad.left_stick_y > 0) {
            if (setPoint >= 3000) {
            } else {
                sube();
            }
        } else if (-gamepad.left_stick_y < 0) {
            if (setPoint <= 2) {
            } else {
                baja();
            }
        } else if (gamepad.y) {
            alpiso();
        } else if (gamepad.y || gamepad.dpad_up) {
            parriba();
        } else if (gamepad.dpad_down) {
            viperR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            viperR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            setPoint = 2;
        } else if (gamepad.back) {
            setPoint = setPoint - 2;
        } else{
            PURPLEEE();
        }
        pid.setSetpoint(setPoint);//valor deseado
        pidOutput = pid.getOutput(viperR.getCurrentPosition());//valor actual
        viperL.setPower(pidOutput);
        viperR.setPower(pidOutput);
        telemetry.addData("PID Output", pidOutput);
        telemetry.addData("setPointR", viperR.getCurrentPosition());

    }
}