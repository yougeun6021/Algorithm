package Level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class ProceedingHomeWork { //과제 진행하기
    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(Arrays.toString(solution(plans)));
    }

    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<Plan> planQueue = new PriorityQueue<>((o1, o2) -> o1.startTime - o2.startTime);
        Stack<Plan> planStack = new Stack<>();
        int index = 0;
        int currentTime = 0;

        getPriorityQueue(plans, planQueue);

        while (!planQueue.isEmpty()) {

            if (planStack.isEmpty()) {
                currentTime = planQueue.peek().startTime;
                planStack.add(planQueue.poll());
            } else {
                Plan currentPlan = planStack.peek();
                Plan afterPlan = planQueue.peek();

                if(currentTime+currentPlan.playTime > afterPlan.startTime){
                    currentPlan.playTime -= afterPlan.startTime-currentTime;
                    currentTime = afterPlan.startTime;
                    planStack.push(planQueue.poll());
                }else{
                    currentTime += currentPlan.playTime;
                    answer[index++] = planStack.pop().name;
                }

            }


        }

        while (!planStack.isEmpty()) {
            answer[index++] = planStack.pop().name;
        }

        return answer;
    }

    private static void getPriorityQueue(String[][] plans, PriorityQueue<Plan> priorityQueue) {
        for (String[] plan : plans) {
            String name = plan[0];
            String[] timeArr = plan[1].split(":");
            int startTime = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            int playTime = Integer.parseInt(plan[2]);
            priorityQueue.add(new Plan(name, startTime, playTime));
        }
    }

    static class Plan {
        String name;
        int startTime;
        int playTime;

        public Plan(String name, int startTime, int playTime) {
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
    }


}
