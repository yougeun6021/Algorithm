package Level3;

import java.util.*;

public class FarNode { // 가장 먼 노드
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(n,edge));

    }

    public static int solution(int n, int[][] edge) {
        int answer = 1;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,0));
        PriorityQueue<Integer> pq  = new PriorityQueue<>(Collections.reverseOrder());
        boolean[] visited = new boolean[n+1];
        visited[1] = true;

        for(int[] e:edge){
            int a = e[0];
            int b = e[1];
            List<Integer> aList = map.getOrDefault(a,new ArrayList<>());
            List<Integer> bList = map.getOrDefault(b,new ArrayList<>());
            aList.add(b);
            bList.add(a);
            map.put(a,aList);
            map.put(b,bList);
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int number = node.getNumber();
            int distance = node.getDistance();
            List<Integer> wayList = map.get(number);
            for(Integer way:wayList){
                if(!visited[way]){
                    queue.add(new Node(way,distance+1));
                    pq.add(distance+1);
                    visited[way] = true;
                }
            }
        }


        int max = pq.poll();
        while (true){
            int val = pq.poll();
            if(val!=max){
                break;
            }
            answer++;
        }

        return answer;
    }

    static class Node{
        int number;
        int distance;

        Node(int number, int distance){
            this.number = number;
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }

        public int getNumber() {
            return number;
        }
    }
}
