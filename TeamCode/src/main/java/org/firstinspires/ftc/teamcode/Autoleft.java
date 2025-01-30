package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ViperslidePIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.piston;

//import org.firstinspires.ftc.teamcode.subsystems.AdvancedMecanumSubsystem;

@Autonomous
public class Autoleft extends LinearOpMode {
    @Override
    public void runOpMode() {
        GoBildaPinpointDriver gps = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        gps.initialize();
        gps.resetPosAndIMU();

        gps.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);
        Arm itadori = new Arm(hardwareMap,telemetry, gamepad2);
        piston excavadora = new piston(hardwareMap,gamepad2,telemetry);
        MecanumDriveSubsystem drive = new MecanumDriveSubsystem(hardwareMap, gamepad1, telemetry); //iniciliza el subsistema de mecanum drive
        ViperslidePIDSubsystem viper = new ViperslidePIDSubsystem(telemetry, hardwareMap, gamepad2);//Listo
        while (opModeInInit()){
            gps.getPosition().getX(DistanceUnit.INCH);
            gps.getPosition().getY(DistanceUnit.INCH);
            gps.update();
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH) );
            telemetry.update();

        }
        waitForStart();
        itadori.arriba();

        while (gps.getPosition().getX(DistanceUnit.INCH) < 10) {
            gps.update();
            drive.moveUp();
            excavadora.peridoic();
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH) );
            telemetry.addData("Y",gps.getPosition().getY(DistanceUnit.INCH) );
            telemetry.update();
        }
        drive.stop();
        while  (gps.getPosition().getX(DistanceUnit.INCH) != 0 ) {
            gps.resetPosAndIMU();
            sleep(1000);
            while (true) {
                drive.stop();
                viper.periodic();
                viper.pid();
                excavadora.peridoic();
                telemetry.addData("X", gps.getPosition().getX(DistanceUnit.INCH));
                telemetry.addData("Y", gps.getPosition().getY(DistanceUnit.INCH));
                telemetry.update();
            }
        }





        /*AdvancedMecanumSubsystem drive = AdvancedMecanumSubsystem.getInstance(hardwareMap, telemetry, gamepad1);
        waitForStart();
        while (opModeIsActive()){
            drive.teleopPeriodic();
            telemetry.update();
            FtcDashboard.getInstance().getTelemetry().update();*/


    }
}

