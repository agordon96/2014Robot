package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.Global;
import edu.wpi.first.wpilibj.Timer;

public class Shoot extends CommandBase{
    Timer timer = new Timer();
    
    public Shoot(){
        requires(sh);
    }

    protected void initialize(){
        timer.start();
        if(Global.isRetract){
            sh.Shoot();
            Global.msg = "Shooting...";
            Global.error = "";
        }else{
            Global.msg = "See error";
            Global.error = "Not retracted";
        }
        sh.Shoot();
    }

    protected void execute(){}

    protected boolean isFinished(){
        if(timer.get() >= 1){
            sh.Stop();
            Global.msg = "Finished shooting";
            Global.error = "";
            Global.isRetract = false;
            timer.stop();
            timer.reset();
            return true;
        }else{
            return false;
        }
    }

    protected void end(){
        sh.Stop();
        timer.stop();
        timer.reset();
    }

    protected void interrupted(){
        Global.msg = "See error";
        Global.error = "Shooting interrupted";
        sh.Stop();
        timer.stop();
        timer.reset();
    }
}
