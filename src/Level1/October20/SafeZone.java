package Level1.October20;


public class SafeZone { //안전지대
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 0, 0},{0, 0, 0, 1, 0},{0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int[][] safeArr = new int[board.length+2][board[0].length+2];
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j]==1){
                    safeArr[i+1][j] = 1;
                    safeArr[i+1][j+1] = 1;
                    safeArr[i+1][j+2] = 1;
                    safeArr[i][j] = 1;
                    safeArr[i][j+1] = 1;
                    safeArr[i][j+2] = 1;
                    safeArr[i+2][j] = 1;
                    safeArr[i+2][j+1] = 1;
                    safeArr[i+2][j+2] = 1;
                }
            }

        }

        for(int i=1; i<safeArr.length-1;i++){
            for(int j=1; j< safeArr[0].length-1;j++){
                if(safeArr[i][j]==0){
                    answer++;
                }
            }

        }
        return answer;
    }
}
