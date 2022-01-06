package com.bigcow.cn.design.statedesign;

public class StateMachine implements State {

    private State state;

    public StateMachine(State state) {
        this.state = state;
    }

    @Override
    public void transToOpenState(EventEnum eventEnum) {

    }

    @Override
    public void transToCloseState(EventEnum eventEnum) {

    }

    @Override
    public void transToHalfOpenState(EventEnum eventEnum) {

    }
}
