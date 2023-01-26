package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindBigNumberInTheBack { //뒤에 있는 큰 수 찾기
    public static void main(String[] args) {
        int[] numbers = {9,7,4,5,6,6,1};
        System.out.println(Arrays.toString(solution2(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length;i++){
            int value = numbers[i];
            int bigNumber = -1;
            for(int j=i+1; j<numbers.length;j++){
                if(value<numbers[j]){
                    bigNumber = numbers[j];
                    break;
                }
            }
            answer[i] = bigNumber;
        }
        return answer;
    }

    public static int[] solution2(int[] numbers) {
        int length = numbers.length;
        int[] answer = new int[length];
        answer[length-1] = -1;
        List<Integer> list = new ArrayList<>();
        list.add(numbers[length-1]);
        for(int i=length-1; i>=0;i--){
            int bigNumber = -1;
            for(int j=list.size()-1; j>=0;j--){
                int value = list.get(j);
                if(numbers[i]<value){
                    bigNumber = value;
                    break;
                }else{
                    list.remove((Object)value);
                }
            }
            list.add(numbers[i]);
            answer[i] = bigNumber;
        }

        return answer;
    }


}
