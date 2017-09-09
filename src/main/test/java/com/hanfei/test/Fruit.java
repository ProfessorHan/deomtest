package com.hanfei.test;

/**
 * @Author: Hanfei
 * @Date: 2017/9/1
 * @Company:http://www.hbsddz.com
 * @Project:iBase4J
 * @Class:Fruit
 */
public enum Fruit {
    APPLE("苹果"), ORANGE("橘子"), PINK("粉色");

    private String name;

    Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
