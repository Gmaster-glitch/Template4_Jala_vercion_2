package org.firstinspires.ftc.teamcode.common.commandbase.subsystem;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Garra;

public class OpenClawCommand extends CommandBase {
    boolean estado =true;
    Garra garra;

    public OpenClawCommand(Garra garra, boolean estado) {
        this.garra = garra;
        this.estado = estado;
    }

    @Override
    public void initialize(){
        if (estado) {
            garra.cierra();
        } else {
            garra.abre();
        }
    }
}
