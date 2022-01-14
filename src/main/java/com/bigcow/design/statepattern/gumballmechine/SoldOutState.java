package com.bigcow.design.statepattern.gumballmechine;

public class SoldOutState implements State {

    private GumballMachine gumballMachine;
    private StateEnum stateEnum;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
        this.stateEnum = StateEnum.SOLD_OUT;
    }

    @Override
    public void insertQuarter() {
        System.out.println("The gumballs are sold out， can not insert quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("The gumballs are sold out，you have'nt inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("The gumballs are sold out，You can'nt turn crank");
    }

    @Override
    public void dispense() {
        System.out.println("The gumballs are sold out，You can'nt dispense");
    }

    @Override
    public StateEnum getStateEnum() {
        return stateEnum;
    }
}
