package com.example;

public class IncorrectAmountData extends RuntimeException{
    
    public IncorrectAmountData(){
        super("Incorrect amount data");
    }
}
