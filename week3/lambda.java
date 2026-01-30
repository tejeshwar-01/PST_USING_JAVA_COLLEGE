interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    static PerformOperation isOdd() {
        return a -> a % 2 != 0;
    }

    static PerformOperation isPrime() {
        return a -> {
            if (a <= 1) return false;
            for (int i = 2; i * i <= a; i++) {
                if (a % i == 0) return false;
            }
            return true;
        };
    }

    static PerformOperation isPalindrome() {
        return a -> {
            int x = a, rev = 0;
            while (x > 0) {
                rev = rev * 10 + x % 10;
                x /= 10;
            }
            return rev == a;
        };
    }
}

public class lambda {

    public static void main(String[] args) {

        // Default test cases (same as HackerRank sample)
        int[][] tests = {
            {1, 4},
            {2, 5},
            {3, 898},
            {1, 3},
            {2, 12}
        };

        for (int[] t : tests) {
            int choice = t[0];
            int num = t[1];

            if (choice == 1)
                System.out.println(MyMath.isOdd().check(num) ? "ODD" : "EVEN");

            else if (choice == 2)
                System.out.println(MyMath.isPrime().check(num) ? "PRIME" : "COMPOSITE");

            else if (choice == 3)
                System.out.println(MyMath.isPalindrome().check(num) ? "PALINDROME" : "NOT PALINDROME");
        }
    }
}