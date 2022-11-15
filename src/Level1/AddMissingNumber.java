package Level1;

import java.util.Arrays;

public class AddMissingNumber { // 없는 숫자 더하기
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        return 45-sum;
    }
    public static int solution2(int[] numbers) {
        int sum =0;
        for(int number: numbers){
            sum += number;
        }
        return 45-sum;
    }

}
