package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Camouflage { //위장
    public static void main(String[] args) {
        String[][] clothes ={{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        System.out.println(solution(clothes));

    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hashMap = new HashMap<>();
        for (String[] clothe : clothes) {
            hashMap.put(clothe[1], hashMap.getOrDefault(clothe[1], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(hashMap.values());
        for (Integer integer : list) {
            answer = answer * (integer+1);
        }

        return answer-1;
    }

}
