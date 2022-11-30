package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class MakeSameQueueSum { // 두 큐 합 같게 만들기
    public static void main(String[] args) {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        System.out.println(solution(queue1,queue2));

    }

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int sum = 0;
        for(int i=0; i<queue1.length;i++){
            int value1 = queue1[i];
            int value2 = queue2[i];
            q1.add(value1);
            q2.add(value2);
            sum +=value1;
            sum -=value2;
        }
        if(sum%2==1){
            return -1;
        }
        while(sum!=0){
            if(sum>0){
                int peek1 = q1.poll();
                q2.add(peek1);
                sum -=2*peek1;
            }else{
                int peek2 = q2.poll();
                q1.add(peek2);
                sum +=2*peek2;
            }
            answer++;
            if(answer>=3*queue1.length){
                return -1;
            }
        }

        return answer;

    }
}
