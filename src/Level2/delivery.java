package Level2;

import java.util.*;

public class delivery { //배달
    public static void main(String[] args) {
        int N = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}; // {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}},{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}
        int K = 4;
        System.out.println(solution(N,road,K));
    }

    public static int solution(int N, int[][] road, int K) {
        HashMap<Integer, List<DestinationTime>> map = new HashMap<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i=1; i<=N; i++){
            map.put(i,new ArrayList<>());
        }

        for (int[] r : road) {
            int v1 = r[0];
            int v2 = r[1];
            DestinationTime destinationTime = new DestinationTime(v2, r[2]);
            DestinationTime destinationTime2 = new DestinationTime(v1,r[2]);
            List<DestinationTime> v1List = map.get(v1);
            List<DestinationTime> v2List= map.get(v2);
            v1List.add(destinationTime);
            v2List.add(destinationTime2);
            map.put(v1, v1List);
            map.put(v2,v2List);
        }


        List<DestinationTime> list = map.get(1);

        hashSet = dfs(list,map,K,hashSet,1);
        System.out.println(hashSet);

        return hashSet.size();
    }

    public static HashSet<Integer> dfs(List<DestinationTime> list , HashMap<Integer,List<DestinationTime>> map, int K,HashSet<Integer> hashSet,int start){
        if(K>=0){
            hashSet.add(start);
            for (DestinationTime destinationTime : list) {
                start = destinationTime.getDestination();
                int time = K - destinationTime.getTime();
                if (time >= 0) {
                        dfs(map.get(start), map, time, hashSet, start);
                }
            }
        }

        return hashSet;
    }




    static class DestinationTime {
        int destination;
        int time;

        public DestinationTime(int destination,int time){
            this.destination = destination;
            this.time = time;
        }

        public int getDestination() {
            return destination;
        }

        public int getTime() {
            return time;
        }

        @Override
        public String toString() {
            return "DestinationTime{" +
                    "destination=" + destination +
                    ", time=" + time +
                    '}';
        }
    }
}
