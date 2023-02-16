package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class EscapeMaze {
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXE",};
        System.out.println(solution(maps));

    }

    public static int solution(String[] maps) {
        int answer;
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Coordinate start = new Coordinate();
        Coordinate end = new Coordinate();
        Coordinate lever = new Coordinate();

        getCoordinate(maps,start,'S');
        getCoordinate(maps,lever,'L');
        getCoordinate(maps,end,'E');

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);
        visited[start.getX()][start.getY()] = true;
        int leverX = lever.getX();
        int leverY = lever.getY();

        answer = getDistance(maps, direction, visited, lever, queue, leverX, leverY);

        if(answer==-1){
            return -1;
        }

        queue.clear();
        visited = new boolean[maps.length][maps[0].length()];
        queue.add(lever);
        int endX = end.getX();
        int endY = end.getY();

        answer = getDistance(maps,direction,visited,end,queue,endX,endY);


        return answer;
    }

    private static int getDistance(String[] maps, int[][] direction, boolean[][] visited, Coordinate destination, Queue<Coordinate> queue, int destinationX, int destinationY) {
        int distance = -1;
        while (!queue.isEmpty()){
            Coordinate coordinate = queue.poll();
            int x = coordinate.getX();
            int y = coordinate.getY();
            int count = coordinate.getCount();

            if(x == destinationX && y== destinationY){
                distance = count;
                destination.setCount(count);
                break;
            }

            for (int[] d : direction) {
                int dx = x+d[0];
                int dy = y+d[1];

                if(dx>=0 && dx< maps.length && dy>=0 && dy< maps[0].length() && (maps[dx].charAt(dy)=='O' || maps[dx].charAt(dy) =='L' || maps[dx].charAt(dy) =='E' && maps[dx].charAt(dy) =='S') && !visited[dx][dy]){
                    visited[dx][dy] = true;
                    queue.add(new Coordinate(dx,dy,count+1));
                }
            }
        }
        return distance;
    }

    private static void getCoordinate(String[] maps, Coordinate coordinate,char ch) {
        for(int i = 0; i< maps.length; i++){
            for(int j = 0; j< maps[i].length(); j++){
                if(maps[i].charAt(j)==ch){
                    coordinate.setX(i);
                    coordinate.setY(j);
                    coordinate.setCount(0);
                }
            }
        }
    }


    static class Coordinate{
        int x;

        int y;

        int count;
        public Coordinate() {
        }
        public Coordinate(int x, int y,int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
