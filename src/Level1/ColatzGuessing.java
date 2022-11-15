package Level1;

public class ColatzGuessing {
    public static void main(String[] args) {
        int num = 626331;
        System.out.println(solution(num));

    }
    public static int solution(long num) {
        int answer = 0;
        while (num!=1){
           num = num%2==0 ? num/2: 3*num+1;
            answer++;
            if(answer>500){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}
