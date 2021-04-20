package bigO;

public class CountIt4 {
    private long fib(int n) {
        if (n < 3)
            return 1;
        else
            return fib(n - 1) + fib (n - 2);

    }
    public static void main(String[] args) {
        CountIt4 r = new CountIt4();
        Long t = System.currentTimeMillis();
        int N  = 20;
        System.out.println("Fib of " + N + " = " + r. fib (N));
        System.out.println ("Time:" + (System.currentTimeMillis() - t));
    }
}

