package com.san.ambitious.spring.springbootdemo.entity;

public class Human implements Animal{
    @Override
    public String getSound() {
        return "speak";
    }

    @Override
    public String getId() {
        return "Human";
    }
}
