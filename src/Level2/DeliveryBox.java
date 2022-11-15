package Level2;

import java.util.*;

public class DeliveryBox { //택배 상자
    public static void main(String[] args) {
        int[] order = {2, 1, 4, 3, 6, 5, 8, 7, 10, 9};
        System.out.println(solution(order));
    }

    public static int solution(int[] order) {
        int answer = 1;
        Stack<Integer> stack =new Stack<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=1; i<order[0]; i++){
            stack.add(i);
        }
        treeSet.add(order[0]);

        for(int i=1; i< order.length;i++){

            if(treeSet.last()< order[i]){
                for(int j= treeSet.last()+1; j< order[i]; j++){
                    stack.add(j);
                }
                treeSet.add(order[i]);
                answer++;
                continue;
            }

            if(!stack.isEmpty() && stack.peek()==order[i]){
                treeSet.add(stack.pop());
                answer++;
            }else{
                break;
            }
        }
        return answer;
    }

    public int solution2(int[] order) {
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < order.length; i++){
            stack.push(i+1);
            while(!stack.isEmpty()){
                if (stack.peek() == order[idx]){
                    stack.pop();
                    idx++;
                } else break;
            }
        }

        return idx;
    }
}
