package com.bigcow.cn.design.statedesign;

public enum EventEnum {

    CLOSE_TO_OPEN("Close 状态失败数过多，大于Threshold1"),
    OPEN_TO_HALF_OPEN("超时时间到"),
    HALF_OPEN_TO_OPEN("HALF_OPEN 状态失败数过多，大于Threshold2"),
    HALF_OPEN_TO_CLOSE("HALF_OPEN 状态失败数符合需求，小于Threshold2");

    private String desc;

    EventEnum(String desc) {
        this.desc = desc;
    }
}
