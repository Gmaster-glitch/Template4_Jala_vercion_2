package org.firstinspires.ftc.teamcode.subsystems;
import com.qualcomm.hardware.kauailabs.NavxMicroNavigationSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import com.kauailabs.navx.ftc.AHRS;

import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Rotation;

public class GyroscopeSubsystem {

    private final byte NAVX_DEVICE_UPDATE_RATE_HZ = 50;
    private AHRS navx;
    private static GyroscopeSubsystem instance;
    private int offset;

    public static GyroscopeSubsystem getInstance(HardwareMap hardwareMap){
        if (instance == null) {
            instance = new GyroscopeSubsystem(hardwareMap);
        }
        return instance;
    } //getinstance
    public GyroscopeSubsystem(HardwareMap hardwareMap){
        navx = AHRS.getInstance(hardwareMap.get(NavxMicroNavigationSensor.class, "navx"),
                AHRS.DeviceDataType.kProcessedData,
                NAVX_DEVICE_UPDATE_RATE_HZ);
        navx.zeroYaw();
    }
    public double getRotation(){
        return navx.getYaw()+offset;
    }
    public double getOrientation(){
        double yaw = navx.getYaw()+offset;
        if(yaw<0){
            yaw=(180+(180-Math.abs(yaw)));
        }
        return yaw;
    }
    public double rawYaw() {
        return navx.getYaw();
    }

    public void reset(){
        navx.zeroYaw();
    }

    public void setOffset(int degrees){
        offset = degrees;
    }


}