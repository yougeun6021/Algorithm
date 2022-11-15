package Level1;

public class NumberOfDivisor { //약수의 개수와 덧셈
    public static void main(String[] args) {
        int left = 13;
        int right = 17;
        System.out.println(solution(left,right));

    }

    public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            answer += Math.sqrt(i)%1==0? -i:i;
        }
        return answer;
    }
}
