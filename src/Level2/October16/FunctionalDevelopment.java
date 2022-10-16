package Level2.October16;

import java.util.ArrayList;
import java.util.List;

public class FunctionalDevelopment { //기능 개발
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        System.out.println(solution(progresses, speeds));

    }
    public static List<Integer> solution(int[] progresses, int[] speeds) {
        int [] day = new int[progresses.length];
        List<Integer> list  = new ArrayList<>();
        int count =1;
        int maxDay = (int) Math.ceil((100-progresses[0])/(double)speeds[0]);
        for(int i=1;i<progresses.length;i++){
            day[i] = (int) Math.ceil((100-progresses[i])/(double)speeds[i]);
            if(maxDay>=day[i]){
                count++;
            }else{
                list.add(count);
                maxDay=day[i];
                count=1;
            }
        }
        list.add(count);
        return list;
    }
}
