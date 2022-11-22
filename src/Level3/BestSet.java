package Level3;

import java.util.Arrays;

public class BestSet { //최고의 집합
    public static void main(String[] args) {
        int n = 2;
        int s = 8;
        System.out.println(Arrays.toString(solution(n, s)));

    }

    public static int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n>s){
            return new int[]{-1};
        }
        int a = s/n;
        int b = s%n;
        for(int i=0; i<n;i++){
            if(i>=n-b){
                answer[i] = a+1;
            }else{
                answer[i] = a;
            }
        }
        return answer;
    }
}
