package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DesertIslandTravel {
    public static void main(String[] args) {
        String[] maps = {"X591X","X1X5X","X231X", "1XXX1"};
        System.out.println(Arrays.toString(solution(maps)));

    }

    public static int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0; i<maps.length;i++){
            for(int j=0; j<maps[0].length();j++){
                if(!visited[i][j] && maps[i].charAt(j)!='X'){
                    visited[i][j] = true;
                    list.add(getDay(maps,i,j,visited,direction));
                }
            }
        }

        if(list.size()==0){
            return new int[]{-1};
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }


        return answer;
    }

    static int getDay(String[] maps,int x,int y,boolean[][] visited,int[][] direction){
        int sum = 0;
        sum+= Character.getNumericValue(maps[x].charAt(y));
        for (int[] d: direction) {
            int dx = x + d[0];
            int dy = y + d[1];
            if (dx >= 0 && dy >= 0 && dx < maps.length && dy < maps[0].length() && !visited[dx][dy] && maps[dx].charAt(dy)!='X') {
                visited[dx][dy] = true;
                sum+=getDay(maps, dx, dy, visited, direction);
            }
        }

        return sum;
    }
}
