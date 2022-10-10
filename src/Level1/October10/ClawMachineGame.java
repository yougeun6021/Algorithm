package Level1.October10;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class ClawMachineGame { //인형뽑기
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int[][] board2 ={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,2,3,4};
        int[] moves2 = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board,moves));

    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> dollList =new ArrayList<>();

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    dollList.add(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }

            }

        }
        for (int i = 0; i < dollList.size() - 1; i++) {

            if (dollList.get(i).equals(dollList.get(i + 1)) ) {

                dollList.remove(i);
                dollList.remove(i);
                answer = answer + 2;

                i = -1;
            }
        }

        return answer;
    }

    public static int solution2(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (stack.isEmpty()) {
                        stack.push(board[j][move - 1]);
                        board[j][move - 1] = 0;
                        break;
                    }
                    if (board[j][move - 1] == stack.peek()) {
                        stack.pop();
                        answer += 2;
                    } else
                        stack.push(board[j][move - 1]);
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

}
