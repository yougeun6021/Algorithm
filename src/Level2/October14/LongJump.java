package Level2.October14;

public class LongJump { //멀리뛰기
    public static void main(String[] args) {
        int n=4;
        System.out.println(solution(4));

    }

    public static long solution(int n) {
        int answer = 0;
        int a=0;
        int b=1;
        for(int i=1;i<=n;i++){
            answer = (a+b)%1234567;
            a=b;
            b=answer;
        }
        return answer%1234567;
    }
}
