package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.AdvancedMecanumSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ArmPIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ViperslidePIDSubsystem;

@TeleOp //dice que el código puede correr en el modo manual
public class Voltec27788 extends LinearOpMode {
    static String robotName = "equipo 3";
    @Override
    public void runOpMode() {
        //TankDriveSubsystem drive = new TankDriveSubsystem(hardwareMap, gamepad1); //iniciliza el subsistema de tank drive
        //MecanumDriveSubsystem drive = new MecanumDriveSubsystem(hardwareMap, gamepad1, telemetry); //iniciliza el subsistema de mecanum drive
        //Arm arm = new Arm(hardwareMap,telemetry,gamepad2);
        //ArmPIDSubsystem arm = new ArmPIDSubsystem(telemetry,hardwareMap,gamepad1);
        //Claw claw = new Claw(hardwareMap,telemetry,gamepad2);
        //SubsystemTemplate subsystem = new SubsystemTemplate(hardwareMap,telemetry,gamepad1);
        AdvancedMecanumSubsystem drive = new AdvancedMecanumSubsystem(hardwareMap, telemetry, gamepad1);
        //ViperslidePIDSubsystem viper = new ViperslidePIDSubsystem(telemetry, hardwareMap, gamepad2);

        while (opModeInInit()) {
          //  viper.disableperiodic();
            //arm.disableperiodic();
            telemetry.update();
        }

        waitForStart(); //espera a que le vuelvas a dar play



        while (opModeIsActive()){ //corre mientras el programa este activo
            //drive.periodic();//corre el método periodic del subsistema
            //arm.periodic();
            //claw.periodic();
            //drive.periodic();
            //subsystem.periodic();
            drive.teleopPeriodic();
            //viper.periodic();
            telemetry.update();//actualiza la telemetría en la pantalla(agregada con .addData)
            FtcDashboard.getInstance().getTelemetry().update();
        }
    }
}

