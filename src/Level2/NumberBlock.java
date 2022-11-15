package Level2;

import java.util.Arrays;

public class NumberBlock { //숫자 블록
    public static void main(String[] args) {
        long begin = 999999990;
        long end = 1000000000;
        System.out.println(Arrays.toString(solution(begin, end)));

    }

    public static int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end-begin+1)];
        int count = 0;
        if(begin==1){
            answer[count++] =0;
            begin++;
        }
        for(long i = begin; i<=end;i++){
            answer[count++] = (int) block(i);
        }
        return answer;
    }

    static long block(long number) {
        long answer = 1;
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (number / i > 10000000) {
//                    answer = i;
                    continue;
                }
                answer = number / i;
                break;
            }
        }
        return answer;
    }
}
