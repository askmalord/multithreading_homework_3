package ru.netology;

public class Toy extends Thread {
    private volatile boolean tumblerState;

    public boolean getTumblerState() {
        return tumblerState;
    }

    public void setTumblerState(boolean tumblerState) {
        this.tumblerState = tumblerState;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            while (!tumblerState) {
                if (isInterrupted()) {
                    return;
                }
            }
            tumblerState = !tumblerState;
            System.out.println("Игрушка: тумблер выключен");
        }
    }
}
