package Level2.October23;

import java.util.Arrays;

public class DifferentBit { //두개 이하로 다른 비트
    public static void main(String[] args) {
        long[] numbers = {1001};
        System.out.println(Arrays.toString(solution(numbers)));

    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index =0;
        for(long number:numbers){
            if(number%2==0){
                answer[index++] = number+1;
            }else{
                String str = Long.toString(number,2);

                if(!str.contains("0")){
                    answer[index++] = (long) (number+Math.pow(2,str.length()-1));
                    continue;
                }

                for(int i=str.length()-1;i>=0; i--){
                    if(str.charAt(i)=='0'){
                        answer[index++] = (long) (number+Math.pow(2,str.length()-i-2));
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
