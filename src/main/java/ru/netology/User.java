package ru.netology;

public class User extends Thread {
    private static final int COUNT_OF_ITERATIONS = 3;
    private static final int WAITING_TIME = 2000;
    private String name;
    private Toy toy;

    public User(String name, Toy toy) {
        this.name = name;
        this.toy = toy;
    }

    @Override
    public void run() {
        for (int i = 0; i < COUNT_OF_ITERATIONS; i++) {
            try {
                while (toy.getTumblerState());
                Thread.sleep(WAITING_TIME);
                System.out.printf("%s: тумблер включен\n", name);
                toy.setTumblerState(!toy.getTumblerState());
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
