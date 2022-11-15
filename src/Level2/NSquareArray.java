package Level2;

import java.util.Arrays;

public class NSquareArray { //n^2배열 자르기
    public static void main(String[] args) {
        int n = 3;
        int left =2;
        int right = 5;
        System.out.println(Arrays.toString(solution(n, left, right)));


    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        for(long i = left; i<=right; i++){
            int startNumber = (int) (i/n+1);
            int index = (int) (i-left);
            int plusNumber = (int) (i%n-i/n);
            if((i/n)>=i%n){
                answer[index] = startNumber ;
            }else{
                answer[index] =startNumber+plusNumber;
            }
        }
        return answer;
    }
}
