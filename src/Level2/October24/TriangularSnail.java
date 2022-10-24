package Level2.October24;

import java.util.Arrays;

public class TriangularSnail { //삼각 달팽이
    public static void main(String[] args) {
        int n =5;
        System.out.println(Arrays.toString(solution(n)));
    }

    public static int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    x++;
                } else if (i % 3 == 1) {
                    y++;
                } else {
                    x--;
                    y--;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }
}