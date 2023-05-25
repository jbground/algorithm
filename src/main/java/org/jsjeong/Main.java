package org.jsjeong;

public class Main {
    public static void main(String[] args) {
        char c = 'A';
        String s = String.valueOf(c);
        String test = "A";

        System.out.println(test.equals(c));

        int ttt = (int)c;
        System.out.println(ttt);

//        int banana = solution("banana");
//        System.out.println(banana);
    }

    public static int solution(String s) {
        int answer = 0;
        return separation(s, answer);
    }

    public static int separation(String s, int answer){

        if(s.length() == 0){
            return answer;
        }

        char[] arr = s.toCharArray();
        char first = arr[0];
        int same = 0;
        int not = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] == first){
                same++;
            }else{
                not++;
            }

            if(same == not){
                answer++;
                return separation(s.substring(i+1), answer);
            }
        }
        return ++answer;
    }
}