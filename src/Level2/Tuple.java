package Level2;

import java.util.*;

public class Tuple { //튜플
    public static void main(String[] args) {
        String s= "{{20,111},{111}}";
        System.out.println(Arrays.toString(solution(s)));

    }

    public static int[] solution(String s) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        String[] arr = s.replaceAll("[{}]","").split(",");
        for (String value : arr) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }
        List<String> list = new ArrayList<>(hashMap.keySet());
        list.sort(((o1, o2) -> hashMap.get(o2).compareTo(hashMap.get(o1))));

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] =Integer.parseInt(list.get(i));
        }

        return answer;
    }
}
