package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import edu.wpi.first.wpilibj.templates.Global;

public class AutoOne extends CommandGroup{
    
    public AutoOne(){
        addParallel(new Retract());
        addSequential(new OpenIntake());
        addSequential(new WaitForChildren());
        addSequential(new OpenIntake());
        addSequential(new WhereHot());
        if(!Global.isHot){
            addSequential(new WaitCommand(3.0));
        }
        addSequential(new Shoot());
        addSequential(new GoForward(120));
    }
}
