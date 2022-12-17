package Level2;

public class BigRectangle { //가장 큰정사각형 찾기
    public static void main(String[] args) {
        int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};  //{{0,0,1,1},{1,1,1,1}};
        System.out.println(solution2(board));

    }

    public static int solution(int [][]board) {
        int answer = 1;
        int[][] arr = new int[board.length-1][board[0].length-1];
        boolean correct = false;

        if(isZero(board)){
            return 0;
        }

        while (board.length!=1){
            for(int i=0; i<board.length-1;i++){
                for(int j=0; j<board[0].length-1;j++){
                    if(board[i][j]+board[i][j+1]+board[i+1][j]+board[i+1][j+1] == 4){
                        arr[i][j] = 1;
                        correct = true;
                    }else{
                        arr[i][j] = 0;
                    }
                }
            }

            if(correct){
                answer++;
                board = arr;
                arr = new int[arr.length-1][arr[0].length-1];
                correct =false;
            }else{
                break;
            }
        }

        return answer*answer;
    }

    public static int solution2(int [][]board) {
        int answer = 1;

        if(isZero(board)){
            return 0 ;
        }

        for(int i =1; i<board.length;i++){
            for(int j=1; j<board[0].length;j++){
                if(board[i][j] == 0){
                    continue;
                }
                int value = Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1])+1;
                board[i][j] = value;
                answer = Math.max(value,answer);
            }
        }


        return answer*answer;
    }

    static boolean isZero(int[][] arr){
        int sum = 0;
        for(int i=0; i<arr.length;i++){
            for(int j=0; j<arr[0].length;j++){
                sum+= arr[i][j];
            }
        }

        if(sum==0){
            return true;
        }

        return false;
    }


}
