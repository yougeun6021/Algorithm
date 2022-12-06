package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distancing { //거리두기 확인하기
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));

    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0; i< places.length;i++){
            List<Matrix> matrixList = new ArrayList<>();
            for(int j=0; j<places[i].length;j++){
                for(int p=0; p<places[i][j].length();p++){
                    if(places[i][j].charAt(p)=='P'){
                        matrixList.add(new Matrix(j,p));
                    }
                }
            }
            answer[i] = isDistancing(matrixList,places[i]);
        }
        return answer;
    }

    static int isDistancing(List<Matrix> matrixList,String[] place){
        for(int i=0; i<matrixList.size()-1;i++){
            Matrix m1 = matrixList.get(i);
            int m1X = m1.getX();
            int m1Y = m1.getY();
            for(int j=i+1;j<matrixList.size();j++){
                Matrix m2 = matrixList.get(j);
                int m2X = m2.getX();
                int m2Y = m2.getY();
                int xDistance = Math.abs(m1X-m2X);
                int yDistance = Math.abs(m1Y-m2Y);
                int distance = xDistance+yDistance;
                if(distance<=1){
                    return 0;
                }
                if(distance==2){
                    if(xDistance==2){
                        if(place[(m1X+ m2X)/2].charAt(m1Y)=='O'){
                            return 0;
                        }
                    }
                    if(yDistance==2){
                        if(place[m1X].charAt((m1Y+m2Y)/2)=='O'){
                            return 0;
                        }
                    }
                    if(xDistance==1){
                        if(m1Y> m2Y){
                            if(place[m1X].charAt(m1Y-1)=='O' || place[m2X].charAt(m2Y+1)=='O') {
                                return 0;
                            }

                        }else{
                            if(place[m1X].charAt(m1Y+1)=='O' || place[m2X].charAt(m2Y-1)=='O') {
                                return 0;
                            }
                        }
                    }
                }
            }

        }

        return 1;


    }

    static class Matrix{
        int x;
        int y;

        Matrix(int x,int y){
            this.x=  x;
            this.y = y;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }
    }
}
