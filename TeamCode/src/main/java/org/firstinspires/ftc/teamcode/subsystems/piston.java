package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.libs.MiniPID;

public class piston {
    private Gamepad gamepad;
    private Telemetry telemetry;
    private DcMotor excavadora;
    private double pidOutput;
    private MiniPID pid;
    public double setPoint = 1;
    public piston (HardwareMap hardwareMap, Gamepad gamepad, Telemetry telemetry) {
        pid = new MiniPID(0.01,0,0); //inicializa el pid
        pid.setSetpoint(setPoint);//valor deseado
        pid.setOutputLimits(-0.7, 0.4);//límites del pid(límites del motor)
        this.gamepad = gamepad;
        this.telemetry = telemetry;
        this.excavadora = hardwareMap.get(DcMotor.class, "Excavadora");
        excavadora.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        excavadora.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        excavadora.setDirection(DcMotorSimple.Direction.REVERSE);
        excavadora.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void disableperiodic () {
        telemetry.addData("Excavadora",excavadora.getCurrentPosition());

        //telemetry.addData()

    }

    public void WAIT () {
        setPoint = setPoint + 0;
    }

    public void peridoic () {
        if (gamepad.left_bumper) {
            if (setPoint >= 700) {
            } else {
                dentro();
            }
        } else if (gamepad.right_bumper) {
            fuera();
        } else if (gamepad.dpad_left) {
            excavadora.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            excavadora.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        } else if (gamepad.dpad_right) {
            centro();
        }else {
            WAIT();
        }


        pid.setSetpoint(setPoint);//valor deseado
        pidOutput = pid.getOutput(excavadora.getCurrentPosition());//valor actual
        excavadora.setPower(pidOutput);
        telemetry.addData("PID Output", pidOutput);
        telemetry.addData("setPoint", excavadora.getCurrentPosition());
    }

    public void dentro () {
        setPoint = setPoint + 15;
    }

    public void fuera () {
        setPoint = setPoint - 10;
    }

    public void centro () {
        setPoint = 0;
    }
}
