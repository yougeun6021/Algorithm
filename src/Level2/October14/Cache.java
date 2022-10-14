package Level2.October14;


import sun.misc.LRUCache;

import java.util.ArrayList;
import java.util.List;

public class Cache { //캐시
    public static void main(String[] args) {
        String[] cities = {"a", "a", "a", "b", "b", "b", "c", "c", "c"};
        int cacheSize = 3;
        System.out.println(solution(cacheSize,cities));

    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0){
            return 5*cities.length;
        }
        List<String> cacheList = new ArrayList<>();
        for (String city : cities) {
            if (cacheList.contains(city.toLowerCase())) {
                cacheList.remove(city.toLowerCase());
                cacheList.add(city.toLowerCase());
                answer++;
            } else {
                if (cacheList.size() == cacheSize) {
                    cacheList.remove(0);
                }
                cacheList.add(city.toLowerCase());
                answer += 5;
            }
            System.out.println(cacheList);
        }
        return answer;
    }
}
