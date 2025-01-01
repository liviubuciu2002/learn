package mypackage;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class H2OWithLockAndCondition {
    ReentrantLock lock = new ReentrantLock();
    Condition hC = lock.newCondition();
    Condition oC = lock.newCondition();

    int o = 0, h = 0;

    public static void main(String[] args) {
        int n = 10;
        H2OWithSemaphores h2o = new H2OWithSemaphores();
        H2OWithSemaphores.Hydrogen[] hydrogen = new H2OWithSemaphores.Hydrogen[2 * n];
        H2OWithSemaphores.Oxygen[] oxygen = new H2OWithSemaphores.Oxygen[n];
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
            boolean finished = false;
            while (!finished) {
                lock.lock();
                try {

                    if (h < 2) {
                        h++;
                        System.out.print("H");
                        finished = true;
                        hC.signal();
//                        oC.signal();
                    } else if (o == 0) {
                        oC.signal();
                        hC.await();
                    } else {
                        h = 0;
                        o = 0;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        }
    }

    class Oxygen implements Runnable {
        public void run() {
            boolean finished = false;
            while (!finished) {
                lock.lock();
                try {
                    if (o == 0) {
                        o++;
                        System.out.print("O");
                        finished = true;
//                        hC.signal();
//                        oC.signal();
                    } else if (h < 2) {
                        hC.signal();
                        oC.await();
                    } else {
                        h = 0;
                        o = 0;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        }
    }

}
