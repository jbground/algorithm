package org.jsjeong.codingtest.level4;

import java.util.LinkedList;

/**
 * 총 노드 10개 트리구조
 * CEO는 root 노드
 */
public class Problem1 {

    
    Employee[] employees;
    int[] reader;
    class Employee {
        int data;
        LinkedList<Employee> adjacent;
        LinkedList<Integer> team;
        
        Employee(int data) {
            this.data = data;
            adjacent = new LinkedList<>();
            team = new LinkedList<>();
        }
    }

    public int solution(int[] sales, int[][] links) {

        employees = new Employee[sales.length];
        for (int i = 0; i < sales.length; i++) {
            employees[i] = new Employee(sales[i]);
        }

        for (int[] teamReader : links) {



            this.addEdge(teamReader[0], teamReader[1]);
        }

        int answer = 0;
        return answer;
    }

    public void addEdge(int i1, int i2) {
        Employee n1 = employees[i1];
        Employee n2 = employees[i2];
        if (!n1.adjacent.contains(n2))
            n1.adjacent.add(n2);


    }

    public static void main(String[] args) {
        int[][] test = {{1, 2},{3, 4},{5, 6}};

        for (int[] reader : test) {
            System.out.println(reader[0]);

//            for (int team : reader) {
//                System.out.println(team);
//            }
        }
    }
}
