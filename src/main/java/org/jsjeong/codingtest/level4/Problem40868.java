package org.jsjeong.codingtest.level4;

public class Problem40868 {

    int[][] cache;
    static final int MOD = 1000000007;

    public int solution(int n, int count) {

        cache = new int[n + 1][count + 1];

        return dfs(n, count);
    }

    int dfs(int remain, int show) {

        if (remain == 0)
            return show == 0 ? 1 : 0;

        if (remain < show || show < 0)
            return 0;

        if (cache[remain][show] == 0) {

            long result = 0;

            // 보이는경우
            result += dfs(remain - 1, show - 1);

            // 안보이는경우
            long temp = dfs(remain - 1, show);
            result += temp * (remain - 1) * 2;

            cache[remain][show] = (int) (result % MOD);

        }

        return cache[remain][show];
    }

    public static void main(String[] args) {
        Problem40868 problem = new Problem40868();
        int solution = problem.solution(3, 2);
        System.out.println(solution);
    }
}
