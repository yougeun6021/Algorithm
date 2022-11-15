package Level1;



public class OddEven { // 짝수와 홀수
    public  static void main(String[] args) {
        int a = 3;
        int b = 4;
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution2(a));
        System.out.println(solution2(b));

    }

    public static String solution(int num) {
        String answer = "Odd";
        if(num%2==0) {
            answer = "Even";
        }
        return answer;
    }

    public static String solution2(int num) {
        return num%2==0 ? "Even":"Odd";
    }




}


