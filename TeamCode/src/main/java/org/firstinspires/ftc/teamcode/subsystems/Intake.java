package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Intake {
    private Gamepad gamepad;
    private Telemetry telemetry;
    private CRServo intake;
    public Intake (HardwareMap hardwareMap, Gamepad gamepad, Telemetry telemetry){
        this.telemetry = telemetry;
        this.gamepad = gamepad;
        this.intake = hardwareMap.get(CRServo.class, "intake");
    }

    public void dentro () {
        intake.setPower(0.5);
    }

    public void fuera () {
        intake.setPower(-0.5);
    }

    public void AAAAAALLLLLLLLLLLLLLTTTTTTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOYOYAESTUVEENESTOSJUEGOS () {
        intake.setPower(0);
    }

    public void periodic () {

        telemetry.addData("R", gamepad.right_trigger);
        telemetry.addData("L", gamepad.left_trigger);
        telemetry.addData("power", intake.getPower());

        if (gamepad.right_trigger > 0) {
            dentro();
        } else if (gamepad.left_trigger > 0) {
            fuera();
        } else {
            AAAAAALLLLLLLLLLLLLLTTTTTTOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOYOYAESTUVEENESTOSJUEGOS();
        }
    }
}
