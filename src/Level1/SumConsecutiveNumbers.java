package Level1;

import java.util.Arrays;

public class SumConsecutiveNumbers { //연속된 수들의 합
    public static void main(String[] args) {
        int num = 3;
        int total =12;
        System.out.println(Arrays.toString(solution(num, total)));


    }

    public static int[] solution(int num, int total) {
        int[] answer = new int[num];
        int startInteger = total/num-(num-1)/2;
        int index =0;
        for(int i=startInteger;i<startInteger+num;i++){
            answer[index++] = i;
        }
        return answer;
    }
}
