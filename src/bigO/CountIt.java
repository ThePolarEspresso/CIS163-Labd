package bigO;

public class CountIt {
    public int linearLoop(int N) {

        int x = 0;
        int i = 0; x++;
        while (i < N) { 	x++;   // while loop
            x++;   // stmt
            System.out.println(".");  // slow things do, does not count
            i++;  x++;
        }
        x++;
        return x;
    }

    public static void main(String[] args) {
        CountIt ex = new CountIt();
        int N = 400000;
        long start = System.currentTimeMillis();
        System.out.println ("x = " + ex.linearLoop(N));
        Long endTime = System.currentTimeMillis();
        System.out.println("\nN = " + N + ". Loops ran in: " + (endTime - start));
    }
}

