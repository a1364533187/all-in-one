package com.bigcow.design.statepattern.gumballmechine;

public class GumballMachine {

    State state;
    int count = 0;

    public GumballMachine(int numberGumballs) {

        state = new SoldOutState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = new NoQuarterState(this);
        }
    }

    /**
     * 现在这些动作变得很容易实现了。我们只是委托到当前状态
     */
    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * 请注意，我们不需要在GumballMachine中准备一个dispense()的动作方法，
     * 因为这只是一个内部的动作，用户不可以直接要求机器发放糖果。
     * 但我们是在状态对象的turnCrank()方法中调用dispense()方法的
     */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    /**
     * 这个方法允许其他的对象（像我们的状态对象）将机器的状态转换到不同的状态
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * 这个机器提供了一个releaseBall()的辅助方法来释放出糖果，
     * 并将count实例变量的值减1
     */
    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count != 0) {
            count = count - 1;
        }
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        String ret = "Mighty Gumball, Inc.\n";
        ret += "Java-enabled Standing Gumball Model #2004\n";
        ret += "Inventory: " + count + " gumballs\n";
        if (state.getStateEnum() == StateEnum.NO_QUARTER) {
            ret += "Machine is waiting for quarter";
        } else if (state.getStateEnum() == new SoldState(this).getStateEnum()) {
            ret += "Machine is sold out";
        }
        ret += "\n";
        return ret;
    }
}
