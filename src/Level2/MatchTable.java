package Level2;

public class MatchTable { // 예상대진표
    public static void main(String[] args) {
        int n = 2;
        int a = 1;
        int b = 2;
        System.out.println(solution(n,a,b));


    }


    public static int solution(int n, int a, int b)
    {
        int answer = 1;
        while (Math.abs(a - b) != 1 || a / 2 == b / 2) {
            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
            answer++;
        }

        return answer;
    }

    public static int solution2(int n, int a, int b)
    {
        int answer = 0;
        while (a!=b) {
            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
            answer++;
        }

        return answer;
    }

}
