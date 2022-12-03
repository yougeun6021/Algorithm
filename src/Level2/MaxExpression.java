package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxExpression { //수식 최대화
    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        System.out.println(solution(expression));
    }

    public static long solution(String expression) {
        long answer = 0;
        String[][] opArr = {{"*","+","-"},{"*","-","+"},{"+","*","-"},{"+","-","*"},{"-","+","*"},{"-","*","+"}};
        List<String> expList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<expression.length();i++){
            char ch =expression.charAt(i);
            if(ch=='*' || ch=='+' || ch=='-'){
                expList.add(sb.toString());
                expList.add(Character.toString(ch));
                sb.setLength(0);
            }else{
                sb.append(ch);
            }
        }
        expList.add(sb.toString());

        for (String[] ops : opArr) {
            List<String> list = new ArrayList<>(expList);
            for (String op : ops) {
                for (int i = 1; i < list.size(); i = i + 2) {
                    if (list.get(i).equals(op)) {
                        long val = Long.parseLong(list.get(i - 1));
                        long val2 = Long.parseLong(list.get(i + 1));
                        long value = 0;
                        switch (op) {
                            case "+":
                                value = val + val2;
                                break;
                            case "*":
                                value = val * val2;
                                break;
                            case "-":
                                value = val - val2;
                                break;
                        }
                        list.set(i, String.valueOf(value));
                        list.remove(i - 1);
                        list.remove(i);
                        i=i-2;
                    }
                }
            }
            answer = Math.max(Math.abs(Long.parseLong(list.get(0))), answer);
        }
        return answer;
    }
}
