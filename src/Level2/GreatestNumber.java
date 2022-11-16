package Level2;

import java.util.Arrays;

public class GreatestNumber { // 가장 큰 수
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));

    }

    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i=0; i<numbers.length;i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(arr,(o1, o2) -> (o2+o1).compareTo(o1+o2));

        if(arr[0].equals("0")){
            return "0";
        }

        return String.join("",arr);
    }
}
