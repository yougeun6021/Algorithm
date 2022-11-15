package Level1;

import java.util.Arrays;

public class OXQuiz { //OX퀴즈
    public static void main(String[] args) {
        String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
        System.out.println(Arrays.toString(solution(quiz)));

    }

    public static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[] sarr;
        int cal = 0;
        for(int i=0; i<quiz.length; i++){
            sarr = quiz[i].split("=");
            cal = cal(sarr[0]);
            answer[i] = Integer.parseInt(sarr[1].trim())==cal ? "O":"X";
        }

        return answer;
    }

    public static int cal(String my_string) {
        int answer = 0;
        boolean sign = true;
        String[] sarr = my_string.split(" ");;
        for(int i=0; i<sarr.length; i++){
            if(i%2==0){
                answer += sign? Integer.parseInt(sarr[i]):-Integer.parseInt(sarr[i]);
            }else{
                sign = sarr[i].equals("+");
            }
        }
        return answer;
    }
}
