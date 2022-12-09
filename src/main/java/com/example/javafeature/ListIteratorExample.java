package com.example.javafeature;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ListIteratorExample {

    public static void main(String[] args) {

        List dataList = new ArrayList<String>();

        dataList.add("data1");
        dataList.add("data2");
        dataList.add("data3");
        dataList.add("data4");
        ListIterator dataListIterator = dataList.listIterator();

        while (dataListIterator.hasNext()) {
            if (dataListIterator.next().equals("data1")) {
                dataListIterator.remove();
            }
        }

      //  System.out.println(dataList);


        while (dataListIterator.hasNext()) {
            if (dataListIterator.next().equals("data1")) {
                dataListIterator.remove();
            }
        }
        List dataList1 = new ArrayList();

        dataList1.add("data1");
        dataList1.add("data2");
        dataList1.add("data3");
        dataList1.add("data4");


       // dataList1.removeIf(x -> x.equals("data1"));
        List newList = (List) dataList1.stream().filter(x -> x.equals("data1")).collect(Collectors.toList());

        System.out.println(newList);

    }
}
