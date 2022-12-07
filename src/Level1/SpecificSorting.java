package Level1;

import java.util.*;

public class SpecificSorting { //특이한정렬
    public static void main(String[] args) {
        int[] numlist = {10000,20,36,47,40,6,10,7000};
        int n = 30;
        System.out.println(Arrays.toString(solution(numlist, n)));

    }

    public static int[] solution(int[] numlist, int n) {
        List<Integer> list = new ArrayList<>();
        for (int num : numlist) {
            list.add(num);
        }

        list.sort((o1, o2) -> Math.abs(o1-n)==Math.abs(o2-n)?o2-o1:Math.abs(o1-n)-Math.abs(o2-n));

        for(int i=0; i<list.size();i++){
            numlist[i] = list.get(i);
        }

        return numlist;
    }

}
