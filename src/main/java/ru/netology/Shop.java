package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop extends Thread {
    private final int MIN_COUNT_OF_SALES = 5;
    private final int MAX_COUNT_OF_SALES = 90;
    private final int MIN_PRICE = 100;
    private final int MAX_PRICE = 10000;
    private Random random = new Random();
    private int countOfSales;
    private LongAdder order;
    private List<Integer> massiveOfSales = new ArrayList<>();

    public Shop(LongAdder order) {
        this.order = order;
        this.countOfSales = MIN_COUNT_OF_SALES + random.nextInt(MAX_COUNT_OF_SALES);
    }

    private void initializeMassive() {
        for (int i = 0; i < countOfSales; i++) {
            int someSale = MIN_PRICE + random.nextInt(MAX_PRICE);
            massiveOfSales.add(someSale);
        }
    }

    @Override
    public void run() {
        initializeMassive();
        for (int i = 0; i < massiveOfSales.size(); i++) {
            order.add(massiveOfSales.get(i));
        }
    }
}
