package Level1.October4;

import java.util.ArrayList;
import java.util.List;

public class ReverseNumber { // 자연수 뒤집어 배열로 만들기
    public static void main(String[] args) {
        long n = 1102321032;
        System.out.println(solution(n));
    }

    public static List<Long> solution(long n) {
        List<Long> answer = new ArrayList<>();
        while (n!=0){
            answer.add(n%10);
            n=n/10;
        }
        return answer;
    }

}
