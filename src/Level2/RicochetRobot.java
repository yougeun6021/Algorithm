package Level2;

import java.util.*;

public class RicochetRobot { // 리코쳇 로봇
    public static void main(String[] args) {
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        int answer = -1;
        int startX = 0;
        int startY = 0;
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        boolean[][] visited = new boolean[board[0].length()][board.length];
        for(int i=0; i< board.length;i++){
            for(int j=0; j<board[0].length();j++){
                if(board[i].charAt(j)=='R'){
                    startX = j;
                    startY = i;
                }
                if(board[i].charAt(j)=='D'){
                    list.add(new int[]{j,i});
                }
            }
        }

        queue.add(new int[]{startX,startY,0});
        visited[startX][startY]= true;

        while (!queue.isEmpty()){
            int[] coordinate = queue.poll();
            int x = coordinate[0];
            int y = coordinate[1];
            int count = coordinate[2];
            PriorityQueue<int[]> left = new PriorityQueue<>((o1, o2) -> o2[0]-o1[0]);
            PriorityQueue<int[]> right = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
            PriorityQueue<int[]> up = new PriorityQueue<>((o1, o2) -> o2[1]-o1[1]);
            PriorityQueue<int[]> down = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
            if(count!=0 && board[y].charAt(x)=='G'){
                answer = count;
                break;
            }
            for (int[] e : list) {
                if(x==e[0]){
                    if(y>e[1]){
                        getPriorityQueue(x,e[1]+1,up,count,visited);
                    }else{
                        getPriorityQueue(x,e[1]-1,down,count,visited);
                    }
                }
                if(y==e[1]){
                    if(x>e[0]){
                        getPriorityQueue(e[0]+1,y,left,count,visited);
                    }else{
                        getPriorityQueue(e[0]-1,y,right,count,visited);
                    }
                }
            }
            addQueue(x,0,count,up,queue,visited);
            addQueue(x,board.length-1,count,down,queue,visited);
            addQueue(0,y,count,left,queue,visited);
            addQueue(board[0].length()-1,y,count,right,queue,visited);

        }

        return answer;
    }

    private static void getPriorityQueue(int dx,int dy,PriorityQueue<int[]> pq,int count,boolean[][] visited){
        pq.add(new int[]{dx,dy,count+1});
    }

    private static void addQueue(int dx,int dy,int count,PriorityQueue<int[]> pq,Queue<int[]> q, boolean[][] visited){
        if(pq.isEmpty()){
            if(!visited[dx][dy]){
                visited[dx][dy] = true;
                q.add(new int[]{dx,dy,count+1});
            }
        }else{
            int[] element = pq.poll();
            int x = element[0];
            int y = element[1];
            if(!visited[x][y]){
                visited[x][y] = true;
                q.add(element);
            }
        }
    }




}
