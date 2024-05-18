package org.jsjeong.codingtest.programmers.other;

public class Test1241252 {
    public int[][] solution(int[][] square, int k) {
        int size = square.length;
        for(int i = 0; i < k;i++){
            //*2를 k번
            size *= 2;
        }

        System.out.println(size);
        int[][] answer = new int[size][size];

        //row 절반 먼저 채우기
        for(int i = 0; i < square.length; i++){
            answer[i] = expansion_row(square[i], k, size);
        }

        //col 전부 채우기
        symmetry(answer, square.length, k);
        return answer;
    }

    private int[] expansion_row(int[] source, int k, int size) {
        //String으로 변환
        String result = "";
        StringBuilder sb = new StringBuilder();
        sb.reverse();
        for(int i : source){
            result = result + i;
        }

        for(int i = 0; i < k; i++){//k번 확장
            sb.setLength(0);
            sb.append(result);
            result = result + sb.reverse();
        }

        System.out.println(result);
        int[] res = new int[size];
        for(int i = 0; i < size; i++){
            res[i] = Integer.parseInt(result.substring(i, i+1));
        }
        return res;
    }

    private void symmetry(int[][] answer, int idx, int k){
        if(k == 0)
            return;

        int index = 1;
        for(int i = idx; i < idx * 2; i ++) {
            answer[i] = answer[idx-index];
            index++;
        }

        symmetry(answer, idx*2,  k-1);

    }

}
