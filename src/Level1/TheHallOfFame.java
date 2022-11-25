package Level1;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheHallOfFame { //명예의 전당 (1)
    public static void main(String[] args) {
        int k =3;
        int score[] = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(solution(k, score)));


    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i< score.length;i++){
            queue.add(score[i]);
            if(queue.size()>k){
                queue.remove();
            }
            answer[i] = queue.element();
        }
        return answer;
    }
}
