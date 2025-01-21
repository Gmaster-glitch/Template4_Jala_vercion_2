package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Mecanum Drive")
public class MecanumDrive27788 extends LinearOpMode {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;

    @Override
    public void runOpMode() {
        // Inicializar los motores
        frontLeft = hardwareMap.get(DcMotor.class, "FL");
        frontRight = hardwareMap.get(DcMotor.class, "FR");
        backLeft = hardwareMap.get(DcMotor.class, "BL");
        backRight = hardwareMap.get(DcMotor.class, "BR");

        // Establecer la dirección de los motores si es necesario
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        //backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        //frontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        // Esperar a que se presione el botón de inicio
        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("FL",frontLeft);
            telemetry.addData("FR",frontRight);
            telemetry.addData("Bl",backLeft);
            telemetry.addData("BR",backRight);

            // Obtener valores de los joysticks
            double x = gamepad1.left_stick_x;  // Eje X del joystick izquierdo
            double y = -gamepad1.left_stick_y; // Eje Y del joystick izquierdo (invertido)
            double rotation = gamepad1.right_stick_x*-1; // Eje X del joystick derecho
            /*if (gamepad1.a) {
                frontLeft.setPower(0.5);
            } else if (gamepad1.b) {
                frontRight.setPower(0.5);
            } else if (gamepad1.x) {
                backLeft.setPower(0.5);
            } else if (gamepad1.y) {
                backRight.setPower(0.5);
            } else {
                frontRight.setPower(0);
                frontLeft.setPower(0);
                backRight.setPower(0);
                backLeft.setPower(0);
            }*/

            // Calcular el poder de los motores
            double frontLeftPower = y + x - rotation;
            double frontRightPower = y - x + rotation;
            double backLeftPower = y - x - rotation;
            double backRightPower = y + x + rotation;

            // Normalizar los valores para que no excedan 1.0 o -1.0
            double max = Math.max(Math.abs(frontLeftPower), Math.max(Math.abs(frontRightPower),
                    Math.max(Math.abs(backLeftPower), Math.abs(backRightPower))));
            if (max > 1.0) {
                frontLeftPower /= max;
                frontRightPower /= max;
                backLeftPower /= max;
                backRightPower /= max;
            }

            // Asignar potencias a los motores
            frontLeft.setPower(frontLeftPower);
            frontRight.setPower(frontRightPower);
            backLeft.setPower(backLeftPower);
            backRight.setPower(backRightPower);

            // Esperar un breve periodo para evitar saturar el loop
            sleep(20);
        }
    }
}