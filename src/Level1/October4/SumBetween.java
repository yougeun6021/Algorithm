package Level1.October4;

public class SumBetween { // 두 수 사이의 합

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        System.out.println(solution2(a,b));

    }

    public static long solution(int a, int b) {
        long answer = 0;
        int n = Math.min(a, b);
        int m = Math.max(a, b);
        for(int i=n; i<=m;i++){
            answer += i;
        }
        return answer;
    }

    public static long solution2(int a, int b) {
        int n = Math.min(a, b);
        int m = Math.max(a, b);
        return (long) (m - n + 1) *(m+n)/2;
    }



}
