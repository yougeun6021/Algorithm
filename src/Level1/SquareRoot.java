package Level1;

public class SquareRoot { // 정수 제곱근 판별
    public static void main(String[] args) {
        long n = 196;
        System.out.println(solution(n));

    }
    public static long solution(long n) {
        long answer = -1;
        double sqrt = Math.sqrt(n);
        if(Math.ceil(sqrt)==sqrt){
            answer = (long)Math.pow(sqrt+1,2);
        }
        return answer;
    }

}
