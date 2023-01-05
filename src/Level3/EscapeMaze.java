package Level3;

import java.util.ArrayList;
import java.util.List;

public class EscapeMaze { // 미로탈출명령어
    public static void main(String[] args) {
        int n = 2;
        int m = 2;
        int x = 1;
        int y = 1;
        int r = 2;
        int c = 2;
        int k = 2;
        System.out.println(solution(n,m,x,y,r,c,k));

    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        if((k-Math.abs(x-r)+Math.abs(c-y))%2==1){
            return "impossible";
        }

        String answer;
        StringBuilder sb= new StringBuilder();
        Direction[] direction = {new Direction(1,0,"d"),new Direction(0,-1,"l"),new Direction(0,1,"r"),new Direction(-1,0,"u")};
        answer = dfs(n,m,x,y,r,c,k,direction,sb,0);


        if(answer.equals("z")){
            return "impossible";
        }

        return answer;
    }

    static String dfs(int n, int m, int x, int y, int r, int c, int k,Direction[] direction,StringBuilder sb,int depth){
        String answer = "z";

        if(Math.abs(x-r)+Math.abs(c-y)>k-depth){
            return "z";
        }

        if(depth==k){
            if(x==r && y==c){
                return sb.toString();
            }
            return "z";
        }
        for(Direction d:direction){
            int a = d.getX();
            int b = d.getY();
            if(x+a>=1 && y+b>=1 && x+a<=n && y+b<=m){
                sb.append(d.getName());
                String str = dfs(n,m,x+a,y+b,r,c,k,direction,sb,depth+1);
                if(answer.compareTo(str)>0){
                    answer = str;
                    break;
                }
            }
            sb.setLength(depth);
        }

        return answer;
    }

    static class Direction{
        int x;
        int y;
        String name;

        Direction(int x,int y,String name){
            this.x = x;
            this.y = y;
            this.name = name;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getName() {
            return name;
        }
    }
}
