package Level1;

import java.util.Arrays;

public class GymClothes { // 체육복
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4};
        int[] reverse = {1,3,5};
        System.out.println(solution(5,lost,reverse));


    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = reserve[j] = -1;
                    break;
                }
            }
        }

        //체육복을 reserve
        for (int lostPerson : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == lostPerson + 1 || reserve[i] == lostPerson - 1) {
                    answer++;
                    reserve[i] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
