package Algorithm;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        int n = 3;
        int r = 2;
        permutation(n,r);
    }

    public static void permutation(int n,int r) {
        int[] answer = new int[r];
        int[] arr = new int[n];
        for(int i=1; i<=n;i++){
            arr[i-1] = i;
        }
        boolean[] visited = new boolean[n];
        perm(arr,answer,visited,0,n,r);
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
