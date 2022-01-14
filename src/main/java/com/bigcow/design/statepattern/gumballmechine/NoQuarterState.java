package com.bigcow.design.statepattern.gumballmechine;

public class NoQuarterState implements State {

    GumballMachine gumballMachine;
    StateEnum stateEnum;

    /**
     * 我们通过构造器得到糖果机的引用，
     * 然后将它记录在实例变量中
     * @param gumballMachine
     */
    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
        this.stateEnum = StateEnum.NO_QUARTER;
    }

    @Override
    public void insertQuarter() {
        //如果有人投入了25分钱，我们就打印出一条消息，
        //说我们接受了25分钱，然后改变机器的状态到HasQuarterState
        System.out.println("You inserted a quarter");
        gumballMachine.setState(new HasQuarterState(gumballMachine));

    }

    @Override
    public void ejectQuarter() {
        System.out.println("You have'nt inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    public StateEnum getStateEnum() {
        return stateEnum;
    }
}
