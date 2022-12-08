package Level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class DefenseGame { //디펜스 게임
    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        System.out.println(solution(n,k,enemy));

    }

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : enemy) {
            queue.add(e);
            n -= e;
            if (n < 0) {
                if(k==0){
                    return answer;
                }
                n = n + queue.poll();
                k--;
            }
            answer++;
        }

        return enemy.length;
    }


}
