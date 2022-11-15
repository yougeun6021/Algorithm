package Level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindLowestValue { //최빈값 구하기
    public static void main(String[] args) {
        int[] array ={1, 2, 3, 3, 3, 4};
        System.out.println(solution(array));
    }

    public static int solution(int[] array) {
        HashMap<Integer,Integer> hashMap =new HashMap<>();
        for (int j : array) {
            hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(hashMap.keySet());
        if(list.size()==1){
            return list.get(0);
        }

        list.sort(((o1, o2) -> hashMap.get(o2)-hashMap.get(o1)));
        if(hashMap.get(list.get(0)).equals(hashMap.get(list.get(1)))){
            return -1;
        }

        return list.get(0) ;
    }
}
