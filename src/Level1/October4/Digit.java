package Level1.October4;

import java.util.Arrays;
import java.util.List;

public class Digit { // 자릿수 더하기
    public static void main(String[] args) {
        int n =1230;
        System.out.println(solution2(n));
    }

    public static int solution(int n) {
        int answer = 0;
        while (n!=0){
            answer = answer+n%10;
            n=n/10;
        }
        return answer;
    }

    public static int solution2(int n) {
        List<String> stringList = Arrays.asList(String.valueOf(n).split(""));
        return stringList.stream().mapToInt(Integer::valueOf).sum();
    }
}
