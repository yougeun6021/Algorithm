package Level1.October29;

import java.util.Arrays;

public class SumFraction { //분수의 덧셈
    public static void main(String[] args) {
        int denum1 =1;
        int num1 =2;
        int denum2 =3;
        int num2 =4;
        System.out.println(Arrays.toString(solution(denum1, num1, denum2, num2)));

    }

    public static int[] solution(int denum1, int num1, int denum2, int num2) {
        int denominator = num1*num2;
        int numerator = denum1*num2+denum2*num1;
        int gcd = gcd(denominator,numerator);

        return new int[]{numerator/gcd,denominator/gcd};
    }

    static int gcd(int a,int b){
        while(b!=0){
            int r =a%b;
            a=b;
            b=r;

        }

        return a;
    }
}
