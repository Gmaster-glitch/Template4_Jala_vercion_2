package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.PerpetualCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Constants;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.common.commandbase.command.drive.FollowPathCommand;
import org.firstinspires.ftc.teamcode.common.commandbase.subsystem.Commandviper;
import org.firstinspires.ftc.teamcode.common.commandbase.subsystem.OpenClawCommand;
import org.firstinspires.ftc.teamcode.subsystems.Garra;
import org.firstinspires.ftc.teamcode.subsystems.ViperslidePIDSubsystem;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

@Autonomous (name = "Ayudaaaaaaaaaaaaaa")
public class dios extends LinearOpMode {
    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    private int pathState;
    ViperslidePIDSubsystem viper = new ViperslidePIDSubsystem(telemetry,hardwareMap,gamepad2);
    Garra garra = new Garra(hardwareMap, telemetry, gamepad2);
    public final Pose inicio = new Pose(9, 55, 0);
    private final Pose sample1 = new Pose(32.74766355140187, 65.49532710280374, 0);
    private final Pose recoge1 = new Pose(52.93457943925233, 32.971962616822424, 0);
    private final Pose lleva1 = new Pose(16, 23, 0);
    private final Pose recoge2 = new Pose(66, 14, 0);
    private final Pose lleva2 = new Pose(16, 14, 0);
    private final Pose recoge3 = new Pose(66, 8, 0);
    private final Pose lleva3 = new Pose(16, 8, 0);

    private Path scorePreload, park;
    private PathChain primera, segunda, tercera, anota2, anota3, anota4, anota5;


    @Override
    public void runOpMode() {
        CommandScheduler.getInstance().reset();

        Telemetry telem = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());

        VoltageSensor vs = hardwareMap.voltageSensor.iterator().next();

        Constants.setConstants(FConstants.class, LConstants.class);
        Follower f = new Follower(hardwareMap);

        f.setPose(inicio);
        f.setMaxPower(0.75);

        double pivotVConstant = 13.4/vs.getVoltage();


        SequentialCommandGroup auto = new SequentialCommandGroup(
                //primer sample
                new ParallelCommandGroup(
                        new Commandviper(viper, viper.especimen),
                        new OpenClawCommand(garra, true),
                        new FollowPathCommand(f, f.pathBuilder()
                                .addPath(
                                        new BezierLine(
                                                new Point(inicio),
                                                new Point(sample1)
                                        )
                                )
                                .setConstantHeadingInterpolation(0)
                                .build()
                        )
                )/*,
                //acomodo
                new ParallelCommandGroup(
                        new FollowPathCommand(f, f.pathBuilder()
                                .addPath(
                                        new BezierCurve(
                                                new Point(sample1),
                                                new Point(23.000, 29.000, Point.CARTESIAN),
                                                new Point(recoge1)
                                        )
                                )
                                .setConstantHeadingInterpolation(0)
                                .build()
                        )
                ),
                //acomodo con empuje
                new ParallelCommandGroup(
                        new FollowPathCommand(f, f.pathBuilder()
                                .addPath(
                                        new BezierCurve(
                                                new Point(recoge1),
                                                new Point(70.000, 20.000, Point.CARTESIAN),
                                                new Point(lleva1)
                                        )
                                )
                                .setConstantHeadingInterpolation(0)
                                .build()
                        )
                ),
                //acomodo 2
                new ParallelCommandGroup(
                        new FollowPathCommand(f, f.pathBuilder()
                                .addPath(
                                        new BezierCurve(
                                                new Point(lleva1),
                                                new Point(73.000, 27.000, Point.CARTESIAN),
                                                new Point(recoge2)
                                        )
                                )
                                .setConstantHeadingInterpolation(0)
                                .build()
                        )
                ),//empuje 2
                new ParallelCommandGroup(
                        new FollowPathCommand(f, f.pathBuilder()
                                .addPath(
                                        new BezierCurve(
                                                new Point(recoge2),
                                                new Point(lleva2)
                                        )
                                )
                                .setConstantHeadingInterpolation(0)
                                .build()
                        )
                ),//acomodo3
                new ParallelCommandGroup(
                        new FollowPathCommand(f, f.pathBuilder()
                                .addPath(
                                        new BezierCurve(
                                                new Point(lleva2),
                                                new Point(72.224, 15.477, Point.CARTESIAN),
                                                new Point(recoge3)
                                        )
                                )
                                .setConstantHeadingInterpolation(0)
                                .build()
                        )
                ),//empuja3
                new ParallelCommandGroup(
                        new FollowPathCommand(f, f.pathBuilder()
                                .addPath(
                                        new BezierCurve(
                                                new Point(recoge3),
                                                new Point(lleva3)
                                        )
                                )
                                .setConstantHeadingInterpolation(0)
                                .build()
                        )
                )

        */);
        // Wait for start and schedule auto command group
        waitForStart();
        CommandScheduler.getInstance().schedule(auto);

        // Opmode loop
        while (opModeIsActive()) {
            f.setMaxPower(10.0 / vs.getVoltage());
            CommandScheduler.getInstance().run();
            f.update();
            f.telemetryDebug(telem);
        }
    }
}
