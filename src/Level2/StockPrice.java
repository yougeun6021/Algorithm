package Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StockPrice { //주식가격
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution(prices)));

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        int time = 0;
        for(int price: prices){
            queue.add(price);
        }
        while (!queue.isEmpty()){
            int price = queue.poll();
            for(Integer p:queue){
                time++;
                if(p<price){
                    break;
                }
            }
            answer[index++] = time;
            time =0;
        }
        return answer;
    }
}
