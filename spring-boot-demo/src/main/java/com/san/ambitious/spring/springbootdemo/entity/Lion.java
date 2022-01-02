package com.san.ambitious.spring.springbootdemo.entity;

public class Lion implements Animal{
    @Override
    public String getSound() {
        return "roar";
    }

    @Override
    public String getId() {
        return "Lion";
    }
}
