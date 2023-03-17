package Level1;

import java.util.Arrays;

public class BilliardsPractice { // 당구연습
    public static void main(String[] args) {
        int m = 10;
        int n = 10;
        int startX = 7;
        int startY = 3;
        int[][] balls = {{7, 2}};
        System.out.println(Arrays.toString(solution(m, n, startX, startY, balls)));

    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int[][] arr = {{startX,-startY},{-startX,startY},{startX,2*n-startY},{2*m-startX,startY}};
        for(int i=0; i< balls.length; i++){
            int min = Integer.MAX_VALUE;

            if(startX == balls[i][0]){

                if(startY>balls[i][1]){
                    min = (int)Math.pow(n-startY+n-balls[i][1],2);
                }else{
                    min = (int)Math.pow(startY+balls[i][1],2);
                }

            }

            if(startY == balls[i][1]){
                if(startX>balls[i][0]){
                    min = (int)Math.pow(m-startX+m-balls[i][0],2);
                }else{
                    min = (int)Math.pow(startX+balls[i][0],2);
                }
            }

            for (int[] a : arr) {
                int value1 = (int)Math.pow(balls[i][0] - a[0],2);
                int value2 = (int)Math.pow(balls[i][1] - a[1],2);
                if (value1 != 0 && value2 != 0) {
                    min = Math.min(min,value1+value2);
                }
            }
            answer[i] = min;
        }
        return answer;
    }


}
