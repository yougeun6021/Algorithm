package Level2;

public class Dot { //점 찍기
    public static void main(String[] args) {
        int k = 1;
        int d = 5;
        System.out.println(solution(k,d));

    }

    public static long solution(int k, int d) {
        long answer = 0;
        long dSquare = (long) d *d;
        for(long i=0; i<=d; i=i+k){;
            answer+= (long) Math.sqrt(dSquare-i*i)/k+1;
        }
        return answer;
    }



}
