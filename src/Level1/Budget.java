package Level1;

import java.util.Arrays;

public class Budget { //예산
    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget =10;
        System.out.println(solution(d,budget));
    }

    public static int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        for(int a: d){
            if(sum+a<=budget){
                sum += a;
                answer++;
            }
        }
        return answer;
    }
}
