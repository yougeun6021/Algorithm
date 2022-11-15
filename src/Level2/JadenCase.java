package Level2;


import java.util.Arrays;

public class JadenCase { //JadenCase 문자열만들기
    public static void main(String[] args) {
        String s ="people   unFollowed me  ";
        System.out.println(solution(s));

    }

    public static String solution(String s) {
        String[] sarr =s.split("");

        if(!sarr[0].equals(" ")){
            sarr[0] = sarr[0].toUpperCase();
        }

        for(int i=1; i<sarr.length; i++){
            if(sarr[i-1].equals(" ") && !sarr[i].equals(" ")){
                sarr[i] = sarr[i].toUpperCase();
            }else{
                sarr[i] = sarr[i].toLowerCase();
            }

        }
        return String.join("",sarr);
    }

    public static String solution2(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer.append(flag ? ss.toUpperCase() : ss);
            flag = ss.equals(" ");
        }

        return answer.toString();
    }

}
