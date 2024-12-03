package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Claw {
    private Gamepad gamepad;
    private Servo clawServo;
    private Telemetry telemetry;
    public Claw(HardwareMap hardwareMap, Telemetry telemetry, Gamepad gamepad) {//servo
        this.gamepad = gamepad;
        this.telemetry = telemetry;
        this.clawServo = hardwareMap.get(Servo.class,"claw");
    }
    String clawState = "closed";
    boolean canRun = true;//debounce
    public void periodic(){
        if(gamepad.a) {
            if (canRun) {
                if (clawState.equals("closed")) {
                    clawServo.setPosition(0.3);
                    clawState = "open";
                } else {
                    clawServo.setPosition(0.1);
                    clawState = "closed";
                }
                canRun = false;
            }
        }else{
            canRun=true;
        }

        //Lo mismo que telemetry.addData("Claw State", clawState); pero para windows
        FtcDashboard.getInstance().getTelemetry().addData("Claw State", clawState);

    }
}
