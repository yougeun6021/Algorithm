package Level1.October10;

import java.util.Arrays;

public class Lotto { //로또 최고순위와 최저순위
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int numZero = 0;
        int ranking = 7;
        Arrays.sort(win_nums);
        for(int i=0; i<6;i++){
            int key = lottos[i];
            if(lottos[i] ==0){
                numZero++;
            }
            if(Arrays.binarySearch(win_nums,key)>-1){
                ranking--;
            }
//            if(Arrays.stream(win_nums).anyMatch(n->n==key)){
//                ranking--;
//            }


        }
        if(ranking>5){
            if(numZero==0){
                return new int[]{6,6};
            }
            return new int[]{ranking-numZero,6};
        }


        return new int[]{ranking-numZero,ranking};
    }

}
