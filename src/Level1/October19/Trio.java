package Level1.October19;

public class Trio {
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        System.out.println(solution(number));
    }

    public static int solution(int[] number) {
        int answer = 0;
        for(int i=0; i<number.length-2; i++){
            for(int j=i+1;j<number.length-1;j++){
                for(int p = j+1; p< number.length; p++){
                    if(number[i]+number[j]+number[p]==0){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
