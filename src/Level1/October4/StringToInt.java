package Level1.October4;

public class StringToInt { // 문자열을 정수로 바꾸기
    public static void main(String[] args) {
        String s = "1234";
        String s2= "-1234";
        System.out.println(solution(s));
        System.out.println(solution(s2));
    }

    public static int solution(String s) {
        return Integer.parseInt(s);
    }
}
