package Level2.October26;

import java.util.HashMap;
import java.util.HashSet;

public class RollCake { //롤케이크 자르기
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution2(topping));

    }

    public static int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> meSet = new HashSet<>();
        HashSet<Integer> brotherSet = new HashSet<>();
        for(int i=0; i< topping.length-1;i++){
            meSet.add(topping[i]);

            for(int j=i+1; j< topping.length;j++){
                brotherSet.add(topping[j]);
            }

            if(meSet.size()== brotherSet.size()){
                answer++;
            }

            if(meSet.size()> brotherSet.size()){
                break;
            }

            brotherSet.clear();
        }
        return answer;
    }

    public static int solution2(int[] topping) {
        int answer = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for(int j :topping){
            hashMap.put(j,hashMap.getOrDefault(j,0)+1);
        }

        for (int j : topping) {
            hashSet.add(j);
            hashMap.replace(j, hashMap.get(j) - 1);
            if (hashMap.get(j) == 0) {
                hashMap.remove(j);
            }
            if (hashSet.size() == hashMap.size()) {
                answer++;
            }
        }
        return answer;
    }

}
