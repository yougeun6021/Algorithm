package Level1;

public class StringBasic { //문자열 다루기 기본
    public static void main(String[] args) {
        String s = "1234";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        String s2= s.replaceAll("\\D","");
        return (s.length()==4 || s.length()==6) && s.length()==s2.length();

    }


}
