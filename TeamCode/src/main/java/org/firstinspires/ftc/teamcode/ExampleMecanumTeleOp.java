package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.AdvancedMecanumSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.ExamplePIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.TankDriveSubsystem;

@TeleOp
public class ExampleMecanumTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        AdvancedMecanumSubsystem drive = AdvancedMecanumSubsystem.getInstance(hardwareMap, telemetry, gamepad1);
        waitForStart();
        while (opModeIsActive()){
            drive.teleopPeriodic();
            telemetry.update();
            FtcDashboard.getInstance().getTelemetry().update();
        }
    }
}

