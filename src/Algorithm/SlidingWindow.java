package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class SlidingWindow {
    public static void main(String[] args) {
        int [] arr = {1,5,4,3,6,1,2,4,2,1}; // 배열
        int k = 3; // 배열 크기
        System.out.println(sumMaxSlidingWindow(arr,k));
        System.out.println(maxElementSlidingWindow(arr,k));


    }

    public static int sumMaxSlidingWindow(int[] arr,int k) { // 배열 크기에 해당하는 배열의 원소의 합이 가장큰 값

        int max =0;
        for(int i=0; i<k; i++){
            max += arr[i];
        }

        for(int i=k; i<arr.length;i++){
            int value = max-arr[i-k]+arr[i];

            max = Math.max(max,value);
        }

        return max;
    }

    public static List<Integer> maxElementSlidingWindow(int[] arr,int k) { // 배열 크기에 해당하는 배열의 원소 중 가장 큰값
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            queue.add(arr[i]);
        }

        list.add(queue.element());

        for(int i=k; i<arr.length;i++){
            queue.remove(arr[i-k]);
            queue.add(arr[i]);
            list.add(queue.element());
        }

        return list;
    }


}
