package com.bigcow.design.statepattern.circuitbreaker;

public class HalfOpenState implements State {

    private CircuitBreakerMachine circuitBreakerMachine;
    private StateEnum stateEnum;

    public HalfOpenState(CircuitBreakerMachine circuitBreakerMachine) {
        this.circuitBreakerMachine = circuitBreakerMachine;
        this.stateEnum = StateEnum.HALF_OPEN;
    }

    @Override
    public void transClosedToOpen() {
        System.out.println("can not transfrom closed to Open, cur state: " + stateEnum);
    }

    @Override
    public void transOpenToHalfOpen() {
        System.out.println("can not transfrom open to half open, cur state: " + stateEnum);
    }

    @Override
    public void transHalfOpenToClosed() {
        System.out.println("half open window失败次数较少");
        circuitBreakerMachine.setState(new ClosedState(circuitBreakerMachine));
    }

    @Override
    public void transHalfOpenToOpen() {
        System.out.println("half open window失败次数较多！！！");
        circuitBreakerMachine.setState(new OpenState(circuitBreakerMachine));
    }

    @Override
    public StateEnum getStateEnum() {
        return stateEnum;
    }
}
