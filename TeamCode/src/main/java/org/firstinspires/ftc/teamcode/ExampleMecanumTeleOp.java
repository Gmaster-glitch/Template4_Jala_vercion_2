package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ViperslidePIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.piston;

//import org.firstinspires.ftc.teamcode.subsystems.AdvancedMecanumSubsystem;

@Autonomous
public class ExampleMecanumTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        GoBildaPinpointDriver gps = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        gps.initialize();
        gps.resetPosAndIMU();

        gps.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        Arm itadori = new Arm(hardwareMap, telemetry, gamepad2);
        piston excavadora = new piston(hardwareMap, gamepad2, telemetry);
        MecanumDriveSubsystem drive = new MecanumDriveSubsystem(hardwareMap, gamepad1, telemetry); //iniciliza el subsistema de mecanum drive
        ViperslidePIDSubsystem viper = new ViperslidePIDSubsystem(telemetry, hardwareMap, gamepad2);//Listo
        while (opModeInInit()) {
            gps.getPosition().getX(DistanceUnit.INCH);
            gps.getPosition().getY(DistanceUnit.INCH);
            gps.update();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();

        }
        waitForStart();
        itadori.medio();

        while (viper.viperR.getCurrentPosition() < 1000) {
            viper.specimen2();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.update();
        }

        while (gps.getPosition().getX(DistanceUnit.INCH) < 28) {
            gps.update();
            drive.moveUp();
            viper.specimen2();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }

        ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
        while (timer.time() < 1000) {
            drive.stop();
            viper.specimen2();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }

        while (viper.viperR.getCurrentPosition() > 1000) {
            viper.setPoint = 1000;
            viper.pid();
            excavadora.peridoic();
            drive.stop();
            gps.update();
        }


        while (gps.getPosition().getX(DistanceUnit.INCH) > 20) {
            gps.update();
            drive.moveDown();
            viper.alpiso();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getPosition().getY(DistanceUnit.INCH) < 36) {
            gps.update();
            drive.moveRight();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getPosition().getX(DistanceUnit.INCH) < 48) {
            gps.update();
            drive.moveUp();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getPosition().getY(DistanceUnit.INCH) < 45) {
            gps.update();
            drive.moveRight();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getPosition().getX(DistanceUnit.INCH) > 10) {
            gps.update();
            drive.moveDown();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getPosition().getX(DistanceUnit.INCH) < 48) {
            gps.update();
            drive.moveUp();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getPosition().getY(DistanceUnit.INCH) < 56) {
            gps.update();
            drive.moveRight();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getPosition().getX(DistanceUnit.INCH) > 10) {
            gps.update();
            drive.moveDown();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        /*while (gps.getPosition().getX(DistanceUnit.INCH) < 15) {
            drive.moveUp();
            gps.update();
            telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
            telemetry.update();
        }
        while (gps.getHeading() != 180) {
            drive.rotateRight();
            gps.update();
        }

        while (gps.getPosition().getX(DistanceUnit.INCH) < 10) {
            drive.Lento();
            gps.update();
            viper.setPoint = 1000;
            viper.pid();
        }
        drive.stop();
        while (viper.viperR.getCurrentPosition() < 1900) {
            viper.setPoint = 1900;
            viper.pid();
        }*/

        while (true) {
            drive.stop();
            viper.periodic();
            viper.pid();
            excavadora.peridoic();
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH) );
            telemetry.addData("Y",gps.getPosition().getY(DistanceUnit.INCH) );
            telemetry.update();
        }





        /*AdvancedMecanumSubsystem drive = AdvancedMecanumSubsystem.getInstance(hardwareMap, telemetry, gamepad1);
        waitForStart();
        while (opModeIsActive()){
            drive.teleopPeriodic();
            telemetry.update();
            FtcDashboard.getInstance().getTelemetry().update();*/


        }
    }

