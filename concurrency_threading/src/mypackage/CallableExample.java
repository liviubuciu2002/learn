package mypackage;

import java.util.*;
import java.util.concurrent.*;

public class CallableExample {

    public static class WordLengthCallable
            implements Callable<Integer> {
        private String word;
        public WordLengthCallable(String word) {
            this.word = word;
        }
        public Integer call() {
            return word.length();
        }
    }

    public static void main(String args[]) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<Integer>> set = new HashSet<Future<Integer>>();
        args = new String[]{"adasd", "asdas", "asds"};

        for (String word: args) {
            Callable<Integer> callable = new WordLengthCallable(word);
            Future<Integer> future = pool.submit(callable);
            set.add(future);
        }

        int sum = 0;
        for (Future<Integer> future : set) {
            sum += future.get();
        }
        System.out.printf("The sum of lengths is %s%n", sum);
        System.exit(sum);
    }
}