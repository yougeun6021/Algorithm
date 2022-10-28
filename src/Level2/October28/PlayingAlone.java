package Level2.October28;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayingAlone { //혼자 놀기의 달인
    public static void main(String[] args) {
        int[] cards={8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }

    public static int solution(int[] cards) {
        int count =0;
        int index;
        int beforeIndex;
        List<Integer> list =new ArrayList<>();
        for(int i=0;i<cards.length;i++){
            index =i;
            beforeIndex = index;

            if(cards[index]==0){
                continue;
            }

            while (cards[index]!=0){
                index =  cards[index]-1;
                cards[beforeIndex] = 0;
                beforeIndex = index;
                count++;
            }
            list.add(count);
            count=0;
        }

        list.sort(Collections.reverseOrder());

        if(list.size()==1){
            return 0;
        }

        return list.get(0)*list.get(1) ;
    }
}
