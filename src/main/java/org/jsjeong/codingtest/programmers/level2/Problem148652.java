package org.jsjeong.codingtest.programmers.level2;

/**
 * 유사 칸토어 비트열
 * https://school.programmers.co.kr/learn/courses/30/lessons/148652
 * 해당 코드는 5진수(quinary)를 이용하여 구간 내에서 수열의 항을 생성하고, 2가 포함된 수열의 항은 합산하지 않고 항 개수를 세는 문제를 해결합니다.
 * 여기서 (i/(int)Math.pow(5,j))%5는 i를 5진수로 바꾼 후 j번째 자리의 값을 가져오는 과정입니다.
 * 즉, (i/(int)Math.pow(5,j))는 i를 5의 j승으로 나눈 몫을 계산하는데, 이는 i를 5진수로 표현했을 때 j번째 자리의 값을 계산하는 것과 같습니다.
 * 이후 %5를 하면 j번째 자리의 값만을 추출할 수 있습니다. 
 * 따라서 i/(int)Math.pow(5,j))%5==2는 i를 5진수로 표현했을 때 j번째 자리의 값이 2인지 여부를 확인하는 조건문입니다.
 * 2가 포함된 수열의 항은 합산하지 않아야 하기 때문에, 이 경우에는 answer에서 제외됩니다.
 */

public class Problem148652 {

    public int solution(int n, long l, long r) {
        long answer = r - l + 1;
        for (long i = l - 1; i <= r - 1; i++) {
            for (int j = 0; j < n; j++) {
                if ((i / (int) Math.pow(5, j)) % 5 == 2) {
                    answer--;
                    break;
                }
            }
        }

        return (int) answer;
    }


    private int answer = 0;
    private long[] arr;

//    public int solution(int n, long l, long r) {
//        arr = new long[n + 1];
//        long k = 1;
//        arr[0] = 1;
//        for (int i = 1; i <= n; i++) {
//            k *= 5;
//            arr[i] = k;
//        }
//
//        dfs(n, 0, l, r, 1);
//        return answer;
//    }

    private void dfs(int n, int depth, long l, long r, long k) {
        int mul = n - depth;
        long end = k * arr[mul];
        long start = end - arr[mul] + 1;
        if (l <= start && end <= r) {
            answer += (int) Math.pow(4, mul);
            return;
        }
        if (end < l || start > r) {
            return;
        }

        long x = k * 5;
        dfs(n, depth + 1, l, r, x - 4);
        dfs(n, depth + 1, l, r, x - 3);
        dfs(n, depth + 1, l, r, x - 1);
        dfs(n, depth + 1, l, r, x);
    }
}
