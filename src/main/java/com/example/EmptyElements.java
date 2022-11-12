package com.example;

import java.util.List;

public class EmptyElements extends RuntimeException{

    public EmptyElements(List<String> emptyStrings){
        super("Is Empty : " + emptyStrings);
    }
    
}
