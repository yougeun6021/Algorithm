package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ElectricalGrid {
    public static void main(String[] args) {
        int n =4;
        int[][] wires= {{1,2},{2,3},{3,4}};
        System.out.println(solution2(n,wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = 100;
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for (int[] wire : wires) {
            List<Integer> start = map.getOrDefault(wire[0], new ArrayList<>());
            List<Integer> end = map.getOrDefault(wire[1], new ArrayList<>());
            start.add(wire[1]);
            end.add(wire[0]);
            map.put(wire[0],start);
            map.put(wire[1],end);
        }
        for (int[] wire : wires) {
            int c1 = getCount(wire[0],wire[1], map);
            int c2 = getCount(wire[1],wire[0], map);
            answer = Math.min(answer,Math.abs(c1-c2));
        }
        return answer;
    }

    public static int getCount(int start, int ban, HashMap<Integer,List<Integer>> map){
        int count = 1;
        List<Integer> list = map.get(start);
        for(Integer s:list){
            if(s==ban){
                continue;
            }
            count+= getCount(s,start,map);
        }

        return count;
    }

    public static int solution2(int n, int[][] wires) {
        int answer = 100;
        int[][] node = new int[n][n];

        for (int[] wire : wires) {
            node[wire[0]-1][wire[1]-1] = 1;
            node[wire[1]-1][wire[0]-1] = 1;
        }

        for (int[] wire : wires) {
            int c1 = getCount2(wire[0]-1,wire[1]-1, node);
            int c2 = getCount2(wire[1]-1,wire[0]-1, node);
            answer = Math.min(answer,Math.abs(c1-c2));
        }
        return answer;
    }

    public static int getCount2(int start, int ban, int[][] node){
        int count = 1;
        for(int i=0; i<node.length;i++){
            if(i==ban){
                continue;
            }
            if(node[start][i]==1){
                count+= getCount2(i,start,node);
            }
        }

        return count;
    }
}
