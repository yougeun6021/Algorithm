package Level2.October13;

import java.util.Arrays;

public class Carpet { //카펫
    public static void main(String[] args) {
        int brown = 18;
        int yellow =6;
        System.out.println(Arrays.toString(solution(brown, yellow)));

    }

    public static int[] solution(int brown, int yellow) { //yellow의 약수들의 두 곱
        int[] answer ={};
        for(int i = (int) Math.sqrt(brown+yellow); i>0; i--){
            if((brown+yellow)%i==0){
                if((((brown + yellow) / i)-2)*(i-2)!=yellow){
                    continue;
                }
                answer = new int[]{(brown + yellow) / i, i};
                break;
            }
        }
        return answer;
    }
}
