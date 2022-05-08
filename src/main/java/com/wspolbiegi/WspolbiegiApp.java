package com.wspolbiegi;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

public class WspolbiegiApp {

    public static void main(String[] args) {

        Random rd = new Random();
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(rd.nextDouble()*10);
        }
        System.out.println(list);
        List<Double> list_sorted = list.stream().sorted().collect(Collectors.toList());
        System.out.println(list_sorted);

        // forEach parallel
        System.out.println("From parallelStream: ");
        list.parallelStream().map(x->x*x).forEach(y -> System.out.println(y + " " + Thread.currentThread().getName()));

        // forEach
        System.out.println("From stream: ");
        list.stream().map(x->x*x).forEach(y -> System.out.println(y + "  " + Thread.currentThread().getName()));
    }
}
