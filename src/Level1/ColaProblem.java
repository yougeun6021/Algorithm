package Level1;

public class ColaProblem { //콜라 문제
    public static void main(String[] args) {
        int a =2;
        int b =1;
        int n =20;
        System.out.println(solution(a,b,n));

    }

    public static int solution(int a, int b, int n) {
        int answer = 0;
        while((n/a>=1)){
            answer = answer+b*(n/a);
            n = b*(n/a)+n%a;
        }
        return answer;
    }
}
