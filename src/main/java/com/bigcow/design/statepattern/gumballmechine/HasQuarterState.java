package com.bigcow.design.statepattern.gumballmechine;

public class HasQuarterState implements State {

    GumballMachine gumballMachine;
    StateEnum stateEnum;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
        this.stateEnum = StateEnum.HAS_QUARTER;
    }

    @Override
    public void insertQuarter() {
        //这是一个对此状态不恰当的动作
        System.out.println("You can't insert another quarter");
    }

    /**
     * 退出顾客的25分钱，并将状态转换到NoQuarterState状态
     */
    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(new NoQuarterState(gumballMachine));
    }

    /**
     * 当曲柄被转动时，我们就调用它的setState()方法，
     * 并传入SoldState对象作为参数，将机器的状态转换到SoldState状态
     */
    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(new SoldState(gumballMachine));
    }

    /**
     * 这是此状态的另一个不恰当的动作
     */
    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public StateEnum getStateEnum() {
        return stateEnum;
    }
}
