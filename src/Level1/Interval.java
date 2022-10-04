package Level1;

import java.util.ArrayList;
import java.util.List;

public class Interval { //x만큼 간격이 있는 n개의 숫자
    public static void main(String[] args) {
        int x =2;
        int n =5;
        System.out.println(solution(x,n));

    }

    public static List<Long> solution(int x, int n) {
        List<Long> answer = new ArrayList<>();
        for(int i=1; i<=n; i++){
            answer.add((long)i*x);
        }
        return answer;
    }
}
