package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import org.firstinspires.ftc.teamcode.subsystems.AdvancedMecanumSubsystem;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.Gancho;
import org.firstinspires.ftc.teamcode.subsystems.Garra;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.Pruebademotores;
import org.firstinspires.ftc.teamcode.subsystems.ViperslidePIDSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.piston;

@TeleOp //dice que el código puede correr en el modo manual
public class Voltec27788 extends LinearOpMode {
    static String robotName = "equipo negro";
    @Override
    public void runOpMode() {
        //Gancho Yūji = new Gancho(hardwareMap, gamepad2, telemetry);//listo
        Garra ultideJeff = new Garra(hardwareMap, telemetry, gamepad2);
        piston excavadora = new piston(hardwareMap, gamepad2, telemetry);//ocupa pruba
        //Pruebademotores test = new Pruebademotores(hardwareMap, gamepad1, telemetry);
        //TankDriveSubsystem drive = new TankDriveSubsystem(hardwareMap, gamepad1); //iniciliza el subsistema de tank drive
        MecanumDriveSubsystem drive = new MecanumDriveSubsystem(hardwareMap, gamepad1, telemetry); //iniciliza el subsistema de mecanum drive
        Arm arm = new Arm(hardwareMap,telemetry,gamepad2);
        //ArmPIDSubsystem arm = new ArmPIDSubsystem(telemetry,hardwareMap,gamepad2);
        Intake intake = new Intake(hardwareMap, gamepad2, telemetry);//listo
        //SubsystemTemplate subsystem = new SubsystemTemplate(hardwareMap,telemetry,gamepad1);
        //AdvancedMecanumSubsystem advance = new AdvancedMecanumSubsystem(hardwareMap, telemetry, gamepad1);
        ViperslidePIDSubsystem viper = new ViperslidePIDSubsystem(telemetry, hardwareMap, gamepad2);//Listo
        GoBildaPinpointDriver gps = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");
        gps.initialize();
        gps.resetPosAndIMU();
        gps.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD);

        GamepadEx gamepadEx = new GamepadEx(gamepad2);

        //new B()


        while (opModeInInit()) {
            arm.disableperiodic();
            viper.disableperiodic();
            //test.disableperiodic();
            excavadora.disableperiodic();
            telemetry.update();
        }

        waitForStart(); //espera a que le vuelvas a dar play



        while (opModeIsActive()){ //corre mientras el programa este activo
            drive.periodic();//corre el método periodic del subsistema
            arm.periodic();
            ultideJeff.periodic();
            //Yūji.periodic();
            excavadora.peridoic();
            intake.periodic();
            //drive.periodic();
            //subsystem.periodic();
            //drive.teleopPeriodic();
            viper.periodic();
            viper.pid();
            //test.periodic();
            telemetry.addData("X",gps.getPosition().getX(DistanceUnit.INCH));
            telemetry.addData("Y",gps.getPosition().getY(DistanceUnit.INCH));
            gps.update();
            telemetry.addData("viperL", viper.viperL.getPower());
            telemetry.addData("viperR", viper.viperR.getPower());
            telemetry.addData("stick",-gamepad2.left_stick_y);
            telemetry.update();//actualiza la telemetría en la pantalla(agregada con .addData)
            FtcDashboard.getInstance().getTelemetry().update();
        }
    }
}

