package Level3.November7;

import java.util.Arrays;

public class NumberGame { //숫자 게임
    public static void main(String[] args) {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};
        System.out.println(solution(A,B));

    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int AIndex =0;
        int BIndex =0;
        while(BIndex!=B.length){
            if(A[AIndex]<B[BIndex]){
                answer++;
                AIndex++;
            }
            BIndex++;
        }
        return answer;
    }
}
