package tasks._11_12_multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Philosopher implements Runnable {

    // The forks on either side of this Philosopher
    private final Fork leftFork, rightFork;
    private int eatenRiceAmount = 0;

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void perform(String action) throws InterruptedException {
        int actionTime = (int) (Math.random() * 1000) + 1000;

        System.out.println(Thread.currentThread().getName() + ", time: " + new SimpleDateFormat("HH:mm:ss").format(new Date()) + ": " + action + ". Action will last for " + actionTime +
                           " milliseconds. Rice eaten: " + (eatenRiceAmount >= 5 ? "\uD83C\uDF5A x " + eatenRiceAmount : eatenRiceAmount == 0 ? "\uD83E\uDD63" : "\uD83C\uDF5A".repeat(eatenRiceAmount)));
        Thread.sleep(actionTime);
    }

    @Override
    public void run() {
        try {
            while (true) {
                perform("\uD83E\uDD14 Thinking");
                synchronized (leftFork) {
                    perform("\uD83C\uDF74 Picked up left fork");
                    synchronized (rightFork) {
                        perform("\uD83C\uDF5A Picked up right fork - eating");
                        eatSomeRice();

                        perform("⬇️ Put down right fork");
                    }

                    perform("⏬ Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    public void eatSomeRice() {
        this.eatenRiceAmount += 1;
    }

    public int getEatenRiceAmount() {
        return eatenRiceAmount;
    }
}