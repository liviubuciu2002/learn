package mypackage.blockedexample;

/**
 * Created by liviu on 2/5/2016.
 */
public class ThreadStatesAll {
    final Object o = new Object();
    public static void main(String[] args) throws InterruptedException {
        new ThreadStatesAll().TestNotifyAll();
     }

    void TestNotifyAll() throws InterruptedException {
        int n = 10;
        Thread thread = new Thread(new A(10*1000, o));//all threads will be blocked by this thread
        thread.start();
        Thread.sleep(100);//to be sure that lock is acquired on object
        System.out.println("NotifyAll Thread state:" + thread.getState());

        Thread[] threads = new Thread[n];
        for(int i = 0; i < n; i++) {
            threads[i] = new Thread(new A(o));
            threads[i].start();
        }

        Thread.sleep(500);//to be sure that all previous threads have started
        for(Thread t : threads) {
            System.out.print(t.getState()+";");
        }

        System.out.println("\nbefore interupt; thread[3] state=" + threads[3].getState());
        threads[3].interrupt();
        Thread.sleep(100);
        System.out.println("\n---");
        for(Thread t : threads) {
            System.out.print(t.getState()+";");
        }

        thread.join();//wait after blocker thread to finish
        Thread.sleep(1000);
        System.out.println("\n---");
        for(Thread t : threads) {
            System.out.print(t.getState()+";");
        }

        synchronized (o) {
            o.notifyAll();//notify all threads that waits for this lock
        }

        Thread.sleep(1000);
        System.out.println("\n---");
        for(Thread t : threads) {
            System.out.print(t.getState()+";");
        }

        System.out.println("end");
    }
}

class A implements Runnable{
    long timeout;
    Object o;
    A(long timeout, Object o) {
        this.timeout = timeout;
        this.o = o;
    }

    A (Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        call(timeout);
    }

    void call(long timeout) {
        synchronized (o) {
            try {
                if (timeout != 0) {
                    Thread.sleep(timeout);//lock acquired on Object o, so all threads will be blocked, when access synchronized block on o
                } else {

                    if(Thread.currentThread().isInterrupted()) {/* isInterrupted() method doesn't clear the interrupt status flag,
                         so when wait is reached, Interrupted Exception will be thrown by interrupted thread */
                        System.out.println("\nThread was interrupted");
                    };

                    o.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Catch Interrupted Exception");
                e.printStackTrace();
            }
        }
    }
}
