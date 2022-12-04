package Level1;

import java.math.BigInteger;

public class bead {//구슬을 나누는 경우의 수

    public static void main(String[] args) {
        int balls = 5;
        int share = 3;
        System.out.println(solution(balls,share));
    }

    public static int solution(int balls, int share) {
        BigInteger answer = factorial(balls).divide(factorial(share).multiply(factorial(balls-share)));

        return answer.intValue();
    }

    public static BigInteger factorial(int n){
        BigInteger value = new BigInteger("1");
        for(int i =2; i<=n;i++){
            value = value.multiply(BigInteger.valueOf(i));
        }

        return value;
    }
}
