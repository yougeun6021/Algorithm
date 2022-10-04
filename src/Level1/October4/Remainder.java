package Level1.October4;

public class Remainder {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(solution(n));

    }//나머지가 1이되는 수 찾기
    public static int solution(int n) {
        int answer = 2;
        if(n%2==0){
            for(int i=3; i<n; i=i+2){
                if(n%i==1){
                    answer =i;
                    break;
                }
            }
        }
        return answer;
    }
}
