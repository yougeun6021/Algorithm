package Level1;

public class NumberStringAndWord { //숫자 문자열과 영단어
    public static void main(String[] args) {
        String s ="one4seveneight";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0; i< number.length; i++){
            s = s.replaceAll(number[i],Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}
