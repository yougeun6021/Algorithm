package Level3.November5;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        System.out.println(Arrays.toString(solution2(operations)));
    }

    public static int[] solution(String[] operations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> reversePriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (String operation : operations) {
            String[] arr = operation.split(" ");
            int value = Integer.parseInt(arr[1]);
            if (arr[0].equals("I")) {
                priorityQueue.add(value);
                reversePriorityQueue.add(value);
            } else {
                if (arr[1].equals("1")) {
                    priorityQueue.remove(reversePriorityQueue.poll());
                } else {
                    reversePriorityQueue.remove(priorityQueue.poll());
                }
            }
        }

        if(priorityQueue.isEmpty()){
            return  new int[]{0,0};
        }else{
            return new int[]{reversePriorityQueue.poll(),priorityQueue.poll()};
        }
    }

    public static int[] solution2(String[] operations) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        int count =0;
        for (String operation : operations) {
            String[] arr = operation.split(" ");
            int value = Integer.parseInt(arr[1]);
            if (arr[0].equals("I")) {
                treeMap.put(value,count++);
            } else {
                if (arr[1].equals("1") && !treeMap.isEmpty()) {
                    treeMap.remove(treeMap.lastKey());
                }
                if (arr[1].equals("-1") && !treeMap.isEmpty()) {
                    treeMap.remove(treeMap.firstKey());
                }
            }
        }

        if(treeMap.isEmpty()){
            return new int[]{0,0};
        }else{
            return new int[]{treeMap.lastKey(), treeMap.firstKey()};
        }

    }
}
