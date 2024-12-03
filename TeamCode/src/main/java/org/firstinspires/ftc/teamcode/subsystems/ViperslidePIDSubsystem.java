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
        setPoint = 0.5;
    }

    public void disableperiodic() {
        telemetry.addData("viperL",viperL.getCurrentPosition());
        telemetry.addData("viperR",viperR.getCurrentPosition());

    }

    public void periodic() {
        if (gamepad.left_stick_y < 0) {
            if (setPoint >= 3100) {
            } else {
                setPoint = setPoint + 6;
            }
        } else if (gamepad.left_stick_y > 0) {
            if (setPoint <= 2) {
            } else {
                setPoint = setPoint - 6;
            }
        } else if (gamepad.y) {
            setPoint = 1;
        } else if (gamepad.x) {
            setPoint = 3100;
        } else if (gamepad.dpad_down) {
            viperL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            viperL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            setPoint = 0.5;
        } else if (gamepad.back) {
            setPoint = setPoint - 2;
        } else {
            setPoint = setPoint + 0;
        }




        pid.setSetpoint(setPoint);//valor deseado
        pidOutput = pid.getOutput(viperL.getCurrentPosition());//valor actual
        viperL.setPower(pidOutput);
        viperR.setPower(pidOutput);
        telemetry.addData("PID Output", pidOutput);
        telemetry.addData("setPointL", viperL.getCurrentPosition());

    }
}