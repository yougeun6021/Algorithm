package Level1;

public class CursedNumber3 { //저주받은 숫자 3
    public static void main(String[] args) {
        int n = 40;
        System.out.println(solution(n));

    }

    public static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=n; i++){
            answer++;

            String s = Integer.toString(answer);

            while(answer%3 == 0 || s.contains("3")){
                answer++;
                s = Integer.toString(answer);
            }
        }
        return answer;
    }
}
