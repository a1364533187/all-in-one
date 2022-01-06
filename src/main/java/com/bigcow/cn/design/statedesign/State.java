package com.bigcow.cn.design.statedesign;

public interface State {

    void transToOpenState(EventEnum eventEnum);

    void transToCloseState(EventEnum eventEnum);

    void transToHalfOpenState(EventEnum eventEnum);
}
