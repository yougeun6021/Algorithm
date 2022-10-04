package Level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DescendingOrder { // 정수 내림차순으로 배치하기

    public static void main(String[] args) {
        int n = 118372;
        System.out.println(solution(n));
    }

    public static long solution(long n) {
        List<String> stringList = Arrays.asList(String.valueOf(n).split(""));
        stringList.sort(Collections.reverseOrder());
        return Long.parseLong(String.join("", stringList));
    }

}
