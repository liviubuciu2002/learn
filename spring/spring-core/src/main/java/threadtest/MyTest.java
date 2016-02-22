package threadtest;

import java.io.*;

/**
 * Created by liviu on 2/19/2016.
 */
public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Blocked(), "MyBlocked Thread");
        Thread t2 = new Thread(new Writing(), "MyWriter Thread");
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(t1.getState());
        System.out.println(t2.getState());

    }

}
class Writing implements Runnable {
    public void run() {
        PrintWriter print = new PrintWriter(new OutputStreamWriter(System.out));
        int i = 0;
        while(true) {
            try {
                Thread.sleep(100);
                print.println("line number = " + i++);
                StringBuffer b = new StringBuffer();
                for(int j = 0; j < 100000; j++ ) {
                    String a = "asd";
                    a += "dfr";
                    a+= "wde";
                    StringBuffer c = new StringBuffer();
                    c.append(a);
                    b.append(c);
                }
                System.out.println(b);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Blocked implements Runnable {
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter file = null;
        try {
            file = new PrintWriter(new File("I:\\munca-invatat\\myout.txt"));

            String t = "";
            int i = 0;
            while(t != null) {
                try {
                    file.println("myFirst" + ++i);
                    file.flush();
                    t = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
