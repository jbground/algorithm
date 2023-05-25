package org.jsjeong.algorithm.greedy;

import java.util.Scanner;

/**
 * Union & Find 알고리즘
 * 최소 스패닝 트리, 크루스칼 Union&Find 활용
 *
 */
public class UnionFind {
    static int[] unf;
    public static int find(int v){
        if(v==unf[v]) {
            return v;
        } else{
            return unf[v]=find(unf[v]);
        }
    }
    public static void union(int a, int b){
        int fa=find(a);
        int fb=find(b);
        if(fa!=fb) {
            unf[fa]=fb;
        }
    }

    public static void solution(int num, int[][] students) {

        unf=new int[num+1];

        for(int i=1; i<=num; i++){
            unf[i]=i;
        }

        for(int[] ints : students){
            int a = ints[0];
            int b = ints[1];
            union(a, b);
        }

        int fa=find(3);
        int fb=find(8);
        if(fa==fb){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args){
        int num = 9;
        int[][] students = {{1, 2},{2, 3},{3, 4},{1, 5},{6, 7},{7, 8},{8, 9},{3, 8}};
        solution(num, students);
    }
}
