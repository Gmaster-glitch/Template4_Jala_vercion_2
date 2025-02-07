package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Garra {
    private Gamepad gamepad;
    private Servo garra;
    boolean debounce = true;
    private Telemetry telemetry;
    boolean open = false;


    public Garra(HardwareMap hardwareMap, Telemetry telemetry, Gamepad gamepad) {//motor
        this.gamepad = gamepad;
        this.telemetry = telemetry;
        garra = hardwareMap.get(Servo.class, "Garra");
    }

    public void cierra() {
        garra.setPosition(0);
    }

    public void abre() {
        garra.setPosition(1);
    }


    public void periodic() {
        telemetry.addData("garra", debounce);

        if (gamepad.dpad_up) {
        } else {
            if (gamepad.y) {
                if (debounce == true) {
                    abre();
                    ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
                    debounce = false;
                    while (timer.time() < 100) {
                    }
                    } else if (debounce==false) {
                    cierra();
                    ElapsedTime timer = new ElapsedTime(ElapsedTime.Resolution.MILLISECONDS);
                    debounce = true;
                    while (timer.time() < 100) {
                    }
                }
            }
            }
        }
    }
