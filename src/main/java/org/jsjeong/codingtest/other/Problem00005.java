package org.jsjeong.codingtest.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem00005 {

    public static void solution(List<ConferenceRoom> conferenceRooms){
        Collections.sort(conferenceRooms);
        System.out.println(conferenceRooms);

        int endTime = 0;
        for (ConferenceRoom c : conferenceRooms) {
            if (c.start >= endTime) {
                endTime = c.end;
                System.out.println(c);

            }
        }
    }

    public static void main(String[] args) {
        int[] starts = {1, 2, 3, 4, 5};
        int[] ends = {4, 3, 5, 6, 7};

        List<ConferenceRoom> conferenceRooms = new ArrayList<>();
        for (int i = 0; i < starts.length; i++) {
            ConferenceRoom c = new ConferenceRoom(starts[i], ends[i]);
            conferenceRooms.add(c);
        }
        solution(conferenceRooms);
    }

    static class ConferenceRoom implements Comparable<ConferenceRoom> {

        int start, end;

        public ConferenceRoom(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(ConferenceRoom o) {
            if(this.end == o.end){
                return this.start - o.start;
            }else{
                return this.end - o.end;
            }
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("ConferenceRoom{");
            sb.append("start=").append(start);
            sb.append(", end=").append(end);
            sb.append('}');
            return sb.toString();
        }
    }
}
