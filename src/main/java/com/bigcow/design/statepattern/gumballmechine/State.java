package com.bigcow.design.statepattern.gumballmechine;

public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

    StateEnum getStateEnum();
}
