package Level1;

import java.util.Arrays;

public class MaxNumber2 { //최댓값 만들기 2

    public static void main(String[] args) {
        int[] numbers = {1, 2, -3, 4, -5};
        System.out.println(solution(numbers));

    }

    public static int solution(int[] numbers) {
        Arrays.sort(numbers);
        int a = numbers[0]*numbers[1];
        int b = numbers[numbers.length-1]*numbers[numbers.length-2];
        return Math.max(a, b);
    }
}
