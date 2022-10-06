package Level1.October6;

import java.util.Arrays;

public class KthNumber { // k번쨰 수
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};
        System.out.println(Arrays.toString(solution(array, commands)));


    }

    public static int[] solution(int[] array, int[][] commands) {  //copyOfrange
        int[] answer = new int[commands.length];
        int index =0;
        for(int i=0; i< commands.length;i++){
            int [] arr2 = new int[commands[i][1]-commands[i][0]+1];
            for(int j=commands[i][0]-1; j<commands[i][1];j++){
                arr2[index] = array[j];
                index++;
            }
            Arrays.sort(arr2);
            answer[i] = arr2[commands[i][2]-1];
            index = 0;
        }

        return answer;
    }
}
