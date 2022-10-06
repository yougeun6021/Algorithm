package Level1.October6;

import java.util.Arrays;
import java.util.HashSet;

public class PickTwoAdd { // 두 개 뽑아서 더하기
    public static void main(String[] args) {
        int[] numbers = {5,0,2,7};
        System.out.println(Arrays.toString(solution(numbers)));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                hashSet.add(numbers[i]+numbers[j]);
            }
        }
        answer = Arrays.stream(hashSet.toArray(new Integer[0])).sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
