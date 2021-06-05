package ru.netology;

import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LongAdder report = new LongAdder();
        Shop shop1 = new Shop(report);
        Shop shop2 = new Shop(report);
        Shop shop3 = new Shop(report);
        shop1.start();
        shop2.start();
        shop3.start();
        shop1.join();
        shop2.join();
        shop3.join();
        System.out.println("Итог: " + report.sum());
    }
}
