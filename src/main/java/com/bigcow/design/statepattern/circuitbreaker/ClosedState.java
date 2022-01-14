package com.bigcow.design.statepattern.circuitbreaker;

public class ClosedState implements State {

    private CircuitBreakerMachine circuitBreakerMachine;
    private StateEnum stateEnum;

    public ClosedState(CircuitBreakerMachine circuitBreakerMachine) {
        this.circuitBreakerMachine = circuitBreakerMachine;
        this.stateEnum = StateEnum.CLOSED;
    }

    @Override
    public void transClosedToOpen() {
        System.out.println("Closed window 失败次数过多");
        circuitBreakerMachine.setState(new OpenState(circuitBreakerMachine));
    }

    @Override
    public void transOpenToHalfOpen() {
        System.out.println("can not transfrom open to half_open, cur state: " + stateEnum);
    }

    @Override
    public void transHalfOpenToClosed() {
        System.out.println("can not transfrom half_open to closed, cur state: " + stateEnum);
    }

    @Override
    public void transHalfOpenToOpen() {
        System.out.println("can not transfrom half_open to open, cur state: " + stateEnum);
    }

    @Override
    public StateEnum getStateEnum() {
        return stateEnum;
    }
}
