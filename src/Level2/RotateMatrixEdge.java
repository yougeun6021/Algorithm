package Level2;

import java.util.Arrays;

public class RotateMatrixEdge {
    public static void main(String[] args) {
        int rows = 3;
        int columns =3;
        int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));

    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr= new int[rows][columns];
        int val = 1;
        for(int i=0; i<rows;i++){
            for(int j=0; j<columns;j++){
                arr[i][j]= val++;
            }
        }

        for(int i=0; i<queries.length;i++){
            answer[i] = rotateMatrix(arr,queries[i]);
        }

        return answer;
    }

    public static int rotateMatrix(int[][] arr,int[] query){
        int min =Integer.MAX_VALUE;
        int startX = query[0]-1;
        int startY = query[1]-1;
        int endX = query[2]-1;
        int endY = query[3]-1;
        int value = arr[startX+1][startY];
        int temp;
        for(int i=startY; i<=endY;i++){
            temp = arr[startX][i];
            min = Math.min(min,temp);
            arr[startX][i] = value;
            value = temp;
        }
        for(int i=startX+1;i<=endX;i++){
            temp = arr[i][endY];
            min = Math.min(min,temp);
            arr[i][endY] = value;
            value =temp;
        }
        for(int i=endY-1;i>=startY;i--){
            temp = arr[endX][i];
            min = Math.min(min,temp);
            arr[endX][i] = value;
            value =temp;
        }

        for(int i=endX-1;i>startX;i--){
            temp = arr[i][startY];
            min = Math.min(min,temp);
            arr[i][startY] = value;
            value =temp;
        }

        return min;

    }
}
