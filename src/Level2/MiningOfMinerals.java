package Level2;

import java.util.PriorityQueue;

public class MiningOfMinerals { // 광물캐기
    public static void main(String[] args) {
        int[] picks = {1,1,0};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone","iron", "iron", "diamond","diamond"};
        System.out.println(solution(picks, minerals));

    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> (25*o2[0]+5*o2[1]+o2[2])-(25*o1[0]+5*o1[1]+o1[2]));
        int[][] fatigability = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        int pickIndex = 0;
        int pickNumber = picks[0]+picks[1]+picks[2];
        getPriorityQueue(minerals, priorityQueue,pickNumber);
        while (!priorityQueue.isEmpty()){
            int[] countArr = priorityQueue.poll();
            while (pickIndex != 3 && picks[pickIndex] == 0) {
                pickIndex++;
            }
            if(pickIndex==3){
                break;
            }
            for(int i = 0; i< countArr.length; i++){
                answer += countArr[i]* fatigability[pickIndex][i];
            }
            picks[pickIndex]--;
        }

        return answer;
    }


    private static void getPriorityQueue(String[] minerals, PriorityQueue<int[]> priorityQueue,int pickNumber) {
        int[] countArr = new int[3];
        int count = 0;
        for (String mineral : minerals) {
            switch (mineral) {
                case "diamond":
                    countArr[0]++;
                    break;
                case "iron":
                    countArr[1]++;
                    break;
                case "stone":
                    countArr[2]++;
                    break;
            }
            count++;
            if(count==5){
                priorityQueue.add(countArr);
                count =0;
                countArr = new int[3];
                if(priorityQueue.size()==pickNumber){
                    break;
                }
            }
        }
        priorityQueue.add(countArr);
    }

}

