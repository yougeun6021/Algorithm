package Level2;

import java.util.HashSet;

public class FindPrimeNumber { // 소수 찾기
    public static void main(String[] args) {
        String numbers = "1231";
        System.out.println(solution(numbers));

    }

    public static int solution(String numbers) {
        HashSet<Integer> hashSet =new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=numbers.length();i++){
            dfs(numbers,sb,numbers.length(),i,0,visited,hashSet);
        }
        return hashSet.size();
    }

    public static void dfs(String numbers,StringBuilder sb,int n,int r,int depth,boolean[] visited,HashSet<Integer> hashSet){
        if(depth==r){
            int value = Integer.parseInt(sb.toString());
            if(isPrime(value)){
                hashSet.add(value);
            }
            return;
        }

        for(int i=0; i<n;i++){
            if(!visited[i]){
                sb.append(numbers.charAt(i));
                visited[i] = true;
                dfs(numbers,sb,n,r,depth+1,visited,hashSet);
                sb.setLength(depth);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int value){
        if(value==2){
            return true;
        }
        if(value%2==0 || value==1){
            return false;
        }
        for(int i=3; i<=Math.sqrt(value);i=i+2){
            if(value%i==0){
                return false;
            }
        }

        return true;
    }


}
