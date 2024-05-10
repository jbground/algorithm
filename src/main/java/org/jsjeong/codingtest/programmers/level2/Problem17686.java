package org.jsjeong.codingtest.programmers.level2;


import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 파일명 정렬
 * https://school.programmers.co.kr/learn/courses/30/lessons/17686
 */
public class Problem17686 {

    public String[] solution(String[] files) {
        String da = "asdvf.pf";
        Pattern test = Pattern.compile("([.])");
        Pattern test2 = Pattern.compile("(.)");
        Matcher matcher = test.matcher(da);
        matcher.find();
        System.out.println(matcher.group());
        matcher = test2.matcher(da);
        matcher.find();
        System.out.println(matcher.group());

        Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");

        Arrays.sort(files, (s1, s2) -> {
            Matcher m1 = p.matcher(s1.toLowerCase());
            Matcher m2 = p.matcher(s2.toLowerCase());
            m1.find();
            m2.find();
            System.out.println(m1.group(1) +", "+m1.group(2));

            if(!m1.group(1).equals(m2.group(1))) {
                return m1.group(1).compareTo(m2.group(1));
            } else {
                return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
            }
        });

        return files;
    }


//    public String[] solution(String[] files) {
//        ArrayList<Data> list = new ArrayList<>();
//
//        for (int i = 0; i < files.length; i++) {
//            String s = files[i];
//
//            int header = findHeaderIndex(s);
//            int number = findNumberIndex(s, header);
//
//            list.add(new Data(i, s.substring(0, header), Integer.parseInt(s.substring(header, number))));
//        }
//        System.out.println(list);
//        Collections.sort(list);
//        System.out.println(list);
//
//        String[] answer = new String[files.length];
//        for(int i = 0; i < answer.length; i++){
//            answer[i] = files[list.get(i).idx];
//        }
//
//        return answer;
//    }

    private int findHeaderIndex(String file){
        int idx = file.length();
        for(int i = 0; i< file.length(); i++){
            if ('0' <= file.charAt(i) && file.charAt(i) <= '9') {//숫자 범위
                idx = i;
                break;
            }
        }
        return idx;
    }

    private int findNumberIndex(String file, int start){
        int len = file.length();
        int ret = len;
        int count = 0;
        for(int i=start; i<len; i++) {
            if(!Character.isDigit(file.charAt(i))) {
                ret = i;
                break;
            }
            count += 1;
            if(count == 5) {
                ret = i + 1;
                break;
            }
        }

        return ret;
    }

    static class Data implements Comparable<Data>{
        int idx;
        String header;
        int number;

        public Data(int idx, String header, int number) {
            this.idx = idx;
            this.header = header;
            this.number = number;
        }

        @Override
        public int compareTo(Data o) {
            if(!header.equalsIgnoreCase(o.header)) {
                return header.toUpperCase(Locale.ROOT).compareToIgnoreCase(o.header);
            } else if(number != o.number) {

                return Integer.compare(number, o.number);
            } else {

                return 0;
            }
        }

        @Override
        public String toString() {
            return "Data{" +
                    "header='" + header + '\'' +
                    ", number=" + number +
                    '}';
        }
    }

}
