package Level1.October4;

public class AddAbs { //음양 더하기
    public static void main(String[] args) {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        System.out.println(solution(absolutes,signs));
    }

    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<absolutes.length;i++){
            if(signs[i]){
                answer += absolutes[i];
            }else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }

    public static int solution2(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i=0; i<absolutes.length;i++){
            answer += signs[i] ? absolutes[i]:-absolutes[i];
        }
        return answer;
    }
}
