package com.hanfei.test;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by JARVIS on 2017/7/12.
 */
public enum NodeState {

    未下发(0,"未下发"),
    已下发(1,"已下发"),
    等待下级反馈(2,"等待下级反馈"),
    已反馈(3,"已反馈");

    private final int value;
    private final String description;

    NodeState(int value, String description){
        this.value = value;
        this.description = description;
    }

    public static NodeState valueOf(int value){
        for(NodeState enu : NodeState.values()) {
            if(enu.getValue() == value) {
                return enu;
            }
        }
        return null;
    }

    /**
     *
     * @param value
     * @return
     */
    public static NodeState nameOf(String value){
        if(StringUtils.isEmpty(value)){
            return null;
        }
        for(NodeState enu : NodeState.values()) {
            if(enu.getDescription().equals(value)) {
                return enu;
            }
        }
        for(NodeState enu : NodeState.values()) {
            if(enu.getDescription().startsWith(value)) {
                return enu;
            }
        }
        return null;
    }



    public int getValue() {
        return value;
    }


    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }

}
