package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChoiceTangerine {//귤 고르기

    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        System.out.println(solution(k,tangerine));

    }

    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer,Integer> map =new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2)-map.get(o1));

        for(Integer key:list){
            k -=map.get(key);
            answer++;
            if(k<=0){
                break;
            }
        }

        return answer;
    }

}
