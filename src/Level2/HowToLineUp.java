package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowToLineUp { // 줄서는방법
    public static void main(String[] args) {
        int n = 3;
        int k = 5;
        System.out.println(Arrays.toString(solution(n, k)));

    }

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        int index = 0;
        List<Integer> list = new ArrayList<>();
        long[] fac = new long[n];
        getFactorial(fac);
        for(int i=1; i<=n;i++){
            list.add(i);
        }
        while (true){

            if(k==1){
                for (Integer number : list) {
                    answer[index++] = number;
                }
                break;
            }

            for(int i=list.size()-1;i>=0;i--){
                if(1+i*fac[list.size()-1]<=k){
                    k -= i*fac[list.size()-1];
                    answer[index++] = list.get(i);
                    list.remove(i);
                    break;
                }
            }
        }

        return answer;
    }

    public static void getFactorial(long[] fac){
        fac[0] = 1;
        for(int i=1; i<fac.length;i++){
            fac[i] = fac[i-1]*i;
        }
    }
}
