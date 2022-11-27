package Level2;

import java.util.Arrays;

public class CompressionNumber { //쿼드 압축 후 개수  세기
    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));

    }

    public static int[] solution(int[][] arr) {
        int zeroCount = 0;
        int oneCount = 0;
        int sum = 0;
        int length = arr.length;
        int arrSum = 0;

        for(int i=0; i<arr.length;i++){
            for(int j=0; j<arr.length;j++){
                arrSum += arr[i][j];
            }
        }

        while(length!=1){

            for(int m = 0; m< arr.length;m=m+length){
                for(int n=0; n< arr.length;n=n+length){
                    for(int i=m; i<m+length;i++){
                        for(int j=n; j<n+length;j++){
                            sum += arr[i][j];
                        }
                    }

                    if(sum==Math.pow(length,2)){
                        oneCount -= 3;
                    }

                    if(sum==0){
                        zeroCount -=3;
                    }

                    sum = 0;
                }
            }
            length = length/2;
        }

        return new int[]{(int) (Math.pow(arr.length,2)-arrSum+zeroCount),arrSum+oneCount};
    }
}
