package Level1;

import java.util.Arrays;

public class SecretMap { // 비밀지도
    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        System.out.println(Arrays.toString(solution(n,arr1,arr2)));

    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i< n; i++){
            answer[i] = Integer.toString(arr1[i]|arr2[i],2);
        }

        for(int j=0; j<n; j++){
            answer[j] = String.format("%" + n + "s", answer[j]);
            System.out.println(answer[j]);
            answer[j] = answer[j].replaceAll("1","#");
            answer[j] = answer[j].replaceAll("0"," ");

        }
        return answer;
    }
}
