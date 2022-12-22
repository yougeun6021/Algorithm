package Level2;

import java.util.Arrays;

public class TableHashFunction { //테이블 해시 함수
    public static void main(String[] args) {
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        System.out.println(solution(data,col,row_begin,row_end));

    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,(o1, o2) -> o1[col-1]!=o2[col-1] ?o1[col-1]-o2[col-1] :o2[0]-o1[0]);
        for(int i=row_begin-1;i<row_end;i++){
            int si = 0;
            for(int j=0; j<data[i].length;j++){
                si += data[i][j] % (i+1);
            }
            answer = answer^si;

        }

        return answer;
    }
}
