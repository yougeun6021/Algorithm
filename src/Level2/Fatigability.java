package Level2;

import java.util.TreeSet;

public class Fatigability { //피로도
    public static void main(String[] args) {
        int k =80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        System.out.println(solution(k,dungeons));

    }

    public static int solution(int k, int[][] dungeons) {
        TreeSet<Integer> treeSet =new TreeSet<>();
        int n = dungeons.length;
        int[] output = new int[n];
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = i;
        }
        boolean[] visited = new boolean[n];
        perm(arr,output,visited,0,n,n,k,dungeons,treeSet);

        return treeSet.last();
    }

    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r,int k,int[][] dungeons,TreeSet<Integer> treeSet) {
        if (depth == r) {
            int count =0;
            for (int value : output) {
                int min = dungeons[value][0];
                int need = dungeons[value][1];
                if (k >= min) {
                    k -= need;
                    count++;
                }
            }
            treeSet.add(count);
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r,k,dungeons,treeSet);
                visited[i] = false;
            }
        }
    }

    public static boolean[] check;
    public static int ans = 0;

    public static int solution2(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return ans;
    }

    public static void dfs(int tired, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && dungeons[i][0]<=tired){
                check[i] = true;
                dfs(tired-dungeons[i][1], dungeons, cnt+1);
                check[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }

}
