package Level2.October12;

import java.util.Arrays;

public class MaxMin { // 최댓값과 최솟값
    public static void main(String[] args) {
        String s = "1 -3 -2 4";
        System.out.println(solution(s));

    }

    public static String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        return (arr[0])+" "+(arr[arr.length-1]);
    }

    public static String solution2(String s) {
        String[] arr = s.split(" ");
        String max =arr[0];
        String min =arr[0];
        for(String str:arr){
            if(Integer.parseInt(str)>Integer.parseInt(max)){
                max = str;
            }
            if(Integer.parseInt(str)<Integer.parseInt(min)){
                min = str;
            }

        }
        return min+" "+max;
    }

}
