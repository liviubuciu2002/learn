package mypackage;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
/*
 simuleaza combinarea unor atomi de hidrogen si unor atomi de oxigen, treadurile scriind la
 consola simbolul H sau O , in funtie de tread
 leetcode problem : https://leetcode.com/problems/building-h2o/description/
 */
public class H2OWithSemaphores {
    private Semaphore semO = new Semaphore(1);
    private Semaphore semH = new Semaphore(2);
    private Phaser phaser = new Phaser(3);

    public static void main(String[] args) {
        int n = 10;
        H2OWithSemaphores h2o = new H2OWithSemaphores();
        Hydrogen[] hydrogen = new Hydrogen[2 * n];
        Oxygen[] oxygen = new Oxygen[n];
        for (int i = 0; i < n; i++) {
            hydrogen[2 * i] = h2o.new Hydrogen();
            hydrogen[2 * i + 1] = h2o.new Hydrogen();
            oxygen[i] = h2o.new Oxygen();
        }
        for (int i = 0; i < n; i++) {
            new Thread(hydrogen[2 * i]).start();
            new Thread(hydrogen[2 * i + 1]).start();
            new Thread(oxygen[i]).start();
        }

    }

    class Hydrogen implements Runnable {
        public void run() {
            try {
                semH.acquire();
                System.out.print("H");
                phaser.arriveAndAwaitAdvance();
                semH.release();
            }  catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Oxygen implements Runnable {
        public void run() {
            try {
                semO.acquire();
                System.out.print("O");
                phaser.arriveAndAwaitAdvance();
                semO.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
