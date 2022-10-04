package Level1;

public class SumDivisor { //약수의 함
    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        for(int i=1; i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(i==n/i){
                    answer = answer+i;
                }else{
                    answer = answer+i+n/i;
                }
            }
        }
        return answer;
    }
}
