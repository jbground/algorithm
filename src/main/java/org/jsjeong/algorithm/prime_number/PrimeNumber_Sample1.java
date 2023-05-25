package org.jsjeong.algorithm.prime_number;

public class PrimeNumber_Sample1 {

    public static void main(String[] args) {
        int[] arr = {15, 24, 63, 42, 67, 13, 19};
        findPrime(arr);

    }

    public static void findPrime(int[] arr) {
        for (int num : arr) {
            if(isPrime(num) == 1)
                System.out.println(num);
        }
    }

    public static int isPrime(int num) {
        String s = "";

        if (num % 2 == 0)
            return 0;

        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return 0;
            }
        }

        return 1;
    }
}
