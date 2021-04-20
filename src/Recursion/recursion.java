package Recursion;

public class recursion {

    public static void main(String[] args) {
        System.out.println("bunnyEars method test");
        for (int i = 0; i < 11; i++) {
            System.out.println(i + " bunnies: " + bunnyEars(i) + " ears.");
        }

        System.out.println("bunnyEars2 method test");
        for (int i = 0; i < 11; i++) {
            System.out.println(i + " bunnies: " + bunnyEars2(i) + " ears.");
        }

        System.out.println("countX method test");
        System.out.println("aaa: " + countX("aaa") + " x's");
        System.out.println("xxyxx: " + countX("xxyxx") + " x's");
        System.out.println("hixxx: " + countX("hixxx") + " x's");

        System.out.println("countHi method test");
        System.out.println("aaa: " + countHi("aaa") + " hi's");
        System.out.println("hihihihi: " + countHi("hihihihi") + " hi's");
        System.out.println("hixxx: " + countHi("hixxx") + " hi's");

        System.out.println("count7 method test");
        System.out.println(700 + ": " + count7(700) + " 7's.");
        System.out.println(123 + ": " + count7(123) + " 7's.");
        System.out.println(77777 + ": " + count7(77777) + " 7's.");
        System.out.println(107 + ": " + count7(107) + " 7's.");

        System.out.println("changeXY method test");
        System.out.println("aaa: " + changeXY("aaa"));
        System.out.println("xxyxx: " + changeXY("xxyxx"));
        System.out.println("hixxx: " + changeXY("hixxx"));
    }

    public static int bunnyEars(int bunnies) {
        if (bunnies <= 0)
            return 0;
        return 2 + bunnyEars(bunnies - 1);
    }

    public static int bunnyEars2(int bunnies) {
        if (bunnies <= 0)
            return 0;
        if (bunnies % 2 == 1)
            return 2 + bunnyEars2(bunnies - 1);
        return 3 + bunnyEars2(bunnies - 1);
    }

    public static int countX(String str) {
        if (str.length() == 0)
            return 0;
        if (str.charAt(0) == 'x')
            return 1 + countX(str.substring(1));
        return countX(str.substring(1));
    }

    public static int countHi(String str) {
        if (str.length() < 2)
            return 0;
        if (str.charAt(0) == 'h') {
            if (str.charAt(1) == 'i')
                return 1 + countHi(str.substring(2));
        }
        return countHi(str.substring(1));
    }

    public static int count7(int n) {
        if (n == 0)
            return 0;
        if (n % 10 == 7)
            return 1 + count7(n/10);
        return count7(n/10);
    }

    public static String changeXY(String str) {
        if (str.length() == 0)
            return str;
        char c = str.charAt(0);
        if (c == 'x')
            return 'y' + changeXY(str.substring(1));
        return c + changeXY(str.substring(1));
    }
}
