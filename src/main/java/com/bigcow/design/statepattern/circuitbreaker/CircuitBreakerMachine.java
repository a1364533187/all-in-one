package com.bigcow.design.statepattern.circuitbreaker;

public class CircuitBreakerMachine implements State {

    private State state;

    public CircuitBreakerMachine(StateEnum initStateEnum) {
        if (initStateEnum != StateEnum.CLOSED) {
            throw new IllegalStateException("初始状态必须为Closed状态");
        }
        this.state = new ClosedState(this);
    }

    public State getState() {
        return state;
    }

    protected void setState(State state) {
        this.state = state;
    }

    @Override
    public void transClosedToOpen() {
        state.transClosedToOpen();
    }

    @Override
    public void transOpenToHalfOpen() {
        state.transOpenToHalfOpen();
    }

    @Override
    public void transHalfOpenToClosed() {
        state.transHalfOpenToClosed();
    }

    @Override
    public void transHalfOpenToOpen() {
        state.transHalfOpenToOpen();
    }

    @Override
    public StateEnum getStateEnum() {
        return state.getStateEnum();
    }

    @Override
    public String toString() {
        return "CircuitBreakerMachine{" + "state=" + getStateEnum() + '}';
    }

}
