package Level2;

public class Tile2 { //2*n 타일
    public static void main(String[] args) {
        int n =4;
        System.out.println(solution(n));

    }

    public static int solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        for(int i=2; i<n;i++){
            arr[i] = (arr[i-1]+arr[i-2])%1000000007;
        }
        return arr[n-1]%1000000007;
    }
}
