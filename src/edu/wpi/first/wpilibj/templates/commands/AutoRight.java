package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.Global;

public class AutoRight extends CommandGroup{
    Timer timer;
    
    public AutoRight(){
        timer = new Timer();
        timer.start();
        
        addSequential(new LowGear());
        addSequential(new WhereHot());
        while(!Global.isRight && timer.get() <= 5){
            Global.msg = "Waiting";
        }
        //addSequential(new Shoot());
        addParallel(new GoForward(50));
        //addSequential(new Retract());
        
        timer.stop();
        timer.reset();
    }
}