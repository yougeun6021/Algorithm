package Level1;


import java.util.Stack;

public class Hamburger { //햄버거 만들기
    public static void main(String[] args) {
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println(solution2(ingredient));
    }

    public static int solution(int[] ingredient) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j : ingredient) {
            stringBuilder.append(j);
        }
        String s= stringBuilder.toString();

        while(s.contains("1231")){
            s = s.replaceFirst("1231","");
        }

        return (stringBuilder.length()-s.length())/4;
    }

    public static int solution2(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int j : ingredient) {
            if (stack.isEmpty() && j == 1) {
                stack.add(1);
                continue;
            }

            if (!stack.isEmpty()) {
                switch (j) {
                    case 1:
                        stack.add(1);
                        break;
                    case 2:
                        stack.add(2);
                        break;
                    case 3:
                        if (stack.peek() == 1) {
                            stack.clear();
                        } else {
                            stack.add(3);
                        }
                }
            }

            if(stack.size() >= 4 && stack.get(stack.size() - 1) == 1 && stack.get(stack.size() - 2) == 3
                    && stack.get(stack.size() - 3) == 2 && stack.get(stack.size() - 4) == 1) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
                answer++;
            }
        }

        return answer;
    }

    public int solution3(int[] ingredient) {
        int answer = 0;
        int[] pack = new int[ingredient.length];

        int j = 0;
        for (int i = 0; i < ingredient.length; i++) {
            pack[j] = ingredient[i];
            if (j >= 3) {
                if (pack[j-3] == 1 && pack[j-2] == 2 && pack[j-1] == 3 && pack[j] == 1) {
                    answer += 1;
                    j -= 4;
                }
            }
            j++;
        }

        return answer;
    }




}
