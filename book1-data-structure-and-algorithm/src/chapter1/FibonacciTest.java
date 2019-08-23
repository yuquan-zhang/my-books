package chapter1;

import java.util.HashMap;
import java.util.Map;

public class FibonacciTest {

    public static long fibonacciNo1(long n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return n - 1;
        return fibonacciNo1(n - 2) + fibonacciNo1(n - 1);
    }

    public static long fibonacciNo2(long n, Map<Long,Long> memo) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return n - 1;
        Long r = memo.get(n);
        if (null == r) {
            r = fibonacciNo2(n - 2,memo) + fibonacciNo2(n - 1,memo);
            memo.put(n,r);
        }
        return r;
    }

    public static long fibonacciNo3(long n, long preTwo, long preOne) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return n - 1;
        if (n == 3) return preTwo + preOne;
        return fibonacciNo3(n-1, preOne, preTwo + preOne);
    }

    public static long fibonacciNo4(long n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return n - 1;
        long preTwo = 0;
        long preOne = 1;
        long result = preTwo + preOne;
        for (long i = 4; i <= n; ++i) {
            preTwo = preOne;
            preOne = result;
            result = preTwo + preOne;
        }
        return result;
    }

    public static void main(String[] args) {
        long n = 100000000;
        long start = System.nanoTime();
//        fibonacciNo1(n);
        System.out.println("------fibonacciNo1------");
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
//        fibonacciNo2(n,new HashMap<>());
        System.out.println("------fibonacciNo2------");
        System.out.println(System.nanoTime() - start);
        start = System.nanoTime();
        fibonacciNo4(n);
        System.out.println("------fibonacciNo4------");
        System.out.println(System.nanoTime() - start);
    }
}
