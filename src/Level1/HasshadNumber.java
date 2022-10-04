package Level1;

public class HasshadNumber { // 하샤드 수 판별
    public static void main(String[] args) {
        int x = 11;
        System.out.println(solution(x));

    }

    public static boolean solution(int x) {
        int a = x;
        int sum = 0;
        while(a!=0){
            sum += a%10;
            a=a/10;
        }
        return x%sum==0;
    }


}
