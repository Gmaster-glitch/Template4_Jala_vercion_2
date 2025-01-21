package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

@Autonomous
public class AutonomousExample extends LinearOpMode {
    @Override
    public void runOpMode() {
        MecanumDriveSubsystem drive = new MecanumDriveSubsystem(hardwareMap, gamepad1, telemetry);

        
        waitForStart();
        drive.moveUp();
        sleep(400);
        drive.stop();
        sleep(1000);
        drive.moveDown();
        sleep(400);
        drive.stop();
        sleep(1000);
        drive.moveLeft();
        sleep(500);
        drive.stop();
        sleep(500);
        drive.moveUp();
        sleep(500);
        drive.stop();
    }

}