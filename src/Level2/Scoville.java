package Level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Scoville { //스코빌
    public static void main(String[] args) {
        int[] scoville = {1,3,2,4,5};
        int k = 7;
        System.out.println(solution2(scoville,k));

    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        int index = 0;
        Arrays.sort(scoville);
        while(scoville[index]<K){
            if(index==scoville.length-1){
                return -1;
            }
            scoville[index+1] = scoville[index]+2*scoville[index+1];
            scoville[index] =0;
            index++;
            answer++;
            Arrays.sort(scoville);
        }
        return answer;
    }

    public static int solution2(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int j : scoville) {
            priorityQueue.add(j);
        }

        while(priorityQueue.peek()<K){
            if(priorityQueue.size()==1){
                return -1;
            }
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            System.out.println(first);
            System.out.println(second);
            priorityQueue.add(first+2*second);
            System.out.println(priorityQueue);
            answer++;
        }

        return answer;
    }


}
