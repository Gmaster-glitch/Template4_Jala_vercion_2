package org.firstinspires.ftc.teamcode.subsystems;


//import static org.firstinspires.ftc.teamcode.utils.calculateRotation;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class SubsystemTemplate {
    private HardwareMap hardwareMap;
    private Telemetry telemetry;
    public Gamepad gamepad;

    public SubsystemTemplate(HardwareMap hardwareMap, Telemetry telemetry, Gamepad gamepad){
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        this.gamepad = gamepad;
    }
    public void periodic(){

    }
}