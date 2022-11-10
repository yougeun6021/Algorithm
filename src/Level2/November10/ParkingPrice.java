package Level2.November10;

import java.util.*;

public class ParkingPrice { //주차 요금 계산
    public static void main(String[] args) {
        int[] fees = {1, 461, 1, 10};
        String[] records ={"00:00 1234 IN"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }

    public static int[] solution(int[] fees, String[] records) {
        HashMap<String,Integer> timeMap = new HashMap<>();

        for (String record : records) {
            String[] arr = record.split(" ");
            String[] timeArr = arr[0].split(":");
            int time = Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
            String number = arr[1];
            String action = arr[2];
            if (action.equals("IN")) {
                timeMap.put(number, timeMap.getOrDefault(number, 0) - time);
            } else {
                timeMap.put(number, timeMap.getOrDefault(number, 0) + time);
            }
        }

        for(String s:timeMap.keySet()){
            if(timeMap.get(s)<=0){
                timeMap.put(s,timeMap.get(s)+23*60+59);
            }
        }

        List<String> numberList = new ArrayList<>(timeMap.keySet());
        Collections.sort(numberList);

        int[] answer = new int[timeMap.size()];
        int index =0;

        for(String s: numberList){
            int time = timeMap.get(s);
            if(time<=fees[0]){
                answer[index++] = fees[1];
            }else{
                answer[index++] = (int) (fees[1]+Math.ceil((time-fees[0])/(double)fees[2])*fees[3]);
            }
        }

        return answer;
    }
}
