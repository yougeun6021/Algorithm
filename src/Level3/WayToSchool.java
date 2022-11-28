package Level3;

import java.util.Arrays;

public class WayToSchool { //등굣길
    public static void main(String[] args) {
        int m =4;
        int n =3;
        int[][] puddles={{2,1}};
        System.out.println(solution2(m,n,puddles));

    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] way = new int[m][n];
        for (int[] puddle : puddles) {
            way[puddle[0] - 1][puddle[1] - 1] = 1;
        }
        return getWay(way,0,0,m,n);
    }

    public static int solution2(int m, int n, int[][] puddles) {
        int[][] way = new int[m][n];

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                way[i][j] = 1;
            }
        }

        for (int[] puddle : puddles) {
            int x = puddle[0]-1;

            int y = puddle[1]-1;
            way[x][y] = 0;

            if(x == 0){
                for(int i = y+1; i<n;i++){
                    way[0][i] = 0;
                }
            }

            if(y==0){
                for(int i=x+1; i<m;i++){
                    way[i][0] = 0;
                }
            }

        }


        for(int i=1;i<m;i++){
            for(int j=1; j<n;j++){
                if(way[i][j]!=0){
                    way[i][j] = (way[i-1][j]+way[i][j-1])% 1000000007;
                }

            }
        }

        return way[m-1][n-1];
    }

    public static int getWay(int[][] way,int a, int b,int m,int n){
        int count = 0;
        if(a==(m-1) && b==(n-1)){
            return 1;
        }

        if(a+1<m && way[a+1][b]==0){
            count+=getWay(way,a+1,b,m,n);
        }

        if(b+1<n && way[a][b+1]==0){
            count+= getWay(way,a,b+1,m,n);
        }

        return count%1000000007;

    }
}
