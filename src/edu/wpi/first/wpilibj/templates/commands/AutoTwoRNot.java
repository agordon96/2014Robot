package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class AutoTwoRNot extends CommandGroup{
    
    public AutoTwoRNot(){
        addParallel(new RunIntake());
        addSequential(new Rotate(2));
        addSequential(new Ears());
        addParallel(new Spin(false));
        addSequential(new Retract());
        addSequential(new Shoot());
        addSequential(new WaitCommand(0.5));
        addParallel(new Spin(true));
        addSequential(new Retract());
        addSequential(new Rotate(1));
        addSequential(new WaitCommand(1.0));
        addSequential(new RunIntake());
        addParallel(new Rotate(2));
        addSequential(new Shoot());
        addParallel(new Retract());
        addSequential(new GoForward(65));
    }
}