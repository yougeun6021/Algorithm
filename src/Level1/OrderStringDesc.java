package Level1;

import java.util.Arrays;
import java.util.Collections;

public class OrderStringDesc { // 문자열 내림차순으로 배치하기
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));

    }

    public static String solution(String s) {
        String[] strings = s.split("");
        Arrays.sort(strings, Collections.reverseOrder());
        return String.join("",strings);

    }
}
