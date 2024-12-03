package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.libs.MiniPID;

public class ArmPIDSubsystem {
    private double pidOutput;
    private MiniPID pid;
    private Telemetry telemetry;
    private DcMotor arm;
    public int setPoint = 0;
    private Gamepad gamepad;

    public ArmPIDSubsystem(Telemetry telemetry, HardwareMap hardwareMap, Gamepad gamepad) {//inicializa el subsistema
        pid = new MiniPID(0.1,0,0); //inicializa el pid
        pid.setSetpoint(setPoint);//valor deseado
        pid.setOutputLimits(-0.7, 0.7);//límites del pid(límites del motor)
        this.telemetry = telemetry;
        this.arm = hardwareMap.get(DcMotor.class, "Arm");
        this.gamepad = gamepad;
    }

    public void periodic() {
        if(gamepad.a) {
            setPoint = 200;
        } else if(gamepad.b) {
            setPoint = 0;
        }


        pid.setSetpoint(setPoint);//valor deseado
        pidOutput = pid.getOutput(arm.getCurrentPosition());//valor actual
        arm.setPower(pidOutput);
        telemetry.addData("PID Output", pidOutput);


    }
    public void disableperiodic () {
        telemetry.addData("Arm", arm.getCurrentPosition());
    }
}
