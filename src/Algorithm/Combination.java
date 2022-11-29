package Algorithm;

import java.util.Arrays;

public class Combination {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        for(int i=1;i<=3;i++){
            int[] output = new int[i];
            combination(arr,output,0,arr.length,i,0);
        }
    }

    public static void combination(int[] arr, int[] output, int start, int n , int r, int depth){
        if(depth==r){
            System.out.println(Arrays.toString(output));
            return;
        }

        for(int i=start;i<n;i++){
            output[depth] = arr[i];
            combination(arr,output,i+1,n,r,depth+1);
        }
    }
}
