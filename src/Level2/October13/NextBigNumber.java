package Level2.October13;

public class NextBigNumber { //다음 큰 숫자
    public static void main(String[] args) {
        int n = 78;
        System.out.println(solution(n));

    }

    public static int solution(int n) {
        int answer = 0;
        int number = n+1;
        String str = Integer.toString(n,2);
        int oneCount = str.replace("0","").length(); // Integer.bitcount(int i)
        while(answer==0){
            if(Integer.toString(number,2).replace("0","").length()==oneCount){
                answer = number;
            }
            number++;
        }
        return answer;
    }

    public static int solution2(int n) {
        int answer = 0;
        int number = n+1;
        int oneCount = Integer.bitCount(n);
        while(answer==0){
            if(Integer.bitCount(number)==oneCount){
                answer = number;
            }
            number++;
        }
        return answer;
    }
}
