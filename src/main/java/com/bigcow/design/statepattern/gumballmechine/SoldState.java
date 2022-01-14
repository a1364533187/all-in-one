package com.bigcow.design.statepattern.gumballmechine;

public class SoldState implements State {

    GumballMachine gumballMachine;
    StateEnum stateEnum;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
        this.stateEnum = StateEnum.SOLD;
    }

    /**
     * 对此状态来说，这些都是不恰当的动作
     */
    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        //我们现在是在SoldState状态，也就是说客户已经付钱了。
        //所以我们首先需要机器发放糖果
        if (gumballMachine.getCount() == 0) {
            //我们问机器糖果的剩余数目是多少，然后将状态转换到NoQuarterState或者SoldOutState
            System.out.println("Oops, out of gumballs");
            gumballMachine.setState(new SoldOutState(gumballMachine));
        } else {
            gumballMachine.setState(new NoQuarterState(gumballMachine));
        }
    }

    @Override
    public StateEnum getStateEnum() {
        return stateEnum;
    }
}
