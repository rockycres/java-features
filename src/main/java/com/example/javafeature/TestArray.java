package com.example.javafeature;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TestArray {


    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {


        Collections.sort(ar);

        // Write your code here
        int count = 0;
        // Nested loop for all possible pairs
        for (int i = 0;i < n-1 ; i++) {
            for (int j = i + 1;j < n-1; j++) {
                if (ar.get(i) == ar.get(j)) {
                    count++;
                    System.out.println("i:"+i+"j:"+j);
                    i = j ;
                }
                break;
            }

        }

        return count;

    }

    public static void main(String[] args) throws IOException {

        int n = 10;

        List<Integer> ar = new ArrayList<>();
        ar.add(10);
        ar.add(20);
        ar.add(20);
        ar.add(10);
        ar.add(10);
        ar.add(30);
        ar.add(50);
        ar.add(10);
        ar.add(20);

        int result = TestArray.sockMerchant(n, ar);

        System.out.println(result);
    }


}
