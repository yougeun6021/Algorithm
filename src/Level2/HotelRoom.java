package Level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HotelRoom { //호텔 대실
    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(book_time));

    }
    public static int solution(String[][] book_time) {
        int answer = 0;
        int[][] time = new int[book_time.length][2];
        for(int i=0; i<book_time.length;i++){
            time[i][0] = getTime(book_time[i][0]);
            time[i][1] = getTime(book_time[i][1])+10;
        }
        Arrays.sort(time,(o1, o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]> count = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        for(int[] t:time){

            while (!count.isEmpty() && count.peek()[1]<=t[0]){
                count.poll();
            }
            count.add(t);
            answer = Math.max(answer, count.size());

        }
        return answer;
    }

    static int getTime(String bookTime){
        String[] timeArr = bookTime.split(":");
        return Integer.parseInt(timeArr[0])*60+Integer.parseInt(timeArr[1]);
    }

}
