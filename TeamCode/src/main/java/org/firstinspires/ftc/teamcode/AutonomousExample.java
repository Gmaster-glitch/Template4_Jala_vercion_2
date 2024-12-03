package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;

@Autonomous
public class AutonomousExample extends LinearOpMode {
    @Override
    public void runOpMode() {
        MecanumDriveSubsystem drive = new MecanumDriveSubsystem(hardwareMap, gamepad1);
        waitForStart();
        drive.moveRight();
        sleep(1000);
        drive.moveLeft();
        sleep(1000);
        drive.stop();
    }

}
