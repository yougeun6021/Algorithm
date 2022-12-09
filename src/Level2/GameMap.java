package Level2;


import java.util.LinkedList;
import java.util.Queue;

public class GameMap { //게임 맵 최단거리
    public static void main(String[] args) {
        int[][] maps = {{1,0,0,0,0},{1,0,0,0,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        System.out.println(solution2(maps));

    }

    public static int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int answer = dfs(maps,visited,0,0,1);
        return answer==Integer.MAX_VALUE ? -1 : answer;
    }

    public static int solution2(int[][] maps) {
        int answer = -1;
        int height= maps.length;
        int width = maps[0].length;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int count = pos[2];
            visited[x][y] = true;
            if(x==height-1 && y==width-1){
                answer = count;
                break;
            }
            if(x<height-1 && maps[x+1][y]==1 && !visited[x+1][y]){
                queue.add(new int[]{x+1,y,count+1});
            }

            if(y<width-1 && maps[x][y+1]==1 && !visited[x][y+1] ){
                queue.add(new int[]{x,y+1,count+1});
            }

            if(x>0 && maps[x-1][y]==1 && !visited[x-1][y]){
                queue.add(new int[]{x-1,y,count+1});
            }

            if(y>0 && maps[x][y-1]==1 && !visited[x][y-1]){
                queue.add(new int[]{x,y-1,count+1});
            }
        }

        return answer;
    }

    public static int solution3(int[][] maps) {
        int answer = -1;
        int height= maps.length;
        int width = maps[0].length;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int count = pos[2];
            if(x==height-1 && y==width-1){
                answer = count;
                break;
            }
            if(x<height-1 && maps[x+1][y]==1 && !visited[x+1][y]){
                queue.add(new int[]{x+1,y,count+1});
                visited[x+1][y] = true;
            }

            if(y<width-1 && maps[x][y+1]==1 && !visited[x][y+1] ){
                queue.add(new int[]{x,y+1,count+1});
                visited[x][y+1] = true;
            }

            if(x>0 && maps[x-1][y]==1 && !visited[x-1][y]){
                queue.add(new int[]{x-1,y,count+1});
                visited[x-1][y] = true;
            }

            if(y>0 && maps[x][y-1]==1 && !visited[x][y-1]){
                queue.add(new int[]{x,y-1,count+1});
                visited[x][y-1] = true;
            }
        }

        return answer;
    }


    public static int dfs(int[][]maps,boolean[][]visited,int x,int y,int depth){
        int answer = Integer.MAX_VALUE;
        int height= maps.length;
        int width = maps[0].length;
        visited[x][y] = true;


        if(x==height-1 && y==width-1){
            visited[x][y] = false;
            return depth;
        }

        if(x<height-1 && maps[x+1][y]==1 && !visited[x+1][y]){
            answer = Math.min(answer,dfs(maps,visited,x+1,y,depth+1));
        }

        if(y<width-1 && maps[x][y+1]==1 && !visited[x][y+1] ){
            answer = Math.min(answer,dfs(maps,visited,x,y+1,depth+1));
        }

        if(x>0 && maps[x-1][y]==1 && !visited[x-1][y]){
            answer = Math.min(answer,dfs(maps,visited,x-1,y,depth+1));
        }

        if(y>0 && maps[x][y-1]==1 && !visited[x][y-1]){
            answer = Math.min(answer,dfs(maps,visited,x,y-1,depth+1));
        }

        visited[x][y] = false;

        return answer;
    }

}
