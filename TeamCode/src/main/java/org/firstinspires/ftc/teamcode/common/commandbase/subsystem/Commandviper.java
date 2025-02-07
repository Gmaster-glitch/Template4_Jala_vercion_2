package org.firstinspires.ftc.teamcode.common.commandbase.subsystem;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.ViperslidePIDSubsystem;
public class Commandviper extends CommandBase{
    ViperslidePIDSubsystem viper;
    String estado;
    String especimen = "especimen";
    String soltar = "soltar";
    String piso = "piso";


    public Commandviper (ViperslidePIDSubsystem viper, String estado) {
        this.viper = viper;
        this.estado = estado;
    }

    @Override
    public void initialize(){
        if (estado == especimen) {
            viper.pid();
            viper.specimen2();
        } else if (estado == soltar) {
            viper.suelta();
            viper.pid();
        } else {
            viper.alpiso();
            viper.pid();
        }
    }
}
