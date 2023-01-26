public class Lab11 {
    public static void main(String[] args) {
        int[] a = new int[1000];
        inti(a);
    }

    public static void inti(int[] a) {
        for (int i = 2; i < a.length; i++) {
            a[i] = 1;
        }
        findPrime(a);
    }

    public static void findPrime(int[] a) {
        for (int i = 2; i < a.length; i++)
            for (int j = 2 * i; j < a.length; j = j + i) {
                a[j] = 0;
            }
        printPrime(a);
    }

    public static void printPrime(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                System.out.println(i);
            }
        }
    }
}
