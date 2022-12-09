package com.example.javafeature;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class StringIntern {

    public static void main(String[] args) {

        String name1 = "Santhosh";
        String name2 = "Santhosh";

        if(name1 == name2){
            System.out.println("== comparison:true");
        }

        if(name1.equals(name2)){
            System.out.println("Equals  comparison:true");
        }

        String name3 = new String("Santhosh").intern();
        if(name1 == name3){
            System.out.println("== ( new string) comparison:true");
        }

        if(name1.equals(name3)){
            System.out.println("Equals ( new string ) comparison:true");
        }
    }
}
