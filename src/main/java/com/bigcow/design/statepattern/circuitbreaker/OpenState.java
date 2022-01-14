package com.bigcow.design.statepattern.circuitbreaker;

public class OpenState implements State {

    private CircuitBreakerMachine circuitBreakerMachine;
    private StateEnum stateEnum;

    public OpenState(CircuitBreakerMachine circuitBreakerMachine) {
        this.circuitBreakerMachine = circuitBreakerMachine;
        this.stateEnum = StateEnum.OPEN;
    }

    @Override
    public void transClosedToOpen() {
        System.out.println("can not transfrom closed to open, cur state: " + stateEnum);
    }

    @Override
    public void transOpenToHalfOpen() {
        System.out.println("熔断超时时间到。。。 ");
        circuitBreakerMachine.setState(new HalfOpenState(circuitBreakerMachine));
    }

    @Override
    public void transHalfOpenToClosed() {
        System.out.println("can not transfrom half_open to closed, cur state: " + stateEnum);
    }

    @Override
    public void transHalfOpenToOpen() {
        System.out.println("can not transfrom half_open to open, cur state: " + stateEnum);
    }

    public StateEnum getStateEnum() {
        return stateEnum;
    }
}
