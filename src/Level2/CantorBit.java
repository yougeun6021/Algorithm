package Level2;

public class CantorBit { //칸토르 비트열
    public static void main(String[] args) {
        int n = 10;
        long l = 4;
        long r = 17;
        System.out.println(solution(n,l,r));

    }

    public static int solution(int n, long l, long r) {
        long answer = r-l+1;
        for(long i=l-1;i<=r-1;i++){
            long divide = 1;
            for(int j=0;j<n;j++){
                if((i/divide)%5==2){
                    answer--;
                    break;
                }
                divide*=5;
            }
        }
        return (int) answer;
    }
}
