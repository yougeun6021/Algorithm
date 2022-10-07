package Level1.October7;

public class SearchPrimeNumber { // 소수 찾기
    public static void main(String[] args) {
        int n =5;
        System.out.println(solution(n));

    }

    public static int solution(int n) {
        int answer = 1;
        for(int i =3; i<=n; i=i+2 ){
            if(primeNumber(i)){
                answer++;
            }
        }
        return answer;
    }

    public static boolean primeNumber(int m){
        for(int j=3;j<=Math.sqrt(m);j=j+2){
            if(m%j==0){
                return false;
            }
        }
        return true;
    }
}
