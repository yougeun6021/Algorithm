package Level2.October12;

public class Fibonacci {  //피보나치 수
    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int answer = 0;
        int a=0;
        int b=1;
        for(int i=2;i<=n;i++){
            answer = (a+b)%1234567;
            a=b;
            b=answer;
        }
        return answer%1234567;
    }
}
