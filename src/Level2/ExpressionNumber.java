package Level2;

public class ExpressionNumber { //숫자의 표현
    public static void main(String[] args) {
        int n =15;
        System.out.println(solution(n));

    }

    public static int solution(int n) {
        int answer = 0;
        for(double i=1; i<=n;i++){
            double firstNumber = n/i-i/2+0.5;
            if(firstNumber<0){
                break;
            }

            if(firstNumber%1==0 && firstNumber>0){
                answer++;
            }
        }
        return answer;
    }
}
