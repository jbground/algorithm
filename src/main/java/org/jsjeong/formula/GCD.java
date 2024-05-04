package org.jsjeong.formula;

/**
 * 최대 공약수
 * 약수 구하기
 */
public class GCD {

    public int gcd(int num1, int num2){
        if(num1 % num2 == 0)
            return num2;
        return gcd(num2, num1 % num2);
    }

    public int gcd2(int a, int b){
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    public int lcm(int a, int b){
        return a * b / gcd2(a, b);
    }

    /**
     * 약수 중 가장 큰 값
     */
    public long measure(long n) {
        long result = 0;
        for (long div = 2; div <= Math.sqrt(n); div++) { //약수 구하기
            if (n % div == 0) {//약수일 경우
                if (n / div > 10000000){
                    result = div;
                    continue;
                } else{
                    result =  (n / div);
                }
                break;
            }
        }
        return result; //약수 중 자기 자신을 제외한 가장 큰 값
    }
}
