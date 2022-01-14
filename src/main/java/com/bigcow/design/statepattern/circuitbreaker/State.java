package com.bigcow.design.statepattern.circuitbreaker;

public interface State {

    void transClosedToOpen();

    void transOpenToHalfOpen();

    void transHalfOpenToClosed();

    void transHalfOpenToOpen();

    StateEnum getStateEnum();
}
