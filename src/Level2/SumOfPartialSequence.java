package Level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SumOfPartialSequence { //연속된 부분수열의합
    public static void main(String[] args) {
        int[] sequence = {2,2,2,2,2};
        int k = 6;
        System.out.println(Arrays.toString(solution(sequence, k)));
    }

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] sum = new int[sequence.length+1];
        int startIndex= 0;
        int endIndex = 0;
        int length = 10000000;
        for(int i=1; i<= sequence.length;i++){
            sum[i] = sum[i-1]+sequence[i-1];
        }


        while(startIndex<sequence.length && endIndex<sequence.length){
            int value = sum[endIndex+1]-sum[startIndex];
            if(value>k){
                startIndex++;
            } else if (value ==k) {
                if(endIndex-startIndex <length){
                    answer[0] = startIndex;
                    answer[1] = endIndex;
                    length = endIndex-startIndex;
                }
                endIndex++;
            }else{
                endIndex++;
            }
        }

        return answer;
    }
}
