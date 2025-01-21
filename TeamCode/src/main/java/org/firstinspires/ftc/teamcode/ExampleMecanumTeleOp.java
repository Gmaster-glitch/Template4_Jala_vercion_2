package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

//import org.firstinspires.ftc.teamcode.subsystems.AdvancedMecanumSubsystem;

@Autonomous
public class ExampleMecanumTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        GoBildaPinpointDriver gps = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");

        while (!opModeInInit()){
            gps.getPosition().getX(DistanceUnit.INCH);
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH) );
            telemetry.update();

        }
        waitForStart();
        while (gps.getPosition().getX(DistanceUnit.INCH) < 20) {

        }


        /*AdvancedMecanumSubsystem drive = AdvancedMecanumSubsystem.getInstance(hardwareMap, telemetry, gamepad1);
        waitForStart();
        while (opModeIsActive()){
            drive.teleopPeriodic();
            telemetry.update();
            FtcDashboard.getInstance().getTelemetry().update();*/


        }
    }

