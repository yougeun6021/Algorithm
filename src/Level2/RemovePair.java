package Level2;

import java.util.Stack;

public class RemovePair { //짝 지어 제거하기
    public static void main(String[] args) {
        String s = "baabaa";
        System.out.println(solution(s));
    }

    public static int solution(String s)
    {
        Stack<Character> stack =new Stack<>();
        stack.push(s.charAt(0));

        for(int i=1; i<s.length();i++){
            if(!stack.isEmpty() && s.charAt(i)==stack.peek()){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        if(stack.isEmpty()){
            return 1;
        }
        return 0;

    }
}
