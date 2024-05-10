package org.jsjeong.regex;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {

    @Test
    void test(){
        //정규식과 일치 하는 문자열 뽑기
        String data = "fE mws1423fde. #@png";

        Pattern p3 = Pattern.compile("(\\w+)");
        Pattern p4 = Pattern.compile("(\\D+)");
        Pattern p5 = Pattern.compile("([a-z.\\s-]+)");
        boolean matches = Pattern.matches("", data);

        Matcher m3 = p3.matcher(data);
        m3.find();
        Matcher m4 = p4.matcher(data);
        m4.find();
        Matcher m5 = p5.matcher(data);
        m5.find();
        boolean matches1 = m3.matches();
        System.out.println(m3.group());
        System.out.println(m4.group());
        System.out.println(m5.group());

        Pattern p1 = Pattern.compile("([0-9]{1,5})");
        Pattern p2 = Pattern.compile("(\\d{1,5})");
        Matcher m1 = p1.matcher(data);
        m1.find();
        Matcher m2 = p2.matcher(data);
        m2.find();

        System.out.println(m1.group());
        System.out.println(m2.group());

        p2.matcher(data).matches();

        m2.reset(data).matches();

        "".matches("([0-9]{1,5})");
        Matcher matcher = Pattern.compile("").matcher("");
    }

    @Test
    void character(){
        String data = "";
        System.out.println(Pattern.matches("^[a-z|A-Z]*$", data));
    }

}
