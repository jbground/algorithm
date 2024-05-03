package org.jsjeong.codingtest.programmers;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem {

    public long process(String[] birthdays) throws ParseException {
        long answer = 0;
        final List<User> users = new ArrayList<>();

        //initialize users
        for (int i = 0; i < birthdays.length; i++) {
            String birthday = birthdays[i].replace("@", "0");
            String month = birthday.substring(0, 2);
            String day = birthday.substring(2, 4);

            User user = new User(i+1, 2023, Integer.parseInt(month), Integer.parseInt(day));
            users.add(user);
        }

        for (Iterator<User> iter = users.iterator(); iter.hasNext(); ) {
            User user = iter.next();

            for (User target : users) {

                if (user.equals(target)) {
                    continue;
                }

                //토요일이거나 일요일이면 패스
                if (target.isSaturday() || target.isSunday()) {
                    continue;
                }


                int between = user.between(target.birth());
                if (between < 0) {
                    if (between <= -5) {
                        user.increasePresent();
                    }
                } else {
                    if (between >= 5) {
                        user.increasePresent();
                    }
                }

            }
        }

        for (User user : users) {
            answer += user.present;
        }

        return answer;
    }

    public class User {
        private int id;
        private LocalDate birth;
        private final int dateValue;
        private int present;

        public User(int id, int year, int month, int day) {
            this.id = id;
            this.birth = LocalDate.of(year, month, day);
            this.dateValue = birth.getDayOfWeek().getValue();
            this.present = 0;
        }

        public boolean isSaturday() {
            return dateValue == 6;
        }

        public boolean isSunday() {
            return dateValue == 7;
        }

        public int between(LocalDate source) {
            return (int) birth.until(source, ChronoUnit.DAYS);
        }

        public void increasePresent() {
            present++;
        }

        public LocalDate birth() {
            return this.birth;
        }

        public int present() {
            return this.present;
        }


    }
}
