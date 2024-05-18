package org.jsjeong.codingtest.programmers.other;

/**
 * https://www.toppr.com/ask/question/the-sum-of-the-digits-of-the-number-10n1-is-3798-the-value-of-n/
 * (n / 10^(k-1))%10
 */
public class Problem1234 {

//    public int solution(int n){
//        if(n < 10)
//            return n;
//
//        long num = 9;
//        long val = 1;
//        long sum = 9;
//
//        while (n >= (num*10)*(val + 1)){
//            num *= 10;
//            val += 1;
//            sum = num * val;
//        }
//
//        n -= (int) (sum + 1);
//        int v = (int) (Math.pow(10, val) + n / (val + 1));
//        String str = String.valueOf(v);
//        return str.charAt((int) (n % val + 1)) - '0';
//    }
    public int solution(int n){

        long sum = 0;
        int i = 0;
        while (sum < n){
            sum += getSize(++i);
        }

        if(sum!=n)
            sum -= getSize(i);

        return getNumAt(i, (int) (n - sum));
    }

    public int getSize(int num){
        int size = 0;
        while (num > 0){
            num /= 10;
            size++;
        }
        return size;
    }

    //n/10^n-1 % 10
    int getNumAt(int num, int idx){
        if(idx == 0)
            return num % 10;

        int size = getSize(num);
        int res = (int) (num / Math.pow(10, size - idx));
        return res % 10;

    }
}
