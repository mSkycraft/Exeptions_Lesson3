package com.example;

public class NotEnoughData extends RuntimeException{
    public NotEnoughData() {
        super("Not enough data");
    }

}

