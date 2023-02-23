package Level2;

import java.util.Arrays;

public class TicTacToe { //혼자서 하는 틱택토
    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"};
        System.out.println(solution(board));

        //1. O가 이긴다  oCount-xCount = 1
        //2. X가 이긴다  oCount-xCount = 0
        //3. 둘 다 못이긴다. Ocount - xCount = 0 or 1
        //4. 둘 다 이긴다 .  불가능


    }

    public static int solution(String[] board) {
        int oCount = 0;
        int[] row  = new int[3]; // 가로
        int[] col = new int[3];  // 세로
        int[] diagonal = new int[3]; // 대각선
        boolean oWin = false;
        boolean xWin = false;

        for(int i=0; i< board.length;i++){
            for(int j=0; j<board[i].length();j++){
                char ch = board[i].charAt(j);
                int value = 0;

                if(ch=='O'){
                    value = 1;
                }

                if(ch=='X'){
                    value = -1;
                }

                row[i] += value;
                col[j] += value;
                oCount += value;
                if(i==j){
                    diagonal[0] += value;
                }
                if(i+j==2){
                    diagonal[1] += value;
                }
            }
        }

        for(int i=0; i<3;i++){
            if(row[i]== 3 || col[i] == 3 || diagonal[i] == 3 ){
                oWin = true;
            }
            if(row[i]== -3 || col[i] == -3 || diagonal[i] == -3){
                xWin = true;
            }
        }


        if(!oWin && !xWin){  //둘 다 못이긴다. Ocount 0 or 1
            if(oCount == 0 || oCount == 1){
                return 1;
            }
        }

        if(xWin && !oWin){ // X가 이긴다  oCount = 0
            if(oCount==0){
                return 1;
            }
        }

        if(oWin && !xWin){ // O가 이긴다  oCount =  1
            if(oCount==1){
                return 1;
            }
        }

        return 0;
    }
}
