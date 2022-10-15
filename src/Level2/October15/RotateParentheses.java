package Level2.October15;


import java.util.Stack;

public class RotateParentheses { //괄호 회전하기
    public static void main(String[] args) {
        String s ="[](){}";
        System.out.println(solution(s));

    }

    public static int solution(String s) {
        int answer =0;
        for(int i=0; i<s.length();i++){
            if(collect(s)){
                answer++;
            }
            s=s.substring(1)+s.charAt(0);
        }
        return answer;
    }

    public static boolean collect(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch =='[') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                if(ch==')' && stack.peek()=='('){
                    stack.pop();
                }
                if(ch=='}' && stack.peek()=='{'){
                    stack.pop();
                }
                if(ch==']' && stack.peek()=='['){
                    stack.pop();
                }
            }else{
                return false;
            }
        }
        return stack.isEmpty();
    }


}
