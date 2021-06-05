package ru.netology;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("----- start -----");
        Toy box = new Toy();
        box.start();
        User user1 = new User("user1", box);
        user1.start();
        user1.join();
        System.out.println("----- остановка игрушки -----");
        box.interrupt();
        System.out.println("----- end -----");
    }
}
