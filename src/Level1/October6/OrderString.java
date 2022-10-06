package Level1.October6;

import java.util.Arrays;


public class OrderString { //내 마음대로 정렬하기
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n =1;
        System.out.println(Arrays.toString(solution(strings, n)));

    }

    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        for(int i=0; i< strings.length; i++){
            answer[i] = strings[i].charAt(n)+strings[i];
        }
        Arrays.sort(answer);
        for(int j=0; j< strings.length;j++){
            answer[j] = answer[j].substring(1);
        }

        return answer;
    }
}
