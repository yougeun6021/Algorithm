package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HateSameNum { // 같은 숫자는 싫어

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        int number = arr[0];
        for(int i=1; i<arr.length;i++){
            if(number!=arr[i]){
                answer.add(arr[i]);
                number =arr[i];
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray(); // list<Integer> -> int[]
        //return Arrays.stream(answer.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();  list<Integer>->Integer[]->int[]
    }
}
