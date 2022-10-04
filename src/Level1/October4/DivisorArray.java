package Level1.October4;

import java.util.Arrays;

public class DivisorArray {
    public static void main(String[] args) {
        int[] arr = {5,9,7,10};
        int divisor = 4;
        System.out.println(Arrays.toString(solution(arr, divisor)));

    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        answer = Arrays.stream(arr).filter(a->a%divisor==0).sorted().toArray();
        if(answer.length>0){
            return answer;
        }else{
            return new int[]{-1};
        }
    }

}
