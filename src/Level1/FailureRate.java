package Level1;

import java.util.*;

public class FailureRate { //실패율
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {3,3,3,3};
        System.out.println(Arrays.toString(solution(N, stages)));

    }

    public static int[] solution(int N, int[] stages) {
        HashMap<Integer,Double> map = new HashMap<>();
        double div = stages.length;
        for(int i=1; i<=N;i++){
            map.put(i,0.0);
        }
        for(int stage: stages){
            if(stage>N){
                continue;
            }
            map.put(stage,map.get(stage)+1);
        }
        for(int j=1; j<=N;j++){
            if(map.get(j)==0){
                continue;
            }
            map.put(j,map.get(j)/div);
            div = div-map.get(j)*div;
        }

        List<Integer> mapKeyList = new ArrayList<>(map.keySet());
        mapKeyList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        return Arrays.stream(mapKeyList.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();

    }
}
