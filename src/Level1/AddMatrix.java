package Level1;

import java.util.Arrays;

public class AddMatrix { // 행렬의 덧셈
    public static void main(String[] args) {
        int[][] arr1 = {{1},{2}};
        int[][] arr2 = {{3},{4}};
        System.out.println(Arrays.deepToString(solution(arr1, arr2)));

    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i=0; i< arr1.length; i++){
            for(int j=0; j<arr1[i].length;j++){
                answer[i][j] = arr1[i][j]+arr2[i][j];
            }
        }
        return answer;
    }
}
