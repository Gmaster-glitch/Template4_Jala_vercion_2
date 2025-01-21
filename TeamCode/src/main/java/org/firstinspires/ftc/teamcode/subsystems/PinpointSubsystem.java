package org.firstinspires.ftc.teamcode.subsystems;

import com.kauailabs.navx.ftc.AHRS;
import com.qualcomm.hardware.kauailabs.NavxMicroNavigationSensor;
import com.qualcomm.hardware.motors.GoBILDA5201Series;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchSimple;

import org.firstinspires.ftc.teamcode.GoBildaPinpointDriver;

public class PinpointSubsystem {


    private static PinpointSubsystem instance;
    private int offset;
    private GoBildaPinpointDriver pinpoint;
    private boolean deviceClientIsOwned;

    public static PinpointSubsystem getInstance(HardwareMap hardwareMap){
        if (instance == null) {
            instance = new PinpointSubsystem(hardwareMap);
        }
        return instance;
    }
    public PinpointSubsystem(HardwareMap hardwareMap) {
        pinpoint = new GoBildaPinpointDriver(pinpoint.getDeviceClient(),deviceClientIsOwned);

        pinpoint.resetPosAndIMU();
    }
    public double getRotation(){

        return pinpoint.getHeading()+offset;
    }
    public double getOrientation(){
        double rotation = getRotation();
        if(rotation<0){
            rotation=(180+(180-Math.abs(rotation)));
        }
        return rotation;
    }
    public double rawYaw() {

        return pinpoint.getHeading();
    }

    public void reset(){
        pinpoint.resetPosAndIMU();
    }

    public void setOffset(int degrees) {
        offset = degrees;
    }

}