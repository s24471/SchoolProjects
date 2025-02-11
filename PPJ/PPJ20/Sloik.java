package com.company;

public class Sloik {
    private Dzem dzem;
    private boolean czySloikOtwarty;

    public Sloik(Dzem dzem){
        this.dzem=dzem;
        czySloikOtwarty=false;
    }

    public void otworz(){
        czySloikOtwarty=true;
    }
    public void zamknij(){
        czySloikOtwarty=false;
    }
    public boolean czyOtwarte(){
        return czySloikOtwarty;
    }
}
