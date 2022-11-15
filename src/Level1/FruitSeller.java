package Level1;

import java.util.Arrays;

public class FruitSeller { //과일 장수
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(solution(k,m,score));

    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        int r = score.length%m;
        for(int i=score.length-m; i>=r;i=i-m){
            answer += m*score[i];
        }
        return answer;
    }
}
