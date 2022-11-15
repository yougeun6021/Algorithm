package Level1;

import java.util.HashMap;

public class SegmentLength { //겹치는 선분의 길이
    public static void main(String[] args) {
        int[][] lines = {{-1,0},{0,1},{1,2}};
        System.out.println(solution(lines));
    }

    public static int solution(int[][] lines) {
        int answer = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int[] line : lines) {
            for (int j = Math.min(line[0],line[1]); j < Math.max(line[1],line[0]); j++) {
                hashMap.put(j, hashMap.getOrDefault(j, 0) + 1);
            }
        }
        for(Integer value: hashMap.values()){
            if(value>1){
                answer++;
            }
        }

        return answer;
    }
}
