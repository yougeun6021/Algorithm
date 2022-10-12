package Level2.October12;


public class Parentheses { //올바른 괄호
    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));

    }

    static boolean solution(String s) {
        int left = 0;
        int right = 0;
        String[] arr = s.split("");
        for (String value : arr) {
            if (value.equals("(")) {
                left++;
            } else {
                right++;
            }
            if (left < right) {
                return false;
            }
        }
        return left == right;
    }

    static boolean solution2(String s) {
        int left = 0;
        int right = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if (left < right) {
                return false;
            }
        }

        return left == right;
    }
}
