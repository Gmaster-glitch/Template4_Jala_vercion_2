package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ViperslidePIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.piston;

@Autonomous
public class arrastra extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        GoBildaPinpointDriver gps = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        gps.initialize();
        gps.resetPosAndIMU();

        gps.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        Arm itadori = new Arm(hardwareMap, telemetry, gamepad2);
        piston excavadora = new piston(hardwareMap, gamepad2, telemetry);
        MecanumDriveSubsystem drive = new MecanumDriveSubsystem(hardwareMap, gamepad1, telemetry); //iniciliza el subsistema de mecanum drive
        while (opModeInInit()) {
            gps.getPosition().getX(DistanceUnit.INCH);
            gps.getPosition().getY(DistanceUnit.INCH);
            gps.update();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        waitForStart();
        itadori.arriba();

        while (gps.getPosition().getY(DistanceUnit.INCH) > -11) {
            gps.update();
            drive.moveLeft();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }

        while (gps.getPosition().getX(DistanceUnit.INCH) > -48) {
            gps.update();
            drive.moveDown();
            excavadora.peridoic();
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH) );
            telemetry.addData("Y",gps.getPosition().getY(DistanceUnit.INCH) );
            telemetry.update();
        }
        while (gps.getPosition().getY(DistanceUnit.INCH) > -20) {
            gps.update();
            drive.moveLeft();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getPosition().getX(DistanceUnit.INCH) < -10) {
            gps.update();
            drive.moveUp();
            excavadora.peridoic();
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH) );
            telemetry.addData("Y",gps.getPosition().getY(DistanceUnit.INCH) );
            telemetry.update();
        }
        while (gps.getPosition().getX(DistanceUnit.INCH) > -48) {
            gps.update();
            drive.moveDown();
            excavadora.peridoic();
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH) );
            telemetry.addData("Y",gps.getPosition().getY(DistanceUnit.INCH) );
            telemetry.update();
        }
        while (gps.getPosition().getY(DistanceUnit.INCH) > -41) {
            gps.update();
            drive.moveLeft();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getPosition().getX(DistanceUnit.INCH) < -10) {
            gps.update();
            drive.moveUp();
            excavadora.peridoic();
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH) );
            telemetry.addData("Y",gps.getPosition().getY(DistanceUnit.INCH) );
            telemetry.update();
        }
        while (true) {
            drive.stop();
            excavadora.peridoic();
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH) );
            telemetry.addData("Y",gps.getPosition().getY(DistanceUnit.INCH) );
            telemetry.update();
        }
    }
}
