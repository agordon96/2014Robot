package edu.wpi.first.wpilibj.templates.commands;

public class RunIntake extends CommandBase{
    
    public RunIntake(){
        requires(in);
    }

    protected void initialize(){
        in.RunIntake();
    }

    protected void execute(){}

    protected boolean isFinished(){
        return true;
    }

    protected void end(){}

    protected void interrupted(){}
}
